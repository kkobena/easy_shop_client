package com.kobe.warehouse.easy_shop_client.http.response.sale;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import com.kobe.warehouse.easy_shop_client.view_model.sale.Payment;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleLineModel;
import com.kobe.warehouse.easy_shop_client.view_model.user.User;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SalesStatut;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = CashSale.class, name = "VNO"),
  @JsonSubTypes.Type(value = ThirdPartySale.class, name = "VO")
})
public class Sale implements Serializable {
  private Long id;
  private Integer discountAmount;
  private String numberTransaction;
  private Integer salesAmount;
  private String userFullName;
  private Integer htAmount;
  private Integer netAmount;
  private Integer taxAmount;
  private Integer costAmount;
  private SalesStatut statut;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<SaleLineModel> salesLines = new ArrayList<>();
  private List<Payment> payments = new ArrayList<>();
  private Sale canceledSale;
  private LocalDateTime effectiveUpdateDate;
  private boolean toIgnore;
  private String ticketNumber;
  private Integer payrollAmount;
  private Integer amountToBePaid;
  private Integer amountToBeTakenIntoAccount;
  private Integer montantVerse;
  private Integer montantRendu;
  private Remise remise;
  private Integer restToPay;
  private String customerNum;
  private Boolean copy = false;
  private boolean imported = false;
  private boolean differe;
  private boolean avoir;
  private Integer margeUg = 0;
  private Integer montantttcUg = 0;
  private Integer montantnetUg = 0;
  private Integer montantTvaUg = 0;
  private Integer marge = 0;
  private int montantRendue;
  private NatureVente natureVente;
  private TypePrescription typePrescription;
  private UserInfo cassier;
  private UserInfo seller;
  private Long cassierId;
  private Long sellerId;
  private String caisseEndNum;
  private String caisseNum;
  private String categorie;
  private String posteName;
  private String commentaire;

