package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.up.pizzadelivery.R;

public class EscolherTamanhoActivity extends AppCompatActivity {

    private ListView lstTamanhos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_tamanho);

        lstTamanhos = (ListView) findViewById(R.id.lstTamanhos);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, lstTamanhos);

//        lstTamanhos.setAdapter(adapter);
    }
}
