package edu.up.pizzadelivery.model;

public class FormaPagamento {

    private int idFormaPagamento;
    private double dinheiro;
    private double cartao;

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getCartao() {
        return cartao;
    }

    public void setCartao(double cartao) {
        this.cartao = cartao;
    }
}
