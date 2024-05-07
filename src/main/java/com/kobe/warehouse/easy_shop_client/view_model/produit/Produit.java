package com.kobe.warehouse.easy_shop_client.view_model.produit;

import com.kobe.warehouse.easy_shop_client.http.response.referentiel.Rayon;

import java.util.List;

public class Produit {
    private Long id;
    private String libelle;
    private int itemQuantity;
    private int qtyUG;
    private int quantity;
    private int regularUnitPrice;
    private int netUnitPrice;
    private String codeCip;
    private int costAmount;
    private String codeEan;
    private String rayonLibelle;
    private int unitPrice;
    private String displayField;
    private int totalQuantity;
    private List<Rayon> rayonProduits;

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", regularUnitPrice=" + regularUnitPrice +
                ", codeCip='" + codeCip + '\'' +
                ", totalQuantity=" + totalQuantity +
                '}';
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeCip() {
        return codeCip;
    }

    public void setCodeCip(String codeCip) {
        this.codeCip = codeCip;
    }

    public Long getId() {
        return id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getQtyUG() {
        return qtyUG;
    }

    public void setQtyUG(int qtyUG) {
        this.qtyUG = qtyUG;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRegularUnitPrice() {
        return regularUnitPrice;
    }

    public void setRegularUnitPrice(int regularUnitPrice) {
        this.regularUnitPrice = regularUnitPrice;
    }

    public int getNetUnitPrice() {
        return netUnitPrice;
    }

    public void setNetUnitPrice(int netUnitPrice) {
        this.netUnitPrice = netUnitPrice;
    }

    public int getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(int costAmount) {
        this.costAmount = costAmount;
    }

    public String getCodeEan() {
        return codeEan;
    }

    public void setCodeEan(String codeEan) {
        this.codeEan = codeEan;
    }

    public String getRayonLibelle() {
        return rayonLibelle;
    }

    public void setRayonLibelle(String rayonLibelle) {
        this.rayonLibelle = rayonLibelle;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDisplayField() {
        return displayField;
    }

    public void setDisplayField(String displayField) {
        this.displayField = displayField;
    }

    public List<Rayon> getRayonProduits() {
        return rayonProduits;
    }

    public void setRayonProduits(List<Rayon> rayonProduits) {
        this.rayonProduits = rayonProduits;
    }
}
