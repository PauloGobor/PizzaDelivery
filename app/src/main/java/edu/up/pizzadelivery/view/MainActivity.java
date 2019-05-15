package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.R;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button btnEntrar;

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



                }else{
                    Toast.makeText(MainActivity.this, "Favor preencher os campos de login!", Toast.LENGTH_SHORT).show();
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
