package com.kobe.warehouse.easy_shop_client.view_model.produit;

import javafx.beans.property.*;

public class ProduitView {
  private LongProperty id = new SimpleLongProperty(this, "id");
  private StringProperty codeCip = new SimpleStringProperty(this, "codeCip");
  private StringProperty libelle = new SimpleStringProperty(this, "libelle");
  private IntegerProperty regularUnitPrice = new SimpleIntegerProperty(this, "regularUnitPrice");
  private IntegerProperty totalQuantity = new SimpleIntegerProperty(this, "totalQuantity");

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getCodeCip() {
        return codeCip.get();
    }

    public StringProperty codeCipProperty() {
        return codeCip;
    }

    public void setCodeCip(String codeCip) {
        this.codeCip.set(codeCip);
    }

    public String getLibelle() {
        return libelle.get();
    }

    public StringProperty libelleProperty() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle.set(libelle);
    }

    public int getRegularUnitPrice() {
        return regularUnitPrice.get();
    }

    public IntegerProperty regularUnitPriceProperty() {
        return regularUnitPrice;
    }

    public void setRegularUnitPrice(int regularUnitPrice) {
        this.regularUnitPrice.set(regularUnitPrice);
    }

    public int getTotalQuantity() {
        return totalQuantity.get();
    }

    public IntegerProperty totalQuantityProperty() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity.set(totalQuantity);
    }
}
