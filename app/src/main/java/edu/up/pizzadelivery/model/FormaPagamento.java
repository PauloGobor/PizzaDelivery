package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class FormaPagamento implements Serializable {

    private int idFormaPagamento;
    private String Nome;

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
