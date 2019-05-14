package edu.up.pizzadelivery.model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Usuario usuario;
    private List<ItemPedido> itensPedido;
    private FormaPagamento formaPagamento;
    private Date Data;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }


}
