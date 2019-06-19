package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.ItemPedido;

public class ItemPedidoDAO {

    public static long CadastrarItemPedido(Context context, ItemPedido itempedido) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarItemPedido(itempedido);

    }

}