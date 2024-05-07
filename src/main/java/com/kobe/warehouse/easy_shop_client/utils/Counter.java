package com.kobe.warehouse.easy_shop_client.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Counter implements EventHandler<ActionEvent> {
    private final IntegerProperty count;
    private final int increment;

    public Counter(IntegerProperty count, int increment) {
        this.count = count;
        this.increment = increment;
    }

    @Override
    public void handle(ActionEvent event) {
        count.set(count.get() + increment);
    }

    public ReadOnlyIntegerProperty counterProperty() {
        return count;
    }
    /*
     private Node createCounterButton(IntegerProperty count, int increment) {
        Button button = new Button("Fetch");
        Counter counter = new Counter(count, increment);
        button.textProperty().bind(Bindings.createStringBinding(() -> Integer.toString(count.get()), count));
        button.setOnAction(counter);
        return button;
    }
     button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            count.set(count.get() + increment);
        }
    });
    button.setOnAction(event -> incrementCounter(count, increment));
      button.setOnAction(event -> count.set(count.get() + increment));
      private void incrementCounter(IntegerProperty counter, int increment) {
        counter.set(counter.get() + increment);
    }
     */
}
