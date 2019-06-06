package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;


import edu.up.pizzadelivery.model.Sabor;

public class SaborDAO {

    public static ArrayList<Sabor> retornarSabor(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarSabores();
    }
}
