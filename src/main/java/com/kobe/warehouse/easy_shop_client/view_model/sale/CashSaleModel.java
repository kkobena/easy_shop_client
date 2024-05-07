package com.kobe.warehouse.easy_shop_client.view_model.sale;

import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CashSaleModel extends SaleModel {
    private ObjectProperty<UninsuredCustomer> customer = new SimpleObjectProperty<>(this, "customer");

    public UninsuredCustomer getCustomer() {
        return customer.get();
    }

    public ObjectProperty<UninsuredCustomer> customerProperty() {
        return customer;
    }

    public void setCustomer(UninsuredCustomer customer) {
        this.customer.set(customer);
    }
}
