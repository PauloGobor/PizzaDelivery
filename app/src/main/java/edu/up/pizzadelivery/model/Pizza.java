package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private int id;
    private List<Sabor> sabor;
    private Tamanho tamanho;
    private Borda borda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Sabor> getSabor() {
        return sabor;
    }

    public void setSabor(List<Sabor> sabor) {
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
