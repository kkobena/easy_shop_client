package com.kobe.warehouse.easy_shop_client.config;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Objects;

public class Restconfigurer {
  private static HttpClient httpClient;
  private static HttpRequest.Builder builder;

  public static HttpClient getHttpClient() {
    if (Objects.isNull(httpClient)) {
      httpClient =
          HttpClient.newBuilder()
              .authenticator(
                  new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(
                          ApplicationConfigurer.login,
                          ApplicationConfigurer.password.toCharArray());
                    }
                  })
              //    .connectTimeout(Duration.ofSeconds(10))
              .build();
    }
    return httpClient;
  }

  public static HttpClient getHttpClient(String login, String password) {

    httpClient =
        HttpClient.newBuilder()
            .authenticator(
                new Authenticator() {
                  @Override
                  protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(login, password.toCharArray());
                  }
                })
            .build();

    return httpClient;
  }

  public static HttpRequest.Builder buildHttpRequest() {

    if (Objects.isNull(builder)) {
      builder = HttpRequest.newBuilder();
      //  .uri(URI.create(ApplicationConfigurer.HOST + endPoint))
      //  .header(ApplicationConfigurer.SECRET_KET, ApplicationConfigurer.currentUserId + "");
    }
    return builder;
  }
}
