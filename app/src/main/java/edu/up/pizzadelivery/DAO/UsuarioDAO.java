package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.Model.Login;
import edu.up.pizzadelivery.Model.Usuario;

public class UsuarioDAO {

    private static boolean valorReferencia;
    private static BancoDeDado db;

    public static long CadastrarUsuario(Context context, Usuario usuario){
        db = new BancoDeDado(context);

        return db.CadastrarUsuario(usuario);

    }

    public static boolean ValidarLogin(Context context, Login login){

        db = new BancoDeDado(context);

        return valorReferencia =  db.ValidadaLogin(login);
    }
    public  static boolean JaCadastrado(Context context, String email, String cpf){
        db = new BancoDeDado(context);

        return valorReferencia = db.JaCadastrado(email, cpf);
    }



}
