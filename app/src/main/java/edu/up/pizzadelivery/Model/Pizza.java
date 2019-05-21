package edu.up.pizzadelivery.Model;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private int idPizza;
    private List<Sabor> sabor;
    private Tamanho tamanho;


    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
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


}
