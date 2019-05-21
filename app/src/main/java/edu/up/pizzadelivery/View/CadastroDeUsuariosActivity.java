package edu.up.pizzadelivery.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.R;

public class CadastroDeUsuariosActivity extends AppCompatActivity {

    private EditText edtNome,
            edtEmail,
            edtCpf,
            edtTel,
            edtCep,
            edtRua,
            edtBairro,
            edtCidade,
            edtNumero,
            edtComplemento,
            edtSenha,
            edtConfSenha;

    private Button btnCadastrar;


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
                if (!edtNome.getText().toString().equals("") &&
                        !edtEmail.getText().toString().equals("") &&
                        !edtCpf.getText().toString().equals("") &&
                        !edtTel.getText().toString().equals("") &&
                        !edtCep.getText().toString().equals("") &&
                        !edtRua.getText().toString().equals("") &&
                        !edtBairro.getText().toString().equals("") &&
                        !edtCidade.getText().toString().equals("") &&
                        !edtNumero.getText().toString().equals("") &&
                        !edtComplemento.getText().toString().equals("") &&
                        !edtSenha.getText().toString().equals("") &&
                        !edtConfSenha.getText().toString().equals("")) {
                    if(edtSenha.getText().toString().equals(edtConfSenha.getText().toString())){

                        /// 1- verificar se email e cpf ja existem cadastrado
                        /// 2- realizar conversao de senha para criptografia
                        /// 3- salvar dados Usuario
                        /// 4- salvar dados endereco
                        /// 5- retornar confirmacao de cadastro ou erro (Toast ou AlertDialog)
                        /// 6- Avisar que será redirecionado para tela de login
                        /// 7- redirecionar para tela de login

                    }else{
                        Toast.makeText(CadastroDeUsuariosActivity.this, "Senhas não correspondem!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CadastroDeUsuariosActivity.this, "Favor preencher todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
