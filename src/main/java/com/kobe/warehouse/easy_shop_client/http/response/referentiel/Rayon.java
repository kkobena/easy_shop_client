package com.kobe.warehouse.easy_shop_client.http.response.referentiel;

public class Rayon {
    private String codeRayon;
    private String libelleRayon;
    private String libelleStorage;
    private String storageType;
    private Long magasinId;
    private Long rayonId;
    private Long id;
    private Long produitId;

    public Rayon() {
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getLibelleRayon() {
        return libelleRayon;
    }

    public void setLibelleRayon(String libelleRayon) {
        this.libelleRayon = libelleRayon;
    }

    public String getLibelleStorage() {
        return libelleStorage;
    }

    public void setLibelleStorage(String libelleStorage) {
        this.libelleStorage = libelleStorage;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public Long getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Long magasinId) {
        this.magasinId = magasinId;
    }

    public Long getRayonId() {
        return rayonId;
    }

    public void setRayonId(Long rayonId) {
        this.rayonId = rayonId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
