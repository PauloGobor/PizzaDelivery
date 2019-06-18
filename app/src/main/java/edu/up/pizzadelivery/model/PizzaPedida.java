package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.List;

public class PizzaPedida implements Serializable {

    private int id;
    private Pizza pizza;
    private Sabor sabor;

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

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }
}
