package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Tamanho implements Serializable {

    private int idTamanho;
    private int nome;
    private int qtdPedacos;
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

    public int getQtdPedacos() {
        return qtdPedacos;
    }

    public void setQtdPedacos(int qtdPedacos) {
        this.qtdPedacos = qtdPedacos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
