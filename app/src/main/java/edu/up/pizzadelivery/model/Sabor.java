package edu.up.pizzadelivery.model;

import java.util.List;

public class Sabor {

    private int id;
    private String nome;
    private List<Ingrediente> ingredientes;

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
