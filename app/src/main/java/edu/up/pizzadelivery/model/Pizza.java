package edu.up.pizzadelivery.model;

public class Pizza {

    private int id;
    private Sabores sabores;
    private Tamanho tamanho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sabores getSabores() {
        return sabores;
    }

    public void setSabores(Sabores sabores) {
        this.sabores = sabores;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

}
