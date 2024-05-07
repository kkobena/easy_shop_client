package com.kobe.warehouse.easy_shop_client.view_model.sale;

import java.time.LocalDateTime;

import com.kobe.warehouse.easy_shop_client.http.response.sale.SaleLine;
import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;
import com.kobe.warehouse.easy_shop_client.view_model.user.User;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SalesStatut;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class SaleModel {
  protected LongProperty id = new SimpleLongProperty(this, "id");
  protected StringProperty numberTransaction = new SimpleStringProperty(this, "numberTransaction");
  // protected StringProperty type = new SimpleStringProperty(this, "type");
  protected StringProperty ticketNumber = new SimpleStringProperty(this, "ticketNumber");
  protected StringProperty userFullName = new SimpleStringProperty(this, "userFullName");
  protected StringProperty commentaire = new SimpleStringProperty(this, "commentaire");
  protected StringProperty categorie = new SimpleStringProperty(this, "categorie");
  protected IntegerProperty salesAmount = new SimpleIntegerProperty(this, "salesAmount");
  protected IntegerProperty discountAmount = new SimpleIntegerProperty(this, "discountAmount");
  protected IntegerProperty htAmount = new SimpleIntegerProperty(this, "htAmount");
  protected IntegerProperty netAmount = new SimpleIntegerProperty(this, "netAmount");
  protected IntegerProperty taxAmount = new SimpleIntegerProperty(this, "taxAmount");
  protected IntegerProperty costAmount = new SimpleIntegerProperty(this, "costAmount");
  protected ObjectProperty<SalesStatut> statut = new SimpleObjectProperty<>(this, "statut");
  protected ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>(this, "createdAt");
  protected ObjectProperty<LocalDateTime> updatedAt = new SimpleObjectProperty<>(this, "updatedAt");
  protected StringProperty sellerUserName = new SimpleStringProperty(this, "sellerUserName");
  protected StringProperty customerNum = new SimpleStringProperty(this, "customerNum");
  protected ObjectProperty<SaleModel> canceledSale =
      new SimpleObjectProperty<>(this, "canceledSale");
  protected IntegerProperty payrollAmount = new SimpleIntegerProperty(this, "payrollAmount");
  protected IntegerProperty amountToBePaid = new SimpleIntegerProperty(this, "amountToBePaid");
  protected IntegerProperty montantVerse = new SimpleIntegerProperty(this, "montantVerse");
  protected IntegerProperty montantRendu = new SimpleIntegerProperty(this, "montantRendu");
  protected IntegerProperty restToPay = new SimpleIntegerProperty(this, "restToPay");
  protected BooleanProperty copy = new SimpleBooleanProperty(this, "copy");
  protected BooleanProperty imported = new SimpleBooleanProperty(this, "imported");
  protected BooleanProperty differe = new SimpleBooleanProperty(this, "differe");
  protected BooleanProperty avoir = new SimpleBooleanProperty(this, "avoir");
  protected ListProperty<Payment> payments =
      new SimpleListProperty<>(this, "payments", FXCollections.observableArrayList());
  protected ObjectProperty<Remise> remise = new SimpleObjectProperty<>(this, "remise");
  protected ObjectProperty<NatureVente> natureVente =
      new SimpleObjectProperty<>(this, "natureVente");
  protected ObjectProperty<TypePrescription> typePrescription =
      new SimpleObjectProperty<>(this, "typePrescription");
  protected ObjectProperty<User> cassier = new SimpleObjectProperty<>(this, "cassier");
  protected ObjectProperty<User> seller = new SimpleObjectProperty<>(this, "seller");
  // private List<SaleLineDTO> salesLines = new ArrayList<>();
  protected ListProperty<SaleLine> salesLines =
      new SimpleListProperty<>(this, "salesLines", FXCollections.observableArrayList());

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
  }

  public ObservableList<SaleLine> getSalesLines() {
    return salesLines.get();
  }

  public ListProperty<SaleLine> salesLinesProperty() {
    return salesLines;
  }

  public void setSalesLines(ObservableList<SaleLine> salesLines) {
    this.salesLines.set(salesLines);
  }

  public String getNumberTransaction() {
    return numberTransaction.get();
  }

  public StringProperty numberTransactionProperty() {
    return numberTransaction;
  }

  public void setNumberTransaction(String numberTransaction) {
    this.numberTransaction.set(numberTransaction);
  }

  public String getTicketNumber() {
    return ticketNumber.get();
  }

  public StringProperty ticketNumberProperty() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber.set(ticketNumber);
  }

  public String getUserFullName() {
    return userFullName.get();
  }

  public StringProperty userFullNameProperty() {
    return userFullName;
  }

  public void setUserFullName(String userFullName) {
    this.userFullName.set(userFullName);
  }

  public String getCommentaire() {
    return commentaire.get();
  }

  public StringProperty commentaireProperty() {
    return commentaire;
  }

  public void setCommentaire(String commentaire) {
    this.commentaire.set(commentaire);
  }

  public String getCategorie() {
    return categorie.get();
  }

  public StringProperty categorieProperty() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie.set(categorie);
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

  public int getDiscountAmount() {
    return discountAmount.get();
  }

  public IntegerProperty discountAmountProperty() {
    return discountAmount;
  }

  public void setDiscountAmount(int discountAmount) {
    this.discountAmount.set(discountAmount);
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

  public SalesStatut getStatut() {
    return statut.get();
  }

  public ObjectProperty<SalesStatut> statutProperty() {
    return statut;
  }

  public void setStatut(SalesStatut statut) {
    this.statut.set(statut);
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

  public String getSellerUserName() {
    return sellerUserName.get();
  }

  public StringProperty sellerUserNameProperty() {
    return sellerUserName;
  }

  public void setSellerUserName(String sellerUserName) {
    this.sellerUserName.set(sellerUserName);
  }

  public String getCustomerNum() {
    return customerNum.get();
  }

  public StringProperty customerNumProperty() {
    return customerNum;
  }

  public void setCustomerNum(String customerNum) {
    this.customerNum.set(customerNum);
  }

  public SaleModel getCanceledSale() {
    return canceledSale.get();
  }

  public ObjectProperty<SaleModel> canceledSaleProperty() {
    return canceledSale;
  }

  public void setCanceledSale(SaleModel canceledSale) {
    this.canceledSale.set(canceledSale);
  }

  public int getPayrollAmount() {
    return payrollAmount.get();
  }

  public IntegerProperty payrollAmountProperty() {
    return payrollAmount;
  }

  public void setPayrollAmount(int payrollAmount) {
    this.payrollAmount.set(payrollAmount);
  }

  public int getAmountToBePaid() {
    return amountToBePaid.get();
  }

  public IntegerProperty amountToBePaidProperty() {
    return amountToBePaid;
  }

  public void setAmountToBePaid(int amountToBePaid) {
    this.amountToBePaid.set(amountToBePaid);
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

  public int getMontantRendu() {
    return montantRendu.get();
  }

  public IntegerProperty montantRenduProperty() {
    return montantRendu;
  }

  public void setMontantRendu(int montantRendu) {
    this.montantRendu.set(montantRendu);
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

  public boolean isCopy() {
    return copy.get();
  }

  public BooleanProperty copyProperty() {
    return copy;
  }

  public void setCopy(boolean copy) {
    this.copy.set(copy);
  }

  public boolean isImported() {
    return imported.get();
  }

  public BooleanProperty importedProperty() {
    return imported;
  }

  public void setImported(boolean imported) {
    this.imported.set(imported);
  }

  public boolean isDiffere() {
    return differe.get();
  }

  public BooleanProperty differeProperty() {
    return differe;
  }

  public void setDiffere(boolean differe) {
    this.differe.set(differe);
  }

  public boolean isAvoir() {
    return avoir.get();
  }

  public BooleanProperty avoirProperty() {
    return avoir;
  }

  public void setAvoir(boolean avoir) {
    this.avoir.set(avoir);
  }

  public ObservableList<Payment> getPayments() {
    return payments.get();
  }

  public ListProperty<Payment> paymentsProperty() {
    return payments;
  }

  public void setPayments(ObservableList<Payment> payments) {
    this.payments.set(payments);
  }

  public Remise getRemise() {
    return remise.get();
  }

  public ObjectProperty<Remise> remiseProperty() {
    return remise;
  }

  public void setRemise(Remise remise) {
    this.remise.set(remise);
  }

  public NatureVente getNatureVente() {
    return natureVente.get();
  }

  public ObjectProperty<NatureVente> natureVenteProperty() {
    return natureVente;
  }

  public void setNatureVente(NatureVente natureVente) {
    this.natureVente.set(natureVente);
  }

  public TypePrescription getTypePrescription() {
    return typePrescription.get();
  }

  public ObjectProperty<TypePrescription> typePrescriptionProperty() {
    return typePrescription;
  }

  public void setTypePrescription(TypePrescription typePrescription) {
    this.typePrescription.set(typePrescription);
  }

  public User getCassier() {
    return cassier.get();
  }

  public ObjectProperty<User> cassierProperty() {
    return cassier;
  }

  public void setCassier(User cassier) {
    this.cassier.set(cassier);
  }

  public User getSeller() {
    return seller.get();
  }

  public ObjectProperty<User> sellerProperty() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller.set(seller);
  }
}
