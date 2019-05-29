package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Ingrediente;


public class IngredientesDAO {

    public static ArrayList<Ingrediente> retornarIngredientes(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarIngredientes();
    }
}
