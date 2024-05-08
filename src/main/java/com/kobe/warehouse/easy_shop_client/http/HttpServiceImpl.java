package com.kobe.warehouse.easy_shop_client.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.config.Restconfigurer;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.Pageable;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HttpServiceImpl<T> implements HttpService<T> {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private static HttpClient httpClient;
  private static HttpRequest.Builder requestBuilder;
  private static ObjectMapper objectMapper;
  private Class<T> type;

  static {
    httpClient = Restconfigurer.getHttpClient();
    requestBuilder = Restconfigurer.buildHttpRequest();
    objectMapper =
        new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());
  }

  public HttpServiceImpl(Class<T> type) {
    this.type = type;
  }

  @Override
  public T getOne(EasyShopHttpRequest param) {
    HttpRequest httpRequest =
        requestBuilder
            .uri(
                URI.create(
                    ApplicationConfigurer.HOST
                        + param.getEndPoint()
                        + buildQueryParams(param.getQueryParams())))
            .GET()
            .build();
    return sendRequest(httpRequest);
    //  return sendAndReturnList(httpRequest);
  }

  @Override
  public <R> R post(EasyShopHttpRequest param, Class<R> retour)
      throws RemoteException, ServerException {

    HttpRequest httpRequest =
        requestBuilder
            .uri(URI.create(ApplicationConfigurer.HOST + param.getEndPoint()))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(toJson(param.getBody())))
            .build();

    return sendRequest(httpRequest, retour);
  }

  @Override
  public <R> R put(EasyShopHttpRequest param, Class<R> retour)
      throws RemoteException, ServerException {
    HttpRequest httpRequest =
        requestBuilder
            .uri(URI.create(ApplicationConfigurer.HOST + param.getEndPoint()))
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(toJson(param.getBody())))
            .build();

    return sendRequest(httpRequest, retour);
  }

  public void deleteRequest(EasyShopHttpRequest param) {
    HttpRequest httpRequest =
        requestBuilder
            .uri(URI.create(ApplicationConfigurer.HOST + param.getEndPoint()))
            .DELETE()
            .build();

    send(httpRequest);
  }

  private enum Method {
    DELETE,
    GET,
    POST,
    PUT;

    public static Method getFrom(HttpRequest httpRequest) {
      return Arrays.stream(values())
          .filter(method -> method.name().equalsIgnoreCase(httpRequest.method()))
          .findFirst()
          .orElse(null);
    }
  }

  private boolean hasError(Method method, int statutCode) {
    boolean error = statutCode == 400 || statutCode == 500 || statutCode == 405;
    return switch (method) {
      case DELETE, PUT, POST -> error;
      case GET -> statutCode != 200;
    };
  }

  private T sendRequest(HttpRequest httpRequest) {
    try {

      HttpResponse<String> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      response.headers().map().forEach((k, v) -> System.err.println(k + " : " + v));
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {

        throw new RuntimeException(response.toString());
      }
      return parseJson(response.body());
    } catch (IOException | InterruptedException e) {
      log.log(Level.SEVERE, null, e);
      throw new RuntimeException(e);
    }
  }

  private <R> R sendRequest(HttpRequest httpRequest, Class<R> dtoResponse)
      throws RemoteException, ServerException {
    try {

      HttpResponse<String> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.err.println(response.statusCode());
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {
        throw parseJson(response.body(), RemoteException.class);
      }
      return parseJson(response.body(), dtoResponse);
    } catch (IOException | InterruptedException e) {
      log.log(Level.SEVERE, null, e);
      throw new ServerException(e.getMessage());
    }
  }

  private <R> R parseJson(String responseBody, Class<R> dtoResponse) {

    try {

      if (responseBody != null && !responseBody.isBlank()) {
        return objectMapper.readValue(responseBody, dtoResponse);
      }
      return null;
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private void send(HttpRequest httpRequest) {
    try {

      HttpResponse<Void> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {
        log.log(Level.WARNING, response.toString());
        throw new RuntimeException(response.toString());
      }
    } catch (IOException | InterruptedException e) {
      log.log(Level.SEVERE, null, e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<T> fetch(EasyShopHttpRequest param) {

    HttpRequest httpRequest =
        requestBuilder
            .uri(
                URI.create(
                    ApplicationConfigurer.HOST
                        + param.getEndPoint()
                        + buildQueryParams(param.getQueryParams())))
            .GET()
            .build();

    return sendAndReturnList(httpRequest);
  }

  @Override
  public Pageable<T> fetchWithPagination(EasyShopHttpRequest param) {

    HttpRequest httpRequest =
        requestBuilder
            .uri(
                URI.create(
                    ApplicationConfigurer.HOST
                        + param.getEndPoint()
                        + buildQueryParams(param.getQueryParams())))
            .GET()
            .build();

    return sendAndReturnPageable(httpRequest);
  }

  private String toJson(Object body) {

    try {
      var paload = objectMapper.writeValueAsString(body);

      return paload;
    } catch (JsonProcessingException e) {
      log.log(Level.SEVERE, e.getOriginalMessage());
      throw new RuntimeException(e);
    }
  }

  private List<T> getAsJson(String responseBody) {

    try {
      // return objectMapper.readValue(responseBody, new TypeReference<>(){});
      return objectMapper.readValue(
          responseBody,
          objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, type));
    } catch (JsonProcessingException e) {

      throw new RuntimeException(e);
    }
  }

  private Pageable<T> getAsPageableJson(HttpResponse<String> response) {

    try {
      // return objectMapper.readValue(responseBody, new TypeReference<>(){});
      return new Pageable<>(
          getTotal(response.headers()),
          objectMapper.readValue(
              response.body(),
              objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, type)));
    } catch (JsonProcessingException e) {

      throw new RuntimeException(e);
    }
  }

  private int getTotal(HttpHeaders headers) {

    return Integer.valueOf(headers.map().get(ApplicationConfigurer.HEADER_X_TOTAL_COUNT).get(0));
  }

  private T parseJson(String responseBody) {

    try {

      if (responseBody != null && !responseBody.isBlank()) {
        return objectMapper.readValue(responseBody, type);
      }
      return null;
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private Map<String, Object> convertObjectToMap(QueryParams queryParams) {
    return objectMapper.convertValue(queryParams, new TypeReference<>() {});
  }

  private String buildQueryParams(QueryParams queryParams) {
    if (Objects.isNull(queryParams)) return "";
    return "?"
        + convertObjectToMap(queryParams).entrySet().stream()
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(Collectors.joining("&"));
  }

  private List<T> sendAndReturnList(HttpRequest httpRequest) {
    try {

      HttpResponse<String> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {
        log.log(Level.INFO, response.toString());
        throw new RuntimeException(response.toString());
      }
      return getAsJson(response.body());
    } catch (IOException | InterruptedException e) {
      log.log(Level.SEVERE, null, e);
      throw new RuntimeException(e);
    }
  }

  private Pageable<T> sendAndReturnPageable(HttpRequest httpRequest) {
    try {

      HttpResponse<String> response =
          httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {
        log.log(Level.INFO, response.toString());
        throw new RuntimeException(response.toString());
      }
      return getAsPageableJson(response);
    } catch (IOException | InterruptedException e) {
      log.log(Level.SEVERE, null, e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public void authenticate(String login, String password) {

    try {
      HttpClient http = Restconfigurer.getHttpClient(login, password);
      HttpRequest httpRequest =
          requestBuilder.uri(URI.create(ApplicationConfigurer.HOST + "account")).GET().build();
      HttpResponse<String> response = http.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      if (hasError(Method.getFrom(httpRequest), response.statusCode())) {
        log.log(Level.INFO, response.toString());
        throw new RuntimeException(response.toString());
      }
      ApplicationConfigurer.currentUser.setValue(
          objectMapper.readValue(response.body(), UserInfo.class));
    } catch (IOException | InterruptedException e) {
      log.log(Level.INFO, null, e);
      throw new RuntimeException(e);
    }
  }
}
