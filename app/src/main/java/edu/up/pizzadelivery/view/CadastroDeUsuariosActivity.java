package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Usuario;

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
    private boolean RtVerific;


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
                        RtVerific = UsuarioDAO.JaCadastrado(CadastroDeUsuariosActivity.this, edtEmail.getText().toString(), edtCpf.getText().toString());

                        if(RtVerific){
                            //pegando dados e passando para um classe usuario
                            Usuario usuario = new Usuario();
                            usuario.setNome(edtNome.getText().toString());
                            usuario.setEmail(edtEmail.getText().toString());
                            usuario.setCpf(edtCpf.getText().toString());
                            usuario.setTelefone(edtTel.getText().toString());
                            usuario.setSenha(edtSenha.getText().toString()); /// vai ser criptografado antes.
                            //Parte de endereco
                            usuario.getEndereco().setCep(edtCep.getText().toString());
                            usuario.getEndereco().setRua(edtRua.getText().toString());
                            usuario.getEndereco().setCidade(edtCidade.getText().toString());
                            usuario.getEndereco().setNumero(Integer.parseInt(edtNumero.getText().toString()));
                            usuario.getEndereco().setComplemento(edtComplemento.getText().toString());
                        }else {
                            Toast.makeText(CadastroDeUsuariosActivity.this, "E-mail ou Senha já cadastrados!", Toast.LENGTH_SHORT).show();
                        }


                        /// 2- realizar conversao de senha para criptografia
                        /// 3- salvar dados Usuario
                        /// 4- salvar dados endereco
                        /// 5- retornar confirmacao de cadastro ou erro (Toast ou AlertDialog)
                        /// 6- Avisar que será redirecionado para tela de login
                        /// 7- redirecionar para tela de login
                        /// 8- colocar receber bairro paramentro

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
