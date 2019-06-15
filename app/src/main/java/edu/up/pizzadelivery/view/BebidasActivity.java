package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.BebidaAdapter;
import edu.up.pizzadelivery.Adapter.SaboresAdapter;
import edu.up.pizzadelivery.DAO.BebidaDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class BebidasActivity extends AppCompatActivity {


    private ListView lstBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        lstBebidas = (ListView) findViewById(R.id.ListBebidas);
        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
        final Borda borda = (Borda) getIntent().getSerializableExtra("BORDA");



        final ArrayList<Bebida> bebidasArrayList = BebidaDAO.retornarBebidas(this);
        String[] bebidas = new String[bebidasArrayList.size()];

        for (int i = 0; i < bebidasArrayList.size(); i++) {
            bebidas[i] = bebidasArrayList.get(i).getNome();
        }

        BebidaAdapter bebidasAdapter = new BebidaAdapter(bebidasArrayList, this);
        //O adapter é componente que prepara os dados para o ListView
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, bebidas);
        //setAdapter é método que vai popular os dados dentro do ListView
        lstBebidas.setAdapter(bebidasAdapter);

        lstBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(BebidasActivity.this, CarrinhoActivity.class);
                intent.putExtra("BEBIDA", bebidasArrayList.get(position));
                intent.putExtra("BORDA", borda);
                intent.putExtra("TAMANHO", tamanho);

                startActivity(intent);
            }
        });


    }
}