  public Sale() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Integer discountAmount) {
    this.discountAmount = discountAmount;
  }

  public String getNumberTransaction() {
    return numberTransaction;
  }

  public void setNumberTransaction(String numberTransaction) {
    this.numberTransaction = numberTransaction;
  }

  public Integer getSalesAmount() {
    return salesAmount;
  }

  public void setSalesAmount(Integer salesAmount) {
    this.salesAmount = salesAmount;
  }

  public String getUserFullName() {
    return userFullName;
  }

  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }

  public Integer getHtAmount() {
    return htAmount;
  }

  public void setHtAmount(Integer htAmount) {
    this.htAmount = htAmount;
  }

  public Integer getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(Integer netAmount) {
    this.netAmount = netAmount;
  }

  public Integer getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Integer taxAmount) {
    this.taxAmount = taxAmount;
  }

  public Integer getCostAmount() {
    return costAmount;
  }

  public void setCostAmount(Integer costAmount) {
    this.costAmount = costAmount;
  }

  public SalesStatut getStatut() {
    return statut;
  }

  public void setStatut(SalesStatut statut) {
    this.statut = statut;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<SaleLineModel> getSalesLines() {
    return salesLines;
  }

  public void setSalesLines(List<SaleLineModel> salesLines) {
    this.salesLines = salesLines;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public Sale getCanceledSale() {
    return canceledSale;
  }

  public void setCanceledSale(Sale canceledSale) {
    this.canceledSale = canceledSale;
  }

  public LocalDateTime getEffectiveUpdateDate() {
    return effectiveUpdateDate;
  }

  public void setEffectiveUpdateDate(LocalDateTime effectiveUpdateDate) {
    this.effectiveUpdateDate = effectiveUpdateDate;
  }

  public boolean isToIgnore() {
    return toIgnore;
  }

  public void setToIgnore(boolean toIgnore) {
    this.toIgnore = toIgnore;
  }

  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public Integer getPayrollAmount() {
    return payrollAmount;
  }

  public void setPayrollAmount(Integer payrollAmount) {
    this.payrollAmount = payrollAmount;
  }

  public Integer getAmountToBePaid() {
    return amountToBePaid;
  }

  public void setAmountToBePaid(Integer amountToBePaid) {
    this.amountToBePaid = amountToBePaid;
  }

  public Integer getAmountToBeTakenIntoAccount() {
    return amountToBeTakenIntoAccount;
  }

  public void setAmountToBeTakenIntoAccount(Integer amountToBeTakenIntoAccount) {
    this.amountToBeTakenIntoAccount = amountToBeTakenIntoAccount;
  }

  public Integer getMontantVerse() {
    return montantVerse;
  }

  public void setMontantVerse(Integer montantVerse) {
    this.montantVerse = montantVerse;
  }

  public Integer getMontantRendu() {
    return montantRendu;
  }

  public void setMontantRendu(Integer montantRendu) {
    this.montantRendu = montantRendu;
  }

  public Remise getRemise() {
    return remise;
  }

  public void setRemise(Remise remise) {
    this.remise = remise;
  }

  public Integer getRestToPay() {
    return restToPay;
  }

  public void setRestToPay(Integer restToPay) {
    this.restToPay = restToPay;
  }

  public String getCustomerNum() {
    return customerNum;
  }

  public void setCustomerNum(String customerNum) {
    this.customerNum = customerNum;
  }

  public Boolean getCopy() {
    return copy;
  }

  public void setCopy(Boolean copy) {
    this.copy = copy;
  }

  public boolean isImported() {
    return imported;
  }

  public void setImported(boolean imported) {
    this.imported = imported;
  }

  public boolean isDiffere() {
    return differe;
  }

  public void setDiffere(boolean differe) {
    this.differe = differe;
  }

  public boolean isAvoir() {
    return avoir;
  }

  public void setAvoir(boolean avoir) {
    this.avoir = avoir;
  }

  public Integer getMargeUg() {
    return margeUg;
  }

  public void setMargeUg(Integer margeUg) {
    this.margeUg = margeUg;
  }

  public Integer getMontantttcUg() {
    return montantttcUg;
  }

  public void setMontantttcUg(Integer montantttcUg) {
    this.montantttcUg = montantttcUg;
  }

  public Integer getMontantnetUg() {
    return montantnetUg;
  }

  public void setMontantnetUg(Integer montantnetUg) {
    this.montantnetUg = montantnetUg;
  }

  public Integer getMontantTvaUg() {
    return montantTvaUg;
  }

  public void setMontantTvaUg(Integer montantTvaUg) {
    this.montantTvaUg = montantTvaUg;
  }

  public Integer getMarge() {
    return marge;
  }

  public void setMarge(Integer marge) {
    this.marge = marge;
  }

  public int getMontantRendue() {
    return montantRendue;
  }

  public void setMontantRendue(int montantRendue) {
    this.montantRendue = montantRendue;
  }

  public NatureVente getNatureVente() {
    return natureVente;
  }

  public void setNatureVente(NatureVente natureVente) {
    this.natureVente = natureVente;
  }

  public TypePrescription getTypePrescription() {
    return typePrescription;
  }

  public void setTypePrescription(TypePrescription typePrescription) {
    this.typePrescription = typePrescription;
  }

  public UserInfo getCassier() {
    return cassier;
  }

  public void setCassier(UserInfo cassier) {
    this.cassier = cassier;
  }

  public UserInfo getSeller() {
    return seller;
  }

  public void setSeller(UserInfo seller) {
    this.seller = seller;
  }

  public Long getCassierId() {
    return cassierId;
  }

  public void setCassierId(Long cassierId) {
    this.cassierId = cassierId;
  }

  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public String getCaisseEndNum() {
    return caisseEndNum;
  }

  public void setCaisseEndNum(String caisseEndNum) {
    this.caisseEndNum = caisseEndNum;
  }

  public String getCaisseNum() {
    return caisseNum;
  }

  public void setCaisseNum(String caisseNum) {
    this.caisseNum = caisseNum;
  }

  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public String getPosteName() {
    return posteName;
  }

  public void setPosteName(String posteName) {
    this.posteName = posteName;
  }

  public String getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(String commentaire) {
    this.commentaire = commentaire;
  }
}
