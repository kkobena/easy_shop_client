package com.kobe.warehouse.easy_shop_client.view_model.control.alert;

public class Style {
  public static final String ALERT_BASE =
      """
 -fx-padding: 15px;
  -fx-border-width: 1px;
  -fx-border-style: solid;
  -fx-border-color: black;
  -fx-border-radius: 4px;
  -fx-background-radius: 4px;
""";
  public static final String ALERT_SUCCESS =
      """
 -fx-background-color: linear-gradient(to bottom, #dff0d8 0px, #c8e5bc 100%);
  -fx-border-color: #d6e9c6;
  -fx-text-fill: #3c763d;
  -fx-fill: #3c763d;
"""
          + ALERT_BASE;

  public static final String ALERT_INFO =
      """
     -fx-background-color: linear-gradient(to bottom, #d9edf7 0px, #b9def0 100%);
     -fx-border-color: #bce8f1;
     -fx-text-fill: #31708f;
     -fx-fill: #31708f;
    """
          + ALERT_BASE;

  public static final String ALERT_WARNING =
      """
   -fx-background-color: linear-gradient(to bottom, #fcf8e3 0px, #f8efc0 100%);
    -fx-border-color: #faebcc;
    -fx-text-fill: #8a6d3b;
    -fx-fill: #8a6d3b;
        """
          + ALERT_BASE;

  public static final String ALERT_DANGER =
      """
   -fx-background-color: linear-gradient(to bottom, #f2dede 0px, #e7c3c3 100%);
   -fx-border-color: #ebccd1;
   -fx-text-fill: #a94442;
   -fx-fill: #a94442;
            """
          + ALERT_BASE;
}
