package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.up.pizzadelivery.Adapter.TamanhosAdapter;
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

       // TamanhosAdapter tamanhosAdapter = new TamanhosAdapter(tamanhosArrayList,this);
        //O adapter é componente que prepara os dados para o ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, tamanhos);


        //setAdapter é método que vai popular os dados dentro do ListView
        lstTamanhos.setAdapter(adapter);
        //Criar o clique de cada do ListView
        lstTamanhos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
// *****************************************************************************
//******        aqui eu consigo o resultado da data completa    *****************
// ************************************************************************* ***
        Date data = new Date();
        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String data_completa = dateFormat.format(data_atual);
        Log.i("data_completa", data_completa);
//
// ********************************************************************************



        lstTamanhos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(EscolherTamanhoActivity.this, BordaActivity.class);
                intent.putExtra("TAMANHO", tamanhosArrayList.get(position));
                startActivity(intent);




            }
        });

    }


}
