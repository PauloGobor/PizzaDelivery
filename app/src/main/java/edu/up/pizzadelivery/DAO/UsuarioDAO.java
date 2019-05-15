package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class UsuarioDAO {


    private static boolean valorReferencia;

//    public static long cadastrarCidade(Context context, Usuario usuario){
//        BancoDados banco = new BancoDados(context);
//
//        return banco.CadastrarUsuario(usuario);
//
//    }

    public static boolean ValidarLogin(Context context, Login login){

        BancoDados db = new BancoDados(context);
        return valorReferencia =  db.ValidadaLogin(login);
    }


}
