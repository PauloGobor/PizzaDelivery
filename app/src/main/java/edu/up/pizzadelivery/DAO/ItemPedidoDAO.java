package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Sabor;

public class ItemPedidoDAO {

    public static long CadastrarItemPedido(Context context, ItemPedido itempedido) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarItemPedido(itempedido);
    }

//    public static long UpdateItemPedido(Context context,ItemPedido itempedido, long idPedido){
//        BancoDeDado banco = new BancoDeDado(context);
//        return banco.EditarItemPedido(itempedido,idPedido);
//    }


    public static double RetornarSomaCarrinho(Context context, Pedido p){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarSomaCarrinho(p);

    }

    public static ArrayList<ItemPedido> retornarItemPedido(Context context,int pedido){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarItemPedido(pedido);
    }

    public static ArrayList<Sabor> retornarSaboresPizza(Context context, int pizza){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarSaboresPizza(pizza);
    }

}
