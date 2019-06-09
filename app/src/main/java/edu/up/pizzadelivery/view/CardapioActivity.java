package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.SaboresAdapter;
import edu.up.pizzadelivery.Adapter.TamanhosAdapter;
import edu.up.pizzadelivery.DAO.SaborDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CardapioActivity extends AppCompatActivity {

    private ListView lstSabores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");

        lstSabores = (ListView) findViewById(R.id.lstSabores);


        final ArrayList<Sabor> saboresArrayList = SaborDAO.retornarSabor(this);
        String[] sabores = new String[saboresArrayList.size()];

        for (int i = 0; i < saboresArrayList.size(); i++) {
            sabores[i] = saboresArrayList.get(i).getNome();

        }

        SaboresAdapter saboresAdapter = new SaboresAdapter(saboresArrayList,this);
        //O adapter é componente que prepara os dados para o ListView

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, sabores);
        //setAdapter é método que vai popular os dados dentro do ListView
        lstSabores.setAdapter(saboresAdapter);
        //Criar o clique de cada do ListView


    }
}
