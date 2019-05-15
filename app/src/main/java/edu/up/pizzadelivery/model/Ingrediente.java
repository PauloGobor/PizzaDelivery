package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Ingrediente implements Serializable {

    private int idIngrediente;
    private String nome;

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
