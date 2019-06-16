package edu.up.pizzadelivery.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.up.pizzadelivery.R;

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
    private TextInputLayout edtConfSenha;

    private Button btnSalvar;
    private Button btnEncerrarConta;

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
        edtConfSenha     = findViewById(R.id.edtConfSenha);
        btnSalvar        = findViewById(R.id.btnSalvar);
        btnEncerrarConta = findViewById(R.id.btnEncerrarConta);


        btnEncerrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validaNome() | !validaEmail() | !validaCpf() | !validaTel() | !validaCep() | !validaRua() | !validaBairro() | !validaCidade() |
                        !validaNumero()){
                    return;
                }else{


                }


            }
        });

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
