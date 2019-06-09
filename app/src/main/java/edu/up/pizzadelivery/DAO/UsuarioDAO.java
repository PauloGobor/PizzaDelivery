package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Endereco;
import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class UsuarioDAO {


//    ##################################################
    //### SHARED PREFERENCE ->  VERIFICACAO DE QUEM ESTA LOGADO   cookies ######

//    ####################################################
    private static boolean valorReferencia;
    private static BancoDeDado db;

    public static long CadastrarUsuario(Context context, Usuario usuario){
        db = new BancoDeDado(context);

        return db.CadastrarUsuario(usuario);

    }

    public static long CadastrarEndereco(Context context, Endereco endereco){
        db = new BancoDeDado(context);

        return db.CadastrarEndereco(endereco);

    }


    public static boolean ValidarLogin(Context context, Login login){

        db = new BancoDeDado(context);

        return valorReferencia =  db.ValidadaLogin(login);
    }
    public  static boolean JaCadastrado(Context context, String email, String cpf){
        db = new BancoDeDado(context);
        valorReferencia = db.JaCadastrado(email, cpf);

        if( valorReferencia == true){
            return true;
        }else {
            return false;
        }
    }



}
