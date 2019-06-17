package edu.up.pizzadelivery.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Criptografia;
import edu.up.pizzadelivery.model.Endereco;
import edu.up.pizzadelivery.model.Usuario;

public class CadastroDeUsuariosActivity extends AppCompatActivity {

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
    private TextInputLayout edtConfSenha;


    private Button btnCadastrar;
    private boolean RtVerific;  //retorno para verificacao
    private long    RtVerCadUser;   //retorno para verificao cadastro
    private long    RtVerCadEndereco;   //retorno para verificao cadastro de endereco


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_usuarios);

        edtNome        = findViewById(R.id.edtNome);
        edtEmail       = findViewById(R.id.edtEmail);
        edtCpf         = findViewById(R.id.edtCpf);
        edtTel         = findViewById(R.id.edtTel);
        edtCep         = findViewById(R.id.edtCep);
        edtRua         = findViewById(R.id.edtRua);
        edtBairro      = findViewById(R.id.edtBairro);
        edtCidade      = findViewById(R.id.edtCidade);
        edtNumero      = findViewById(R.id.edtNumero);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtSenha       = findViewById(R.id.edtSenha);
        edtConfSenha   = findViewById(R.id.edtConfSenha);

        btnCadastrar   = findViewById(R.id.btnCadastrar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validaNome() | !validaEmail() | !validaCpf() | !validaTel() | !validaCep() | !validaRua() | !validaBairro() | !validaCidade() |
                !validaNumero() | !validaSenha()| !validaConfSenha() | !validaIgualdadeSenha()){
                    return;
                }

                /// 1- verificar se email e cpf ja existem cadastrado
                RtVerific = UsuarioDAO.JaCadastrado(CadastroDeUsuariosActivity.this, edtEmail.getEditText().getText().toString(), edtCpf.getEditText().getText().toString());

                if(RtVerific == false){
                    /// 2- realizar conversao de senha para criptografia
                    Criptografia crip = new Criptografia();
                    String senhaConv =   crip.criptografar(edtSenha.getEditText().getText().toString());


                    //pegando dados e passando para um classe usuario
                    Usuario usuario = new Usuario();
                    usuario.setNome(edtNome.getEditText().getText().toString());
                    usuario.setEmail(edtEmail.getEditText().getText().toString());
                    usuario.setCpf(edtCpf.getEditText().getText().toString());
                    usuario.setTelefone(edtTel.getEditText().getText().toString());
                    usuario.setSenha(senhaConv); /// vai ser criptografado antes.

                    /// 3- salvar dados Usuario e endereco

                    RtVerCadUser = (long) UsuarioDAO.CadastrarUsuario(CadastroDeUsuariosActivity.this, usuario);

                    Endereco endereco = new Endereco();

                    endereco.setCep(edtCep.getEditText().getText().toString());
                    endereco.setRua(edtRua.getEditText().getText().toString());
                    endereco.setBairro(edtBairro.getEditText().getText().toString());
                    endereco.setCidade(edtCidade.getEditText().getText().toString());
                    endereco.setNumero(Integer.parseInt(edtNumero.getEditText().getText().toString()));
                    endereco.setComplemento(edtComplemento.getEditText().getText().toString());
                    usuario.setId((int) RtVerCadUser);
                    endereco.setUsuario(usuario);

                    RtVerCadEndereco = (long) UsuarioDAO.CadastrarEndereco(CadastroDeUsuariosActivity.this, endereco);

                    if(RtVerCadUser != -1){
                        if( RtVerCadEndereco != -1){
                            /// 6- Avisar que será redirecionado para tela de login
                            MenssagemConfCad();

                            /// 7- redirecionar para tela de login
                            for(int i = 0; i < 10000; i++ ){
                                if(i == 10000){
                                    Intent telaLogin = new Intent(CadastroDeUsuariosActivity.this, MainActivity.class);
                                    startActivity(telaLogin);
                                }
                            }

                        }else {// mensagem de erro.
                            Toast.makeText(CadastroDeUsuariosActivity.this, "Problema ao realizar o cadastro. Tente Mais tarde! Erro 4.2", Toast.LENGTH_SHORT).show();
                        }
                    }else {// mensagem de erro.
                        Toast.makeText(CadastroDeUsuariosActivity.this, "Problema ao realizar o cadastro. Tente Mais tarde! Erro 4.1", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(CadastroDeUsuariosActivity.this, "E-mail ou Senha já cadastrados!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void MenssagemConfCad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cadastro Realizado com Sucesso");
        builder.setMessage("Você será redireiconado para a tela de login!");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent telaLogin = new Intent(CadastroDeUsuariosActivity.this, MainActivity.class);
                startActivity(telaLogin);
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


    private boolean validaSenha(){
        String senhaInput = edtSenha.getEditText().getText().toString().trim();
        if(senhaInput.isEmpty()){
            edtSenha.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtSenha.setError(null);
            edtSenha.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaConfSenha(){
        String confSenhaInput = edtConfSenha.getEditText().getText().toString().trim();
        if(confSenhaInput.isEmpty()){
            edtConfSenha.setError("Campo não pode estar vazio!");
            return false;
        }else {
            edtConfSenha.setError(null);
            edtConfSenha.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validaIgualdadeSenha(){
        String senhaInput = edtSenha.getEditText().getText().toString().trim();
        String confSenhaInput = edtConfSenha.getEditText().getText().toString().trim();

        if(!confSenhaInput.equals(senhaInput)){
            edtConfSenha.setError("Confirmação de senha deve identica a senha!");
            return false;
        }else {
            edtConfSenha.setError(null);
            edtConfSenha.setErrorEnabled(false);
            return true;
        }
    }

}

