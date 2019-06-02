package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class FormaPagamento implements Serializable {

    private int id;
    private String Nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
