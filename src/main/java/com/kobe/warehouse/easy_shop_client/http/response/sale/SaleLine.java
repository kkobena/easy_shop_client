package com.kobe.warehouse.easy_shop_client.http.response.sale;


import java.time.LocalDateTime;

public class SaleLine {
    private Long id;
    private Integer quantitySold;
    private Integer quantityRequested;
    private Integer regularUnitPrice;
    private Integer discountUnitPrice;
    private Integer netUnitPrice;
    private Integer discountAmount;
    private Integer salesAmount;
    private Integer htAmount;
    private Integer netAmount;
    private Integer taxAmount;
    private Integer costAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String produitLibelle, code;
    private Long produitId;
    private Long saleId;
    private Integer quantityStock;
    private Integer quantiyAvoir;
    private Integer montantTvaUg = 0;
    private Integer quantityUg;
    private Integer amountToBeTakenIntoAccount;
    private boolean toIgnore;
    private LocalDateTime effectiveUpdateDate;
    private Integer taxValue;
    private boolean forceStock; // mis pour forcer le stock a la vente

    public SaleLine() {
    }
  public void setId(Long id) {
        this.id = id;
    }

  public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

  public void setRegularUnitPrice(Integer regularUnitPrice) {
        this.regularUnitPrice = regularUnitPrice;
    }

  public void setDiscountUnitPrice(Integer discountUnitPrice) {
        this.discountUnitPrice = discountUnitPrice;
    }

  public void setNetUnitPrice(Integer netUnitPrice) {
        this.netUnitPrice = netUnitPrice;
    }

  public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

  public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

  public void setNetAmount(Integer netAmount) {
        this.netAmount = netAmount;
    }

  public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

  public void setCostAmount(Integer costAmount) {
        this.costAmount = costAmount;
    }

  public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

  public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

  public void setProduitLibelle(String produitLibelle) {
        this.produitLibelle = produitLibelle;
    }

  public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
  public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

  public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public Integer getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(Integer quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public Integer getRegularUnitPrice() {
        return regularUnitPrice;
    }

    public Integer getDiscountUnitPrice() {
        return discountUnitPrice;
    }

    public Integer getNetUnitPrice() {
        return netUnitPrice;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public Integer getSalesAmount() {
        return salesAmount;
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

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public Integer getCostAmount() {
        return costAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getProduitLibelle() {
        return produitLibelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProduitId() {
        return produitId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public Integer getQuantiyAvoir() {
        return quantiyAvoir;
    }

    public void setQuantiyAvoir(Integer quantiyAvoir) {
        this.quantiyAvoir = quantiyAvoir;
    }

    public Integer getMontantTvaUg() {
        return montantTvaUg;
    }

    public void setMontantTvaUg(Integer montantTvaUg) {
        this.montantTvaUg = montantTvaUg;
    }

    public Integer getQuantityUg() {
        return quantityUg;
    }

    public void setQuantityUg(Integer quantityUg) {
        this.quantityUg = quantityUg;
    }

    public Integer getAmountToBeTakenIntoAccount() {
        return amountToBeTakenIntoAccount;
    }

    public void setAmountToBeTakenIntoAccount(Integer amountToBeTakenIntoAccount) {
        this.amountToBeTakenIntoAccount = amountToBeTakenIntoAccount;
    }

    public boolean isToIgnore() {
        return toIgnore;
    }

    public void setToIgnore(boolean toIgnore) {
        this.toIgnore = toIgnore;
    }

    public LocalDateTime getEffectiveUpdateDate() {
        return effectiveUpdateDate;
    }

    public void setEffectiveUpdateDate(LocalDateTime effectiveUpdateDate) {
        this.effectiveUpdateDate = effectiveUpdateDate;
    }

    public Integer getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Integer taxValue) {
        this.taxValue = taxValue;
    }

    public boolean isForceStock() {
        return forceStock;
    }

    public void setForceStock(boolean forceStock) {
        this.forceStock = forceStock;
    }
}
