module com.kobe.warehouse.easy_shop_client {
  requires javafx.base;
  requires javafx.controls;
  requires javafx.web;
  requires javafx.fxml;
  requires org.controlsfx.controls;
//  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.bootstrapfx.core;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.ikonli.fontawesome5;
  requires org.kordamp.ikonli.materialdesign2;
  requires java.net.http;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.jsr310;
  requires java.logging;
  requires javafx.graphics;
  requires com.fazecast.jSerialComm;


  exports com.kobe.warehouse.easy_shop_client.view_model;
  exports com.kobe.warehouse.easy_shop_client.view_model.customer;
  exports com.kobe.warehouse.easy_shop_client.view_model.produit;
  exports com.kobe.warehouse.easy_shop_client.view_model.utils;
  exports com.kobe.warehouse.easy_shop_client.view_model.sale;
  exports com.kobe.warehouse.easy_shop_client.view_model.user;
  exports com.kobe.warehouse.easy_shop_client.http.response;
  exports com.kobe.warehouse.easy_shop_client.http.request;
  exports com.kobe.warehouse.easy_shop_client.http.error;
  exports com.kobe.warehouse.easy_shop_client.http.response.sale;
  exports com.kobe.warehouse.easy_shop_client.http.response.referentiel;

  opens com.kobe.warehouse.easy_shop_client to
      javafx.fxml;

  /*  opens com.kobe.warehouse.easy_shop_client.http.response to
        com.fasterxml.jackson.databind;
    opens com.kobe.warehouse.easy_shop_client.http.request to
        com.fasterxml.jackson.databind;
    opens com.kobe.warehouse.easy_shop_client.view_model to
        com.fasterxml.jackson.databind;
    opens com.kobe.warehouse.easy_shop_client.view_model.user to
        com.fasterxml.jackson.databind;
    opens com.kobe.warehouse.easy_shop_client.view_model.remise to
        com.fasterxml.jackson.databind;
    opens com.kobe.warehouse.easy_shop_client.view_model.utils to
        com.fasterxml.jackson.databind;  opens com.kobe.warehouse.easy_shop_client.view_model.sale to
        com.fasterxml.jackson.databind;
  */
  exports com.kobe.warehouse.easy_shop_client;


}
