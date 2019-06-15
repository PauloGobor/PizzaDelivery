package edu.up.pizzadelivery.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {

    private int id;
    private Usuario usuario;
    private List<ItemPedido> itensPedido;
    private FormaPagamento formaPagamento;
    private String Data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
