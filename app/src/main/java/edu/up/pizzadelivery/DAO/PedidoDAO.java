package edu.up.pizzadelivery.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import edu.up.pizzadelivery.model.Pedido;

public class PedidoDAO {

    public static long CadastrarUsuario(Context context, Pedido pedido) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarPedido(pedido);

    }




}
