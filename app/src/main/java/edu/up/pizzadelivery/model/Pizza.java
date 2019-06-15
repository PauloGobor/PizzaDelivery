package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private int id;
    private Tamanho tamanho;
    private Borda borda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
