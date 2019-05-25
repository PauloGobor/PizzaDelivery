package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class FormaPagamento implements Serializable {


    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
