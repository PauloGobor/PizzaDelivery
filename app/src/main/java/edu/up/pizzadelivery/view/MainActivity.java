package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import edu.up.pizzadelivery.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TelaCadastroPessoa(View view) {
        Intent cadastroPessoa =  new Intent(this, CadastroPessoasActivity.class);
        startActivity(cadastroPessoa);
    }

    public void TelaCardapio(View view) {
        Intent cardapio = new Intent(this, CardapioActivity.class);
        startActivity(cardapio);
    }
}
