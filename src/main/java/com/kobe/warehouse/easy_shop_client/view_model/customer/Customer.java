package com.kobe.warehouse.easy_shop_client.view_model.customer;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.beans.property.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = AssuredCustomer.class, name = "ASSURE"),
  @JsonSubTypes.Type(value = UninsuredCustomer.class, name = "STANDARD")
})
public abstract class Customer {
  private LongProperty id = new SimpleLongProperty(this, "id");
  private StringProperty firstName = new SimpleStringProperty(this, "firstName");
  private StringProperty lastName = new SimpleStringProperty(this, "lastName");
  private StringProperty email = new SimpleStringProperty(this, "email");
  private StringProperty fullName = new SimpleStringProperty(this, "fullName");
  private StringProperty abbrName = new SimpleStringProperty(this, "abbrName");
  private StringProperty phone = new SimpleStringProperty(this, "phone");
  private StringProperty code = new SimpleStringProperty(this, "code");
  private IntegerProperty encours = new SimpleIntegerProperty(this, "encours");

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
  }



  public String getFirstName() {
    return firstName.get();
  }

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public StringProperty lastNameProperty() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName.set(lastName);
  }

  public String getEmail() {
    return email.get();
  }

  public StringProperty emailProperty() {
    return email;
  }

  public void setEmail(String email) {
    this.email.set(email);
  }

  public String getFullName() {
    return fullName.get();
  }

  public StringProperty fullNameProperty() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName.set(fullName);
  }

  public String getAbbrName() {
    return abbrName.get();
  }

  public StringProperty abbrNameProperty() {
    return abbrName;
  }

  public void setAbbrName(String abbrName) {
    this.abbrName.set(abbrName);
  }

  public String getPhone() {
    return phone.get();
  }

  public StringProperty phoneProperty() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone.set(phone);
  }

  public String getCode() {
    return code.get();
  }

  public StringProperty codeProperty() {
    return code;
  }

  public void setCode(String code) {
    this.code.set(code);
  }

  public int getEncours() {
    return encours.get();
  }

  public IntegerProperty encoursProperty() {
    return encours;
  }

  public void setEncours(int encours) {
    this.encours.set(encours);
  }
}
