package edu.up.pizzadelivery.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Pedido;

public class PedidoDAO {

    public static long CadastrarPedido(Context context, Pedido pedido) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarPedido(pedido);

    }

    public static ArrayList<Pedido> RetornaHistoricoPedido(Context context, int idUsuario){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornaHistoricoPedido(idUsuario);
    }


}
