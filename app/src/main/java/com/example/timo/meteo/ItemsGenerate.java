package com.example.timo.meteo;

public class ItemsGenerate {
    private String ville;
    private int image;

    private String temperature;
    private String heure;

    public ItemsGenerate(String ville, int image, String temperature, String heure) {
        this.ville = ville;
        this.image = image;
        this.temperature = temperature;
        this.heure = heure;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
