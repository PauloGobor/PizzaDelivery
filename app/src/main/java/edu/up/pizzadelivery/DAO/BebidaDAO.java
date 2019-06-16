package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Bebida;


public class BebidaDAO {
    public static ArrayList<Bebida> retornarBebidas(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarBebidas();

    }

}
