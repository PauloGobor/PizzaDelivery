package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Tamanho;

public class CardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        Tamanho tamano = (Tamanho) getIntent().getSerializableExtra("TAMANHO");

    }
}
