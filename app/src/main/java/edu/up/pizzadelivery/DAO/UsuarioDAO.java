package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class UsuarioDAO {

    private static boolean     valorReferencia;
    private static BancoDados  db;

    public static long CadastrarUsuario(Context context, Usuario usuario){
        db = new BancoDados(context);

        return db.CadastrarUsuario(usuario);

    }

    public static boolean ValidarLogin(Context context, Login login){

        db = new BancoDados(context);

        return valorReferencia =  db.ValidadaLogin(login);
    }


}
