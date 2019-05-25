package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Ingrediente implements Serializable {


    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
