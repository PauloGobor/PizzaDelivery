package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Tamanho;

public class EscolherTamanhoActivity extends AppCompatActivity {

    private ListView lstTamanhos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_tamanho);

        lstTamanhos = (ListView) findViewById(R.id.lstTamanhos);

        final ArrayList<Tamanho> tamanhosArrayList = TamanhoDAO.retornarTamanhos(this);
        String[] tamanhos = new String[tamanhosArrayList.size()];

        for (int i = 0; i < tamanhosArrayList.size(); i++) {
            tamanhos[i] = tamanhosArrayList.get(i).getNome();

        }

        //O adapter é componente que prepara os dados para o ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tamanhos);
        //setAdapter é método que vai popular os dados dentro do ListView
        lstTamanhos.setAdapter(adapter);
        //Criar o clique de cada do ListView
        lstTamanhos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(EscolherTamanhoActivity.this, CardapioActivity.class);
                intent.putExtra("TAMANHO", tamanhosArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}
