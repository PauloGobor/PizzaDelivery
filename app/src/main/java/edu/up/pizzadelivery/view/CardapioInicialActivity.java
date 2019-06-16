package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import edu.up.pizzadelivery.DAO.SaborDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Sabor;


public class CardapioInicialActivity extends AppCompatActivity {
    private ListView lstSabores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio_inicial);

        lstSabores = (ListView) findViewById(R.id.lstSabores);
        final ArrayList<Sabor> saboresArrayList = SaborDAO.retornarSabor(this);

        String[] strings = new String[saboresArrayList.size()];

        for (int i = 0; i < saboresArrayList.size(); i++) {
            strings[i] = saboresArrayList.get(i).getNome();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,strings);

        lstSabores.setAdapter(adapter);

//        for (int i = 0; i < saboresArrayList.size(); i++) {
//            sabores[i] = saboresArrayList.get(i).getNome();
//        }
//
//        SaboresAdapter saboresAdapter = new SaboresAdapter(saboresArrayList, tamanho, this);
//        //O adapter é componente que prepara os dados para o ListView
//        lstSabores.setAdapter(saboresAdapter);

    }
}
