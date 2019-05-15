package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class UsuarioDAO {

<<<<<<< HEAD
    private static boolean valorReferencia;
=======
    public static long cadastrarCidade(Context context, Usuario usuario){
        BancoDados banco = new BancoDados(context);

        return banco.CadastrarUsuario(usuario);

    }


    /*public static long ValidarLogin(Context context, Login login){
>>>>>>> 29c422762773c46bba3515249fd1b42e7f4b1e72

    public static boolean ValidarLogin(Context context, Login login){

        BancoDados db = new BancoDados(context);
        return valorReferencia =  db.ValidadaLogin(login);
    }


}
