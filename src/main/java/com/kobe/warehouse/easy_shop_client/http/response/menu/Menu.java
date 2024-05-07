package com.kobe.warehouse.easy_shop_client.http.response.menu;

import java.util.*;

public class Menu {
  private int id;

  private String libelle;
  private String iconJavaClient;

  private String name;

  private boolean root;

  private List<Menu> menus = new LinkedList<>();

  private Menu parent;

  public String getIconJavaClient() {
    return iconJavaClient;
  }

  public Menu setIconJavaClient(String iconJavaClient) {
    this.iconJavaClient = iconJavaClient;
    return this;
  }

  private boolean enable = true;

  public int getId() {
    return id;
  }

  public Menu setId(int id) {
    this.id = id;
    return this;
  }

  public String getLibelle() {
    return libelle;
  }

  public Menu setLibelle(String libelle) {
    this.libelle = libelle;
    return this;
  }

  public String getName() {
    return name;
  }

  public Menu setName(String name) {
    this.name = name;
    return this;
  }

  public boolean isRoot() {
    return root;
  }

  public Menu setRoot(boolean root) {
    this.root = root;
    return this;
  }

  public List<Menu> getMenus() {
    return menus;
  }

  public Menu setMenus(List<Menu> menus) {
    this.menus = menus;
    return this;
  }

  public Menu getParent() {
    return parent;
  }

  public Menu setParent(Menu parent) {
    this.parent = parent;
    return this;
  }

  public boolean isEnable() {
    return enable;
  }

  public Menu setEnable(boolean enable) {
    this.enable = enable;
    return this;
  }
}
