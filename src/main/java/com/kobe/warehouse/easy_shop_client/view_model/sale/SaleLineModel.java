package com.kobe.warehouse.easy_shop_client.view_model.sale;

import javafx.beans.property.*;

import java.time.LocalDateTime;

public class SaleLineModel {
  private LongProperty id = new SimpleLongProperty(this, "id");
  private LongProperty produitId = new SimpleLongProperty(this, "produitId");
  private LongProperty saleId = new SimpleLongProperty(this, "saleId");
  private IntegerProperty quantitySold = new SimpleIntegerProperty(this, "quantitySold");
  private IntegerProperty quantityRequested = new SimpleIntegerProperty(this, "quantityRequested");
  private IntegerProperty regularUnitPrice = new SimpleIntegerProperty(this, "regularUnitPrice");
  private IntegerProperty discountUnitPrice = new SimpleIntegerProperty(this, "discountUnitPrice");
  private IntegerProperty netUnitPrice = new SimpleIntegerProperty(this, "netUnitPrice");
  private IntegerProperty discountAmount = new SimpleIntegerProperty(this, "discountAmount");
  private IntegerProperty salesAmount = new SimpleIntegerProperty(this, "salesAmount");
  private IntegerProperty htAmount = new SimpleIntegerProperty(this, "htAmount");
  private IntegerProperty netAmount = new SimpleIntegerProperty(this, "netAmount");
  private IntegerProperty taxAmount = new SimpleIntegerProperty(this, "taxAmount");
  private IntegerProperty costAmount = new SimpleIntegerProperty(this, "costAmount");
  private ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>(this, "createdAt");
  private ObjectProperty<LocalDateTime> updatedAt = new SimpleObjectProperty<>(this, "updatedAt");
  private StringProperty produitLibelle = new SimpleStringProperty(this, "produitLibelle");
  private StringProperty code = new SimpleStringProperty(this, "code");
  private IntegerProperty quantityStock = new SimpleIntegerProperty(this, "quantityStock");
  private IntegerProperty quantiyAvoir = new SimpleIntegerProperty(this, "quantiyAvoir");
  private IntegerProperty montantTvaUg = new SimpleIntegerProperty(this, "montantTvaUg");
  private IntegerProperty quantityUg = new SimpleIntegerProperty(this, "quantityUg");
  private IntegerProperty taxValue = new SimpleIntegerProperty(this, "taxValue");

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
  }

  public long getProduitId() {
    return produitId.get();
  }

  public LongProperty produitIdProperty() {
    return produitId;
  }

  public void setProduitId(long produitId) {
    this.produitId.set(produitId);
  }

  public long getSaleId() {
    return saleId.get();
  }

  public LongProperty saleIdProperty() {
    return saleId;
  }

  public void setSaleId(long saleId) {
    this.saleId.set(saleId);
  }

  public int getQuantitySold() {
    return quantitySold.get();
  }

  public IntegerProperty quantitySoldProperty() {
    return quantitySold;
  }

  public void setQuantitySold(int quantitySold) {
    this.quantitySold.set(quantitySold);
  }

  public int getQuantityRequested() {
    return quantityRequested.get();
  }

  public IntegerProperty quantityRequestedProperty() {
    return quantityRequested;
  }

  public void setQuantityRequested(int quantityRequested) {
    this.quantityRequested.set(quantityRequested);
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

  public int getDiscountUnitPrice() {
    return discountUnitPrice.get();
  }

  public IntegerProperty discountUnitPriceProperty() {
    return discountUnitPrice;
  }

  public void setDiscountUnitPrice(int discountUnitPrice) {
    this.discountUnitPrice.set(discountUnitPrice);
  }

  public int getNetUnitPrice() {
    return netUnitPrice.get();
  }

  public IntegerProperty netUnitPriceProperty() {
    return netUnitPrice;
  }

  public void setNetUnitPrice(int netUnitPrice) {
    this.netUnitPrice.set(netUnitPrice);
  }

  public int getDiscountAmount() {
    return discountAmount.get();
  }

  public IntegerProperty discountAmountProperty() {
    return discountAmount;
  }

  public void setDiscountAmount(int discountAmount) {
    this.discountAmount.set(discountAmount);
  }

  public int getSalesAmount() {
    return salesAmount.get();
  }

  public IntegerProperty salesAmountProperty() {
    return salesAmount;
  }

  public void setSalesAmount(int salesAmount) {
    this.salesAmount.set(salesAmount);
  }

  public int getHtAmount() {
    return htAmount.get();
  }

  public IntegerProperty htAmountProperty() {
    return htAmount;
  }

  public void setHtAmount(int htAmount) {
    this.htAmount.set(htAmount);
  }

  public int getNetAmount() {
    return netAmount.get();
  }

  public IntegerProperty netAmountProperty() {
    return netAmount;
  }

  public void setNetAmount(int netAmount) {
    this.netAmount.set(netAmount);
  }

  public int getTaxAmount() {
    return taxAmount.get();
  }

  public IntegerProperty taxAmountProperty() {
    return taxAmount;
  }

  public void setTaxAmount(int taxAmount) {
    this.taxAmount.set(taxAmount);
  }

  public int getCostAmount() {
    return costAmount.get();
  }

  public IntegerProperty costAmountProperty() {
    return costAmount;
  }

  public void setCostAmount(int costAmount) {
    this.costAmount.set(costAmount);
  }

  public LocalDateTime getCreatedAt() {
    return createdAt.get();
  }

  public ObjectProperty<LocalDateTime> createdAtProperty() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt.set(createdAt);
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt.get();
  }

  public ObjectProperty<LocalDateTime> updatedAtProperty() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt.set(updatedAt);
  }

  public String getProduitLibelle() {
    return produitLibelle.get();
  }

  public StringProperty produitLibelleProperty() {
    return produitLibelle;
  }

  public void setProduitLibelle(String produitLibelle) {
    this.produitLibelle.set(produitLibelle);
  }

  public String getCode() {
    return code.get();
  }

  public StringProperty codeProperty() {
    return code;
  }

  public void setCode(String code) {
    this.code.set(code);
  }

  public int getQuantityStock() {
    return quantityStock.get();
  }

  public IntegerProperty quantityStockProperty() {
    return quantityStock;
  }

  public void setQuantityStock(int quantityStock) {
    this.quantityStock.set(quantityStock);
  }

  public int getQuantiyAvoir() {
    return quantiyAvoir.get();
  }

  public IntegerProperty quantiyAvoirProperty() {
    return quantiyAvoir;
  }

  public void setQuantiyAvoir(int quantiyAvoir) {
    this.quantiyAvoir.set(quantiyAvoir);
  }

  public int getMontantTvaUg() {
    return montantTvaUg.get();
  }

  public IntegerProperty montantTvaUgProperty() {
    return montantTvaUg;
  }

  public void setMontantTvaUg(int montantTvaUg) {
    this.montantTvaUg.set(montantTvaUg);
  }

  public int getQuantityUg() {
    return quantityUg.get();
  }

  public IntegerProperty quantityUgProperty() {
    return quantityUg;
  }

  public void setQuantityUg(int quantityUg) {
    this.quantityUg.set(quantityUg);
  }

  public int getTaxValue() {
    return taxValue.get();
  }

  public IntegerProperty taxValueProperty() {
    return taxValue;
  }

  public void setTaxValue(int taxValue) {
    this.taxValue.set(taxValue);
  }
}
