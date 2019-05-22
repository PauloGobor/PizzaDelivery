package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Tamanho implements Serializable {

    private int idTamanho;
    private int nome;
    private int qtdSabores;
    private double preco;

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
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
