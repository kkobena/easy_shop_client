package com.kobe.warehouse.easy_shop_client.http.response.sale;

public class Remise {
  private Long id;

  private String valeur;

  private Float remiseValue;

  private String typeRemise;
  private String typeLibelle;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValeur() {
    return valeur;
  }

  public void setValeur(String valeur) {
    this.valeur = valeur;
  }

  public Float getRemiseValue() {
    return remiseValue;
  }

  public void setRemiseValue(Float remiseValue) {
    this.remiseValue = remiseValue;
  }

  public String getTypeRemise() {
    return typeRemise;
  }

  public void setTypeRemise(String typeRemise) {
    this.typeRemise = typeRemise;
  }

  public String getTypeLibelle() {
    return typeLibelle;
  }

  public void setTypeLibelle(String typeLibelle) {
    this.typeLibelle = typeLibelle;
  }
}
