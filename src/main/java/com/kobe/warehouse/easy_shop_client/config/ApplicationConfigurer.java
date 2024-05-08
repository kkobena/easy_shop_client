package com.kobe.warehouse.easy_shop_client.config;

import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ApplicationConfigurer {
  public static ObjectProperty<UserInfo> currentUser = new SimpleObjectProperty<>();
  public static final String HOST = "http://localhost:8080/java-client/";
  public static String password = "admin";
  public static String login = "admin";
  public static ObjectProperty<RemoteException> remoteException = new SimpleObjectProperty<>();
  public static ObjectProperty<ServerException> serverException = new SimpleObjectProperty<>();
  public static final int ROWS_PER_PAGE = 10;
  public static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
}
