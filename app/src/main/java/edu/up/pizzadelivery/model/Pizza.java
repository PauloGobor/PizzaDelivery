package edu.up.pizzadelivery.model;

import java.util.List;

public class Pizza {

    private int id;
    private Sabor sabor;
    private Tamanho tamanho;
    private Borda borda;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Borda getBorda() {
        return borda;
    }

    public void setBorda(Borda borda) {
        this.borda = borda;
    }


}
