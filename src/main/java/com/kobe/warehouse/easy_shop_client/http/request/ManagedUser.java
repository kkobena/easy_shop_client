package com.kobe.warehouse.easy_shop_client.http.request;

public class ManagedUser extends RequestBody {
  private String password;
  private String login;
  private String address;

  public String getAddress() {
    return address;
  }

  public ManagedUser setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public ManagedUser setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getLogin() {
    return login;
  }

  public ManagedUser setLogin(String login) {
    this.login = login;
    return this;
  }
}
