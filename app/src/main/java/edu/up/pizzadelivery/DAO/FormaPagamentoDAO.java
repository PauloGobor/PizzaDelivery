package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Tamanho;

public class FormaPagamentoDAO {

    public static ArrayList<FormaPagamento> retornarFormasPagamento(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarFormasPagamento();
    }

    public static long AtualizaFormaPagamento(Context context, Pedido pedido, int idPedido){
        BancoDeDado bd = new BancoDeDado(context);
        return bd.AtualizaFormaPAgamento(pedido, idPedido);
    }

}
