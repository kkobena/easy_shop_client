package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

public class ControlFocus {
    private Input input;

    public Input getInput() {
        return input;
    }

    public ControlFocus(Input input) {
        this.input = input;
    }

    public ControlFocus setInput(Input input) {
        this.input = input;
        return this;
    }

    public enum Input{
        PRODUIT_INPUT,
        PRODUIT_QTY
    }
}
