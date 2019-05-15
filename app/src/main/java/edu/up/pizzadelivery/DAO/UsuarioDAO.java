package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class UsuarioDAO {

    public static long cadastrarCidade(Context context, Usuario usuario){
        BancoDados banco = new BancoDados(context);

        return banco.CadastrarUsuario(usuario);

    }


    /*public static long ValidarLogin(Context context, Login login){

        Banco db = new Banco(Context);
        return db.ValidaLogin(login);
    }*/


}
