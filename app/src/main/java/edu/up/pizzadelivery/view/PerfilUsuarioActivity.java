package edu.up.pizzadelivery.view;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Criptografia;
import edu.up.pizzadelivery.model.Endereco;
import edu.up.pizzadelivery.model.Usuario;
import edu.up.pizzadelivery.utils.notification;

public class PerfilUsuarioActivity extends AppCompatActivity {


    private TextInputLayout edtNome;
    private TextInputLayout edtEmail;
    private TextInputLayout edtCpf;
    private TextInputLayout edtTel;
    private TextInputLayout edtCep;
    private TextInputLayout edtRua;
    private TextInputLayout edtBairro;
    private TextInputLayout edtCidade;
    private TextInputLayout edtNumero;
    private TextInputLayout edtComplemento;
    private TextInputLayout edtSenha;

    private Button btnSalvar;
    private Button btnEncerrarConta;
    private static  final  String ARQUIVO_PREF = "LogUsuario";
    private String senhaConv;
    String TITULO =  "PizzaDelivery";
    String TEXTO =  "Dados Atualizados com sucesso!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        edtNome          = findViewById(R.id.edtNome);
        edtEmail         = findViewById(R.id.edtEmail);
        edtCpf           = findViewById(R.id.edtCpf);
        edtTel           = findViewById(R.id.edtTel);
        edtCep           = findViewById(R.id.edtCep);
        edtRua           = findViewById(R.id.edtRua);
        edtBairro        = findViewById(R.id.edtBairro);
        edtCidade        = findViewById(R.id.edtCidade);
        edtNumero        = findViewById(R.id.edtNumero);
        edtComplemento   = findViewById(R.id.edtComplemento);
        edtSenha         = findViewById(R.id.edtSenha);
        btnSalvar        = findViewById(R.id.btnSalvar);
        btnEncerrarConta = findViewById(R.id.btnEncerrarConta);

        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, MODE_PRIVATE);
        String shedEmail = (String) settings.getString("Email","" );

        final Usuario usuario = UsuarioDAO.RetornaUsuario(this, shedEmail);
        final int id = usuario.getId();
        edtNome.getEditText().setText(usuario.getNome());
        edtEmail.getEditText().setText(usuario.getEmail());
        edtCpf.getEditText().setText(usuario.getCpf());
        edtTel.getEditText().setText(usuario.getTelefone());

        final Endereco endereco = UsuarioDAO.RetornaEndereco(this, id);
        final int idEndereco = endereco.getId();
        edtCep.getEditText().setText(endereco.getCep());
        edtRua.getEditText().setText(endereco.getRua());
        edtBairro.getEditText().setText(endereco.getBairro());
        edtCidade.getEditText().setText(endereco.getCidade());
        edtNumero.getEditText().setText(String.valueOf(endereco.getNumero()));
        edtComplemento.getEditText().setText(endereco.getComplemento());

        btnEncerrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeletarConta(id, idEndereco);
            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validaNome() | !validaEmail() | !validaCpf() | !validaTel() | !validaCep() | !validaRua() | !validaBairro() | !validaCidade() |
                        !validaNumero()){
                    return;
                }else{

                    if(!edtSenha.getEditText().getText().toString().equals("")) {
                        Criptografia crip = new Criptografia();
                        senhaConv = crip.criptografar(edtSenha.getEditText().getText().toString());
                    }else {
                        senhaConv = usuario.getSenha();
                    }
                    //pegando dados e passando para um classe usuario
                    Usuario usuario1 = new Usuario();
                    usuario1.setId(id);
                    usuario1.setNome(edtNome.getEditText().getText().toString());
                    usuario1.setEmail(edtEmail.getEditText().getText().toString());
                    usuario1.setCpf(edtCpf.getEditText().getText().toString());
                    usuario1.setTelefone(edtTel.getEditText().getText().toString());
                    usuario1.setSenha(senhaConv);

                    /// Atualizando os dados no banco por parte do usaurio

                     long rtUpdateUsuario  =   UsuarioDAO.UpdateUsuario(PerfilUsuarioActivity.this, usuario1);

                    Endereco endereco1 = new Endereco();
                    endereco1.setId(idEndereco);
                    endereco1.setCep(edtCep.getEditText().getText().toString());
                    endereco1.setRua(edtRua.getEditText().getText().toString());
                    endereco1.setBairro(edtBairro.getEditText().getText().toString());
                    endereco1.setCidade(edtCidade.getEditText().getText().toString());
                    endereco1.setNumero(Integer.parseInt(edtNumero.getEditText().getText().toString()));
                    endereco1.setComplemento(edtComplemento.getEditText().getText().toString());
                    endereco1.setUsuario(usuario1);

                     long rtUpdateEndereco = (long) UsuarioDAO.UpdateEndereco(PerfilUsuarioActivity.this, endereco1);

                    if(rtUpdateEndereco != -1 && rtUpdateUsuario != -1){
                    SharedPreferences sheredPreferences = getSharedPreferences(ARQUIVO_PREF,0);
                    SharedPreferences.Editor editor =  sheredPreferences.edit();

                    editor.putString("Email", edtEmail.getEditText().getText().toString());
                    editor.putString("Senha", senhaConv);
                    editor.commit();

                    // Cria uma notificacao de Atualizacao.
                        notification.enviarNotificacao(PerfilUsuarioActivity.this, TITULO, TEXTO );

                    }else{
                        Toast.makeText(PerfilUsuarioActivity.this,
                                "Problema ao realizar atualização dos dados! Tente novamente! Erro 5.1",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void NotificaçãoSucessoUpdate() {


//        Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationManager nn = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        NotificationCompat.Builder build = new NotificationCompat.Builder(this, id);
//
//        //build.setSmallIcon(R.drawable.ic_notifications_black_24dp);
//        //build.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_pizzadelivery_round));
//        build.setTicker("PizzaDelivery");
//        build.setContentTitle("PizzaDelivery");
//        build.setContentText("Dados Atualizados com Sucesso!");
//        build.setSound(som);
//        build.setVibrate(pattern);
//
//        Notification n = build.build();
//        nn.notify(1, build.build())
//        build.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
//        Ringtone toque = RingtoneManager.getRingtone(this, som);
//        toque.play();


    }

    private void DeletarConta(final int id ,final int idEndereco) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Excluir Contar");
        builder.setMessage("Tem certeza que deseja excluir sua conta?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sheredPreferences = getSharedPreferences(ARQUIVO_PREF,0);
                SharedPreferences.Editor editor =  sheredPreferences.edit();

                UsuarioDAO.DeletarUsuario(PerfilUsuarioActivity.this, id);
                UsuarioDAO.DeletarEndereco(PerfilUsuarioActivity.this, idEndereco);

                editor.putString("Email","");
                editor.putString("Senha","");
                editor.commit();
                Intent intent = new Intent(PerfilUsuarioActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
       builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private boolean validaNome(){
        String nomeInput = edtNome.getEditText().getText().toString().trim();
        if(nomeInput.isEmpty()){
            edtNome.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtNome.setError(null);
            edtNome.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validaEmail(){
        String emailInput = edtEmail.getEditText().getText().toString().trim();
        if(emailInput.isEmpty()){
            edtEmail.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtEmail.setError(null);
            edtEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaCpf(){
        String cpfInput = edtCpf.getEditText().getText().toString().trim();
        if(cpfInput.isEmpty()){
            edtCpf.setError("Campo não pode estar vazio!");
            return false;
        }else if(cpfInput.length() != 11){
            edtCpf.setError("Campo Cpf deve conter 11 digitos sem pontuação!");
            return false;
        }else {
            edtCpf.setError(null);
            edtCpf.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaTel(){
        String telInput = edtTel.getEditText().getText().toString().trim();
        if(telInput.isEmpty()){
            edtTel.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtTel.setError(null);
            edtTel.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaCep(){
        String cepInput = edtCep.getEditText().getText().toString().trim();
        if(cepInput.isEmpty()){
            edtCep.setError("Campo não pode estar vazio!");
            return false;
        }else if(cepInput.length() != 8){
            edtCep.setError("Campo Cep deve conter 8 digitos sem o hífen! ex.82115-000");
            return  false;
        }else {
            edtCep.setError(null);
            edtCep.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaRua(){
        String ruaInput = edtRua.getEditText().getText().toString().trim();
        if(ruaInput.isEmpty()){
            edtRua.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtRua.setError(null);
            edtRua.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaBairro(){
        String bairroInput = edtBairro.getEditText().getText().toString().trim();
        if(bairroInput.isEmpty()){
            edtBairro.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtBairro.setError(null);
            edtBairro.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaCidade(){
        String cidadeInput = edtCidade.getEditText().getText().toString().trim();
        if(cidadeInput.isEmpty()){
            edtCidade.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtCidade.setError(null);
            edtCidade.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validaNumero(){
        String numeroInput = edtNumero.getEditText().getText().toString().trim();
        if(numeroInput.isEmpty()){
            edtNumero.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtNumero.setError(null);
            edtNumero.setErrorEnabled(false);
            return true;
        }
    }
}
