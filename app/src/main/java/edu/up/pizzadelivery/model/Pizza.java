package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private List<Sabor> sabor;
    private Tamanho tamanho;

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


}
