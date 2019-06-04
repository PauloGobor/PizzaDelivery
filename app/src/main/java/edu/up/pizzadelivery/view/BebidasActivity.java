package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Tamanho;

public class BebidasActivity extends AppCompatActivity {

    private ListView lstBebidas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        lstBebidas = (ListView) findViewById(R.id.ListBebidas);




    }
}
