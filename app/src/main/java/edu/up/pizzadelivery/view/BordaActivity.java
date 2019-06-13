package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.BebidaAdapter;
import edu.up.pizzadelivery.Adapter.BordaAdapter;
import edu.up.pizzadelivery.DAO.BebidaDAO;
import edu.up.pizzadelivery.DAO.BordaDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.Pizza;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class BordaActivity extends AppCompatActivity {

    private ListView lstBordas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borda);

        lstBordas = (ListView) findViewById(R.id.lstBordas);
        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
        final Sabor sabor = (Sabor) getIntent().getSerializableExtra("SABOR");



        final ArrayList<Borda> bordasArrayList = BordaDAO.retornarBordas(this);
        String[] bordas = new String[bordasArrayList.size()];

        for (int i = 0; i < bordasArrayList.size(); i++) {
            bordas[i] = bordasArrayList.get(i).getNome();

        }
        //O adapter é componente que prepara os dados para o ListView
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, bordas);

        BordaAdapter bordasAdapter = new BordaAdapter(bordasArrayList, this);
        //setAdapter é método que vai popular os dados dentro do ListView
        lstBordas.setAdapter(bordasAdapter);

        lstBordas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(BordaActivity.this, BebidasActivity.class);
                intent.putExtra("BORDA", bordasArrayList.get(position));
                intent.putExtra("TAMANHO",tamanho);
                intent.putExtra("SABOR",sabor);
                startActivity(intent);
            }
        });



    }
}
