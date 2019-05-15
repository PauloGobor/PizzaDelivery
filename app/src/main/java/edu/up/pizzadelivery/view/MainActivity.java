package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Login;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail,
                     edtSenha;

    private Button   btnEntrar;

    private Long     verificacao;

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
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {

                    Login login = new Login();
                    login.setEmail(edtEmail.getText().toString());
                    login.setSenha(edtSenha.getText().toString());

                    //preciso que verifique uma daL para esse comando
                    //verificacao = LoginDAL.VerificaDadao(this, login);

                    //Verifica se existe  no banco.
                    if(verificacao == 0){
                        //Intent telaInicial = new Intent(this, TelaInicialActivity.class); ///esse irei criar mais para frente
                        //startActivity(telaInicial);

                    }else {
                        Toast.makeText(MainActivity.this, "E-mail/senha incorreto.", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(MainActivity.this, "Favor preencher os campos!", Toast.LENGTH_SHORT).show();
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
