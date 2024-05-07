package com.kobe.warehouse.easy_shop_client.http.service.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.view_model.user.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Mock implements UserService {
  private AtomicLong atomicInteger = new AtomicLong(1);


  @Override
  public void authenticate(String login, String password) {

  }

  @Override
  public List<User> test() {
    ObjectMapper objectMapper =
        new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());
 /*   SimpleModule module = new SimpleModule();
    module.addDeserializer(ObservableList.class, new ObservableListDeserializer());
    objectMapper.registerModule(module);*/
    try {
      var json =
          "[{\"id\":1,\"activated\":false,\"lastModifiedDate\":[2024,5,1,12,38,12,217305900],\"authorities\":[\"A\",\"D\"],\"fullName\":\"KOFFI KOBENA\"}]";
      System.err.println(   objectMapper.writeValueAsString(fetchAll()));
      return objectMapper.readValue(json,
          objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<UserInfo> fetchAll() {
    List<UserInfo> userInfos = new ArrayList<>();
    UserInfo userInfo = new UserInfo();
    userInfo.setId(atomicInteger.getAndIncrement());
    userInfo.setFullName("KOFFI KOBENA");
    userInfo.setAuthorities(List.of("A","D"));
    userInfo.setLastModifiedDate(LocalDateTime.now());
    userInfos.add(userInfo);


    return userInfos;
  }
}
