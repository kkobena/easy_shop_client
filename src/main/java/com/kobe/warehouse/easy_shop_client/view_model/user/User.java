package com.kobe.warehouse.easy_shop_client.view_model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kobe.warehouse.easy_shop_client.view_model.sale.Payment;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  private LongProperty id = new SimpleLongProperty(this, "id");
  private StringProperty login = new SimpleStringProperty(this, "login");
  private StringProperty firstName = new SimpleStringProperty(this, "firstName");
  private StringProperty lastName = new SimpleStringProperty(this, "lastName");
  private StringProperty email = new SimpleStringProperty(this, "email");
  private StringProperty fullName = new SimpleStringProperty(this, "fullName");
  private StringProperty abbrName = new SimpleStringProperty(this, "abbrName");
  private Set<String> authorities = new HashSet<>();
  private ObjectProperty<LocalDateTime> lastModifiedDate =
      new SimpleObjectProperty<>(this, "lastModifiedDate");

  @JsonIgnore
  private SetProperty<String> userAuthorities =
      new SimpleSetProperty<>(this, "userAuthorities",FXCollections.observableSet());

  public long getId() {
    return id.get();
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate.get();
  }

  public ObjectProperty<LocalDateTime> lastModifiedDateProperty() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate.set(lastModifiedDate);
  }

  public Set<String> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<String> authorities) {
    this.authorities = authorities;
    userAuthorities=new SimpleSetProperty<>(FXCollections.observableSet(authorities));
  }

  public ObservableSet<String> getUserAuthorities() {
    return userAuthorities.get();
  }

  public SetProperty<String> userAuthoritiesProperty() {
    return userAuthorities;
  }

  public void setUserAuthorities(ObservableSet<String> userAuthorities) {
    this.userAuthorities.set(userAuthorities);
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
  }

  public String getLogin() {
    return login.get();
  }

  public StringProperty loginProperty() {
    return login;
  }

  public void setLogin(String login) {
    this.login.set(login);
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

  /*
    public ObservableList<String> getAuthorities() {
      return authorities.get();
    }

    public ListProperty<String> authoritiesProperty() {
      return authorities;
    }

    public void setAuthorities(ObservableList<String> authorities) {
      this.authorities.set(authorities);
    }
  */
  public User() {
    //  Bindings.bindContent();

  }

  /*
  public class ListChangeEventExample {
    public static void main(String[] args) {
      ObservableList<String> strings =
              FXCollections.observableArrayList();
      strings.addListener(new MyListener());

      System.out.println("Calling addAll(\"Zero\"," +
              " \"One\", \"Two\", \"Three\"): ");
      strings.addAll("Zero", "One", "Two", "Three");

      System.out.println("Calling" +
              " FXCollections.sort(strings): ");
      FXCollections.sort(strings);

      System.out.println("Calling set(1, \"Three_1\"): ");
      strings.set(1, "Three_1");

      System.out.println("Calling setAll(\"One_1\"," +
              " \"Three_1\", \"Two_1\", \"Zero_1\"): ");
      strings.setAll("One_1", "Three_1", "Two_1", "Zero_1");

      System.out.println("Calling removeAll(\"One_1\"," +
              " \"Two_1\", \"Zero_1\"): ");
      strings.removeAll("One_1", "Two_1", "Zero_1");
    }

    private static class MyListener implements
            ListChangeListener<String> {
      @Override
      public void onChanged(
              Change<? extends String> change) {
        System.out.println("\tlist = " +
                change.getList());
        System.out.println(prettyPrint(change));
      }

      private String prettyPrint(
              Change<? extends String> change) {
        StringBuilder sb =
                new StringBuilder("\tChange event data:\n");
        int i = 0;
        while (change.next()) {
          sb.append("\t\tcursor = ")
                  .append(i++)
                  .append("\n");

          final String kind =
                  change.wasPermutated() ? "permutated" :
                          change.wasReplaced() ? "replaced" :
                                  change.wasRemoved() ? "removed" :
                                          change.wasAdded() ? "added" :
                                                  "none";

          sb.append("\t\tKind of change: ")
                  .append(kind)
                  .append("\n");

          sb.append("\t\tAffected range: [")
                  .append(change.getFrom())
                  .append(", ")
                  .append(change.getTo())
                  .append("]\n");

          if (kind.equals("added") ||
                  kind.equals("replaced")) {
            sb.append("\t\tAdded size: ")
                    .append(change.getAddedSize())
                    .append("\n");
            sb.append("\t\tAdded sublist: ")
                    .append(change.getAddedSubList())
                    .append("\n");
          }

          if (kind.equals("removed") ||
                  kind.equals("replaced")) {
            sb.append("\t\tRemoved size: ")
                    .append(change.getRemovedSize())
                    .append("\n");
            sb.append("\t\tRemoved: ")
                    .append(change.getRemoved())
                    .append("\n");
          }

          if (kind.equals("permutated")) {
            StringBuilder permutationSB =
                    new StringBuilder("[");
            int from = change.getFrom();
            int to = change.getTo();
            for (int k = from; k < to; k++) {
              int permutation =
                      change.getPermutation(k);
              permutationSB.append(k)
                      .append("->")
                      .append(permutation);
              if (k < change.getTo() - 1) {
                permutationSB.append(", ");
              }
            }
            permutationSB.append("]");
            String permutation =
                    permutationSB.toString();
            sb.append("\t\tPermutation: ")
                    .append(permutation).append("\n");
          }
        }
        return sb.toString();
      }
    }
  }*/
}
