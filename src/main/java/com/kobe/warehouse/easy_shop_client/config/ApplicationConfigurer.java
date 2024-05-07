package com.kobe.warehouse.easy_shop_client.config;

import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ApplicationConfigurer {
    public static Long currentUserId;
  public static ObjectProperty<UserInfo> currentUser = new SimpleObjectProperty<>();
    public static final String HOST="http://localhost:8080/java-client/";
    public static boolean isAuthenticate;
    public static String password="admin";
    public static String login="admin";

}
