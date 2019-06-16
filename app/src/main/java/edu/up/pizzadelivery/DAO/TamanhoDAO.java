package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Tamanho;

public class TamanhoDAO {

    public static ArrayList<Tamanho> retornarTamanhos(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarTamanhos();
    }


}
