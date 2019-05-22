package edu.up.pizzadelivery.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.Model.Login;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail,
                     edtSenha;

    private Button   btnEntrar;

    private boolean  verificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail  = (EditText) findViewById(R.id.edtEmail);
        edtSenha  = (EditText) findViewById(R.id.edtSenha);
        btnEntrar = (Button)   findViewById(R.id.btnEntrar);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verificação se campos estão preenchidos
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {

                    Login login = new Login();
                    login.setEmail(edtEmail.getText().toString());
                    login.setSenha(edtSenha.getText().toString());

                    verificacao = UsuarioDAO.ValidarLogin(MainActivity.this, login);


                    //Verifica se existe  no banco.
                    if(verificacao){
                        //Intent telaInicial = new Intent(this, TelaInicialActivity.class); ///esse irei criar mais para frente
                        //startActivity(telaInicial);

                        Toast.makeText(MainActivity.this, "Entrou", Toast.LENGTH_SHORT).show();

                    }else {
                        //Caso não encontrar nenhum dado equivalente no banco
                        Toast.makeText(MainActivity.this, "E-mail/senha incorreto.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Favor preencher todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    ///Comando que chama a tela de cadastro
    public void TelaCadastroPessoa(View view) {
        Intent cadastroPessoa = new Intent(this, CadastroDeUsuariosActivity.class);
        startActivity(cadastroPessoa);
    }

    ///Comando que chama a tela de cardápio
    public void TelaCardapio(View view) {
        Intent cardapio = new Intent(this, CardapioActivity.class);
        startActivity(cardapio);
    }
}
