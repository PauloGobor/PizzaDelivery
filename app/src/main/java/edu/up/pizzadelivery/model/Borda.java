package edu.up.pizzadelivery.model;

import java.io.Serializable;

public class Borda implements Serializable {

    private int id;
    private int nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

}
