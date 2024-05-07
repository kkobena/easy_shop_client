package com.kobe.warehouse.easy_shop_client.view_model.sale;

import javafx.beans.property.*;

public class Payment {
  private LongProperty id = new SimpleLongProperty(this, "id");
    private IntegerProperty netAmount = new SimpleIntegerProperty(this, "netAmount");
    private IntegerProperty paidAmount = new SimpleIntegerProperty(this, "paidAmount");
    private IntegerProperty restToPay = new SimpleIntegerProperty(this, "restToPay");
    private  ObjectProperty<PaymentMode>paymentMode=new SimpleObjectProperty<>(this, "paymentMode");
    private IntegerProperty salesAmount = new SimpleIntegerProperty(this, "salesAmount");
    private IntegerProperty salesNetAmount = new SimpleIntegerProperty(this, "salesAmount");
    private IntegerProperty reelPaidAmount = new SimpleIntegerProperty(this, "reelPaidAmount");
    private IntegerProperty paymentCode = new SimpleIntegerProperty(this, "paymentCode");
    private IntegerProperty montantVerse = new SimpleIntegerProperty(this, "montantVerse");

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
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

  public int getPaidAmount() {
    return paidAmount.get();
  }

  public IntegerProperty paidAmountProperty() {
    return paidAmount;
  }

  public void setPaidAmount(int paidAmount) {
    this.paidAmount.set(paidAmount);
  }

  public int getRestToPay() {
    return restToPay.get();
  }

  public IntegerProperty restToPayProperty() {
    return restToPay;
  }

  public void setRestToPay(int restToPay) {
    this.restToPay.set(restToPay);
  }

  public PaymentMode getPaymentMode() {
    return paymentMode.get();
  }

  public ObjectProperty<PaymentMode> paymentModeProperty() {
    return paymentMode;
  }

  public void setPaymentMode(PaymentMode paymentMode) {
    this.paymentMode.set(paymentMode);
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

  public int getSalesNetAmount() {
    return salesNetAmount.get();
  }

  public IntegerProperty salesNetAmountProperty() {
    return salesNetAmount;
  }

  public void setSalesNetAmount(int salesNetAmount) {
    this.salesNetAmount.set(salesNetAmount);
  }

  public int getReelPaidAmount() {
    return reelPaidAmount.get();
  }

  public IntegerProperty reelPaidAmountProperty() {
    return reelPaidAmount;
  }

  public void setReelPaidAmount(int reelPaidAmount) {
    this.reelPaidAmount.set(reelPaidAmount);
  }

  public int getPaymentCode() {
    return paymentCode.get();
  }

  public IntegerProperty paymentCodeProperty() {
    return paymentCode;
  }

  public void setPaymentCode(int paymentCode) {
    this.paymentCode.set(paymentCode);
  }

  public int getMontantVerse() {
    return montantVerse.get();
  }

  public IntegerProperty montantVerseProperty() {
    return montantVerse;
  }

  public void setMontantVerse(int montantVerse) {
    this.montantVerse.set(montantVerse);
  }
}
