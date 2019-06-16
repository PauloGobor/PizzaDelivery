package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.ItemPedido;


public class ItemPedidoDAO {

    public static ArrayList<ItemPedido> retornarFormasPagamento(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarItemPedido();
    }


}
