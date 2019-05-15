package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Login;

public class UsuarioDAO {

    private static boolean valorReferencia;

    public static boolean ValidarLogin(Context context, Login login){

        BancoDados db = new BancoDados(context);
        return valorReferencia =  db.ValidadaLogin(login);
    }


}
