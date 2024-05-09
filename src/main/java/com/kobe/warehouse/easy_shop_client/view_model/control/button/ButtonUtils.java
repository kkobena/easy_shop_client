package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public final class ButtonUtils {
  public static final Button ADD_WITH_ICON =
      new Add(FontAwesomeSolid.PLUS_CIRCLE.getDescription(), Constant.ADD_BTN).build();
  public static final Button DELETE_WITH_ICON =
      new Delete(FontAwesomeSolid.TRASH_ALT.getDescription(), Constant.BTN_DELETE).build();
  public static final Button DELETE_ICON_ONLY =
      new Delete(FontAwesomeSolid.TRASH_ALT.getDescription()).build();
  public static final Button ADD = new Add().build();
  public static final Button BTN_EN_ATTENTE =
      new SeeSaleOnHold(FontAwesomeSolid.EYE.getDescription()).build();
  public static final Button AJOUTER_CLIENT =
      new Add(FontAwesomeSolid.USER.getDescription(), "Ajouter client").build();
  public static final String IN_LINE_STYLE_BASE =
      """
 -fx-font-weight: normal;
  -fx-text-alignment: center;
  -fx-cursor: default;
  -fx-border-color: transparent;
  -fx-border-width: 1px;
  -fx-border-style: solid;
  -fx-background-insets: 0, 0, -1, 0;
  -fx-padding: 6px 12px 6px 12px;
  -fx-font-size: 14px;
  -fx-border-radius: 4px;
  -fx-background-radius: 4px;
  -fx-min-width: 80;
   -fx-padding: 5px 10px 5px 10px;
    -fx-font-size: 12px;
    -fx-border-radius: 3px;
    -fx-background-radius: 3px;
""";
  public static final String IN_LINE_STYLE_INFO =
      """
 -fx-text-fill: #fff;
  -fx-fill: #fff;
  -fx-background-color: #5bc0de;
  -fx-border-color: #46b8da;
"""
          + IN_LINE_STYLE_BASE;

  public static final String IN_LINE_STYLE_INFO_HOVER =
      """
   -fx-text-fill: #fff;
     -fx-fill: #fff;
     -fx-background-color: #31b0d5;
     -fx-border-color: #269abc;
    """
          + IN_LINE_STYLE_BASE;

  public static final String IN_LINE_STYLE_CANCEL =
      """
     -fx-text-fill: #fff;
     -fx-fill: #fff;
     -fx-background-color: #d9534f;
     -fx-border-color: #d43f3a;
    """
          + IN_LINE_STYLE_BASE;

  public static final String IN_LINE_STYLE_CANCEL_HOVER =
      """
      -fx-text-fill: #fff;
        -fx-fill: #fff;
        -fx-background-color: #c9302c;
        -fx-border-color: #ac2925;
        """
          + IN_LINE_STYLE_BASE;

  public static final String IN_LINE_SM_BASE =
      """
     -fx-padding: 1px 5px 1px 5px;
      -fx-font-size: 12px;
      -fx-border-radius: 3px;
      -fx-background-radius: 3px;
        """;


  public static final String IN_LINE_SM_DANGER =
          """
  -fx-text-fill: #fff;
  -fx-fill: #fff;
  -fx-background-color: #d9534f;
  -fx-border-color: #d43f3a;
            """;
}
