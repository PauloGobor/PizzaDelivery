package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.List;

public class PizzaPedida implements Serializable {

    private int id;
    private Pizza pizza;
    private List<Sabor> sabores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }
}
