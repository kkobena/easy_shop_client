package com.kobe.warehouse.easy_shop_client;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.request.SaleQueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.Pageable;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.service.user.Mock;
import com.kobe.warehouse.easy_shop_client.http.service.user.UserService;
import com.kobe.warehouse.easy_shop_client.http.service.user.UserServiceImpl;
import com.kobe.warehouse.easy_shop_client.menu.MenuService;
import com.kobe.warehouse.easy_shop_client.menu.MockMenu;
import com.kobe.warehouse.easy_shop_client.view_model.MenuAccordionModelView;
import com.kobe.warehouse.easy_shop_client.view_model.layout.sale.CommonRightView;
import com.kobe.warehouse.easy_shop_client.view_model.layout.sale.CommonTopView;
import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SaleConverter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;

public class MainController implements Initializable {
  private final Logger log = Logger.getLogger(this.getClass().getName());
 // private final UserService userService;
  private final MenuService menuService;
  private AtomicInteger counter = new AtomicInteger(0);
  private double dividerPosition;
  private final SaleService saleService = new SaleServiceImpl();
  private TextField produitQtyTxtField;
  private TextField produitTextField;
  private CommonRightView commonRightView;
  private CommonTopView commonTopView;
  @FXML private URL location;
  @FXML private BorderPane wrRootParent;
  private ObjectProperty<Node> selectedMenuProperty = new SimpleObjectProperty<>();

  //  @FXML private HBox barTottom;

  @FXML private ScrollPane mainPaneContent;
  // @FXML private AnchorPane menuAnchorPane;
  @FXML private VBox menuContainer;

  // @FXML private Label menuTileLable;
  @FXML private Button toggleButton;

  //  @FXML private AnchorPane togglebuttonContainer;
  @FXML private SplitPane containerSplitPanel;

  private final FontIcon iconL;
  private final FontIcon iconR;

  public MainController() {
    //  userService = new Mock();
   // userService = new UserServiceImpl(); // a supprimer apres le menu login


    menuService = new MockMenu();
    iconL = new FontIcon(MaterialDesignA.ARROW_LEFT_CIRCLE_OUTLINE.getDescription());
    iconL.setIconSize(32);
    iconL.setIconColor(Color.BLUE);
    iconR = new FontIcon(MaterialDesignA.ARROW_RIGHT_CIRCLE_OUTLINE.getDescription());
    iconR.setIconSize(32);
    iconR.setIconColor(Color.BLUE);
  }

  @FXML
  protected void onToggleMenu(ActionEvent event) {
   /*  SaleQueryParams queryParams = new SaleQueryParams();
    queryParams.setFromDate(LocalDate.now().minusDays(1));
    queryParams.setToDate(LocalDate.now());
    queryParams.setSize(10);
      Pageable<Sale> sales =
        saleService.fetchPageble(queryParams);
    System.err.println(sales.total());*/

  /*  try {
      List<Sale> fromModel = sales.stream().map(SaleConverter.convertModelToSale::apply).toList();

      CashSaleModel cashSaleModel = saleService.create((CashSaleModel) sales.get(0));
      System.err.println(cashSaleModel.getNetAmount());
    } catch (RemoteException | ServerException e) {
      System.err.println(e);
    }*/

    /* List<User> users= userService.test();
    users.forEach(
        e -> {
          System.err.println(e.getId());
          System.err.println(e.getAuthorities());
       //   System.err.println(e.getUserAuthorities());
          System.err.println(e.getLastModifiedDate());
        });*/
    if (counter.get() == 0) {
      toggleButton.setGraphic(iconR);
      dividerPosition = containerSplitPanel.getDividerPositions()[0];
      containerSplitPanel.getDividers().get(0).setPosition(0.00);
      // region.minWidthProperty().bind(someBooleanProperty.map{if (it) 50.0 else 75.0})
      // region.minWidthProperty().bind(someBooleanProperty.map{if (it) 50.0 else
      // 75.0}.orElse(60.0))
      /*
       ObservableValue<Boolean> isShowing = listView.sceneProperty()
      .flatMap(Scene::windowProperty)
      .flatMap(Window::showingProperty)
      .orElse(false);
       Label countLabel = new Label();
         countLabel.textProperty().bind(Bindings.createStringBinding(() -> Integer.toString(count.get()), count))
        */
      counter.compareAndSet(0, 1);

    } else {
      toggleButton.setGraphic(iconL);
      containerSplitPanel.getDividers().get(0).setPosition(dividerPosition);
      counter.compareAndSet(1, 0);
    }
  }

  @FXML
  protected void onHelloButtonClick() {
    /*
    MOUSE_ENTERED and MOUSE_EXITED
    MOUSE_ENTERED or MOUSE_ENTERED_TARGET and MOUSE_EXITED or MOUSE_EXITED_TARGET
     */
    if (ApplicationConfigurer.currentUser == null) {
      //  userService.test();
    } else {
      System.err.println(ApplicationConfigurer.currentUser);
    }
  }

  @FXML
  public void onUserIconClickEvent(javafx.scene.input.MouseEvent mouseEvent) {}

  /*
  WindowEvents
  WINDOW_CLOSE_REQUEST
   */
  /* public void initialize__(URL location, ResourceBundle resources) {
    try {
      var menuAccordion =
          FXMLLoader.<Accordion>load(MainApplication.class.getResource("accordion.fxml"));
      menuContainer.getChildren().add(menuAccordion);

    } catch (IOException e) {
      log.log(Level.SEVERE, "", e);
    }
  }*/


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //  FlowPane mainFlow=new FlowPane();
    //  mainPaneContent.setContent(mainFlow);
    this.selectedMenuProperty.addListener(
        (observable, oldValue, newValue) -> {
          mainPaneContent.setContent(newValue);

          //  newValue.getProperties().put();
          // mainPaneContent.getChildren().clear();
          // mainPaneContent.getChildren().add(newValue);
        });
    /*  Image backgroundImage = new Image(MainController.class.getResource("images/bg.jpg").toExternalForm());
    AutoCompletePopupSkin
          // Create an ImageView to hold the background image
          ImageView backgroundImageView = new ImageView(backgroundImage);
          backgroundImageView.setPreserveRatio(true);*/

    toggleButton.setGraphic(iconL);

    /*  VBox vBox = new VBox();
    var produitText = new ProduitControlBaseText();

    produitText
        .selectedProdutProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              System.out.println("Old value: " + oldValue + ", New value: " + newValue);
            });
    vBox.getChildren().add(produitText.build());
    System.err.println("sele-- " + produitText.getSelectedProdut());*/
    /*  this.cashSaleView = new CashSaleView();
    HBox saleControl = this.cashSaleView.build();
    this.commonTopView = this.cashSaleView.getTopView();
    this.produitTextField = this.commonTopView.getProduitTextField();
    this.produitQtyTxtField = this.commonTopView.getProduitQtyTxtField();
    this.produitTextField.requestFocus();
    this.commonTopView
        .getProduitText()
        .selectedProdutProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              this.produitQtyTxtField.requestFocus();
              this.produitQtyTxtField.setText(1 + "");
              this.produitQtyTxtField.selectAll();
            });*/
    //  vBox.getChildren().add(new ProduitControl().build());
    //  mainPaneContent.getChildren().add(saleControl);

    // if (Objects.nonNull(userInfo)) {

    this.menuContainer
        .getChildren()
        .add(new MenuAccordionModelView(this.selectedMenuProperty).build());

    // }
  }
}
