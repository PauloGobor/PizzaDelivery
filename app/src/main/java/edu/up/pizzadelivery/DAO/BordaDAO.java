package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Borda;

public class BordaDAO {
    public static ArrayList<Borda> retornarBordas(Context context){
        BancoDeDado banco = new BancoDeDado(context);
        return banco.RetornarBordas();
    }


}
