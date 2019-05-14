package edu.up.pizzadelivery.model;

public class ItemPedido {

    private int Iditem;
    private Pizza pizza;
    private Bebida bebida;
    private int quantidade;
    private double subTotal;
    private double precoPedido;

    public int getIditem() {
        return Iditem;
    }

    public void setIditem(int iditem) {
        Iditem = iditem;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getPrecoPedido() {
        return precoPedido;
    }

    public void setPrecoPedido(double precoPedido) {
        this.precoPedido = precoPedido;
    }
}
