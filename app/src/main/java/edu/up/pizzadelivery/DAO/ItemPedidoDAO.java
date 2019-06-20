package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Pedido;

public class ItemPedidoDAO {

    public static long CadastrarItemPedido(Context context, ItemPedido itempedido) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarItemPedido(itempedido);
    }

    public static double RetornarSomaCarrinho(Context context, Pedido p){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarSomaCarrinho(p);

    }

}
