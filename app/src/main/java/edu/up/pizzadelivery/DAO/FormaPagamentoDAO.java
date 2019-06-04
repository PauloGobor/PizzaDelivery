package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Tamanho;

public class FormaPagamentoDAO {

    public static ArrayList<FormaPagamento> retornarFormasPagamento(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarFormasPagamento();
    }

}
