package com.kobe.warehouse.easy_shop_client.view_model;

public class Tutos {

    /*
     addStyleSheet("/ca/pragmaticcoding/widgetsfx/css/LabelBox.css")
     val selectedItem: ObjectProperty<TableData> = SimpleObjectProperty()
    private fun createTable(): Region = TableView<TableData>().apply {
        columns += TableColumn<TableData, String>("Name").apply {
            cellValueFactory = Callback { it.value.nameProperty }
        }
        columns += TableColumn<TableData, String>("Address").apply {
            cellValueFactory = Callback { it.value.addressProperty }
        }
        items += listOf(
            TableData("Wizard of Oz", "1 Yellow Brick Road"),
            TableData("Herman Munster", "1313 Mockingbird Lane"),
            TableData("Norman Bates", "Bates Motel")
        )
        selectedItem.bind(selectionModel.selectedItemProperty())
        columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY_LAST_COLUMN
        maxWidth = 300.0
    }

    private fun createPane(): Region = VBox(10.0).apply {
        children += HBox(10.0, Label("Name: "), Label().apply {
            textProperty().bind(selectedItem.flatMap { it.nameProperty })
        })
        children += HBox(10.0, Label("Address: "), Label().apply {
            textProperty().bind(selectedItem.flatMap { it.addressProperty })
        })
        minWidth = 300.0
        padding = Insets(15.0)
    }
      textProperty().bind(selectedItem.flatMap { it.nameProperty })
      if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {}


       private void addHandlers(Node node, String name) {
        node.addEventFilter(Event.ANY, evt -> logHandler("Filter", name, evt));
        node.addEventHandler(Event.ANY, evt -> logHandler("Handler", name, evt));
    }
scene.addEventFilter(Event.ANY, evt -> {
            logHandler("Filter", "Scene", evt);
            if (evt.getEventType().equals(ActionEvent.ACTION)) {
                evt.consume();
            }
        });
    private void logHandler(String handlerType, String name, Event event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_MOVED))
            return;
        if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED_TARGET))
            return;
        if (event.getEventType().equals(MouseEvent.MOUSE_EXITED_TARGET))
            return;
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss:SSS"));
        String className = event.getTarget().getClass().getSimpleName();
        String formatted = String.format("%-13s %-15s %-20s %-10s %-15s", time, name, event.getEventType(), handlerType, className);
        System.out.println(formatted);
        text.set(formatted + "\n" + text.get());
    }


public class PseudoClassDemo extends Application {

    private BooleanProperty displayInRed = new SimpleBooleanProperty(false);

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent(), 320, 240);
        scene.getStylesheets().add(PseudoClassDemo.class.getResource("test.css").toString());
        stage.setScene(scene);
        stage.show();
    }

    private Region createContent() {
        PseudoClass redDisplay = PseudoClass.getPseudoClass("red");
        Label label = new Label("This is the label text");
        displayInRed.addListener(inv -> {
            label.pseudoClassStateChanged(redDisplay, displayInRed.get());
        });
        Button button = new Button("Click Me");
        button.setOnAction(evt -> displayInRed.set(!displayInRed.get()));
        return new VBox(20, label, button);
    }

    public static void main(String[] args) {
        launch();
    }

    .label:red {
   -fx-text-fill: red;
}
 private boolean showInRed = false;
  button.setOnAction(evt -> {
            showInRed = !showInRed;
            label.pseudoClassStateChanged(redDisplay, showInRed);
        });
}


 private Region createContent() {
        PseudoClass redDisplay = PseudoClass.getPseudoClass("red");
        PseudoClass orangeDisplay = PseudoClass.getPseudoClass("orange");
        Label label = new Label("This is the label text");
        alertLevel.addListener(inv -> {
            label.pseudoClassStateChanged(redDisplay, false);
            label.pseudoClassStateChanged(orangeDisplay, false);
            switch (alertLevel.get()) {
                case "Warning" -> label.pseudoClassStateChanged(orangeDisplay, true);
                case "Emergency" -> label.pseudoClassStateChanged(redDisplay, true);
            }
        });
        return new VBox(20, label, createButtons());




     */
}
