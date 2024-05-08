package com.kobe.warehouse.easy_shop_client.view_model.utils;

import java.text.NumberFormat;
import java.util.Currency;

public class Formater {
  private static NumberFormat numberFormat = NumberFormat.getInstance();

  public static String formatIntegerToXOF(int value) {
    Currency currency = Currency.getInstance("XOF");
    numberFormat.setCurrency(currency);
    return numberFormat.format(value);
  }

  public static String formatIntegerToXOF(long value) {
    Currency currency = Currency.getInstance("XOF");
    numberFormat.setCurrency(currency);
    return numberFormat.format(value);
  }

  public static String formatIntegerToXOF(double value) {
    Currency currency = Currency.getInstance("XOF");
    numberFormat.setCurrency(currency);
    return numberFormat.format(value);
  }

  public static String formatIntegerToXOF(Integer value) {
    Currency currency = Currency.getInstance("XOF");
    numberFormat.setCurrency(currency);
    return numberFormat.format(value);
  }

  public static String formatIntegerToXOF(Long value) {
    Currency currency = Currency.getInstance("XOF");
    numberFormat.setCurrency(currency);
    return numberFormat.format(value);
  }

  public static String formatPhoneNumber(String phoneNumber) {
    if (phoneNumber == null) {
      return "";
    }
    if (phoneNumber.length() == 9) {
      return phoneNumber.substring(0, 3)
          + " "
          + phoneNumber.substring(3, 6)
          + " "
          + phoneNumber.substring(6, 9);
    }
    if (phoneNumber.length() == 10) {
      return phoneNumber.substring(0, 3)
          + " "
          + phoneNumber.substring(3, 6)
          + " "
          + phoneNumber.substring(6, 8)
          + " "
          + phoneNumber.substring(8, 10);
    }
    if (phoneNumber.length() == 8) {
      return phoneNumber.substring(0, 2)
          + " "
          + phoneNumber.substring(2, 4)
          + " "
          + phoneNumber.substring(4, 6)
          + " "
          + phoneNumber.substring(6, 8);
    }
    return phoneNumber;
  }
}
