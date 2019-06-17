package edu.up.pizzadelivery.DAO;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.model.Endereco;
import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;
import edu.up.pizzadelivery.view.PerfilUsuarioActivity;

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

    public static Usuario RetornaUsuario(Context context, String email){
        db = new BancoDeDado(context);
        return  db.RetornaUsuario(email);
    }

    public static Endereco RetornaEndereco (Context context, int id){
        db = new BancoDeDado(context);
        return db.RetornaEndereco(id);
    }

    public static void DeletarUsuario(Context context, int id){
        db = new BancoDeDado(context);
        db.deleteUsuario(id);
    }

    public static void DeletarEndereco(Context context, int id){
        db = new BancoDeDado(context);
        db.deleteEndereco(id);
    }

    public static long UpdateUsuario(Context context, Usuario usuario) {
        db = new BancoDeDado(context);
        return db.UpdateUsuario(usuario);
    }

    public static  long UpdateEndereco(Context context, Endereco endereco){
        db = new BancoDeDado(context);
        return db.UpdateEndereco(endereco);
    }

}
