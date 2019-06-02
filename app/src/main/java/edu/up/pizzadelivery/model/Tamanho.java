package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Tamanho implements Serializable {

    private int id;
    private String nome;
    private int qtdSabores;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdSabores() {
        return qtdSabores;
    }

    public void setQtdSabores(int qtdSabores) {
        this.qtdSabores = qtdSabores;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
