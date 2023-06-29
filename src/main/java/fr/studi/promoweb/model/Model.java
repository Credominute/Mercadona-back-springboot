package fr.studi.promoweb.model;

public class Model {
    private int modelId;
    private String marque;
    private int prix;

    public Model(int modelId, String marque, int prix) {
        this.modelId = modelId;
        this.marque = marque;
        this.prix = prix;
    }

    public Model() { }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
