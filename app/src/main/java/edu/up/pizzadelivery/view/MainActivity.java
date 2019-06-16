package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.up.pizzadelivery.DAO.Contrato;
import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Criptografia;
import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Login;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout edtEmail,
                            edtSenha;
    private Button   btnEntrar;
    private boolean  verificacao;
    private static  final  String ARQUIVO_PREF = "LogUsuario";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail  =  findViewById(R.id.edtEmail);
        edtSenha  =  findViewById(R.id.edtSenha);
        btnEntrar =    findViewById(R.id.btnEntrar);


        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, MODE_PRIVATE);
        String verificaexistencia1 = (String) settings.getString("Email","" );
        String verificaexistencia2 = (String) settings.getString("Senha", "");

        if(!verificaexistencia1.equals("") && !verificaexistencia2.equals("")){
            Intent telaInicial = new Intent(MainActivity.this, AreaClienteActivity.class);
            startActivity(telaInicial);
        }


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verificação se campos estão preenchidos
                if (!edtEmail.getEditText().getText().toString().equals("") && !edtSenha.getEditText().getText().toString().equals("")) {
                    Criptografia crip = new Criptografia();
                    String senhaConv = crip.criptografar(edtSenha.getEditText().getText().toString());

                    Login login = new Login();
                    login.setEmail(edtEmail.getEditText().getText().toString());
                    login.setSenha(senhaConv);

                    verificacao = UsuarioDAO.ValidarLogin(MainActivity.this, login);

                    //Verifica se existe  no banco.
                    if(verificacao){

                        SharedPreferences sheredPreferences = getSharedPreferences(ARQUIVO_PREF,0);
                        SharedPreferences.Editor editor =  sheredPreferences.edit();

                        editor.putString("Email", edtEmail.getEditText().getText().toString());
                        editor.putString("Senha", senhaConv);
                        editor.commit();


                        Intent telaInicial = new Intent(MainActivity.this, AreaClienteActivity.class);
                        startActivity(telaInicial);

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


    public void TelaLocalizacao(View view) {
        Intent localizacao = new Intent(this, MapsActivity.class);
        startActivity(localizacao);
    }

}
