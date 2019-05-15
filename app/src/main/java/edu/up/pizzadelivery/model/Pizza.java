package edu.up.pizzadelivery.model;

import java.util.List;

public class Pizza {

    private int idPizza;
    private Sabor sabor;
    private Tamanho tamanho;
    private Borda borda;
    private double preco;


    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
