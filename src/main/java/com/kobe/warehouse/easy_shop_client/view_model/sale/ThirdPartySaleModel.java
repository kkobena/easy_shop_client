package com.kobe.warehouse.easy_shop_client.view_model.sale;

import com.kobe.warehouse.easy_shop_client.view_model.customer.AssuredCustomer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ThirdPartySaleModel  extends SaleModel{
    private ObjectProperty<AssuredCustomer> customer = new SimpleObjectProperty<>(this, "customer");

    public AssuredCustomer getCustomer() {
        return customer.get();
    }

    public ObjectProperty<AssuredCustomer> customerProperty() {
        return customer;
    }

    public void setCustomer(AssuredCustomer customer) {
        this.customer.set(customer);
    }
}
