package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.Adapter.SaboresAdapter;
import edu.up.pizzadelivery.Adapter.TamanhosAdapter;
import edu.up.pizzadelivery.DAO.SaborDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CardapioActivity extends AppCompatActivity {

    private ListView lstSabores;
    private TextView txtTamanhoSelec, txtContador;
    private Button btnAvancarCard;
    private List<Sabor> SaboresSelecionados;
    private Tamanho tamanhoselecionado;
    private int cliqueSabor = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
        final Borda borda = (Borda) getIntent().getSerializableExtra("BORDA");

        lstSabores = (ListView) findViewById(R.id.lstSabores);
        txtTamanhoSelec = (TextView) findViewById(R.id.txtTamanhoSelec);
        txtContador = (TextView) findViewById(R.id.txtContador);
        btnAvancarCard = (Button) findViewById(R.id.btnAvancarCard);

        final ArrayList<Sabor> saboresEscolhidosArrayList = new ArrayList<Sabor>();
        final ArrayList<Sabor> saboresArrayList = SaborDAO.retornarSabor(this);
        final String[] sabores = new String[saboresArrayList.size()];
        // zera sabores/
        saboresEscolhidosArrayList.clear();

        tamanhoselecionado = tamanho;
        for (int i = 0; i < saboresArrayList.size(); i++) {
            sabores[i] = saboresArrayList.get(i).getNome();
        }
        txtTamanhoSelec.setText(String.valueOf(tamanhoselecionado.getQtdSabores()));
        SaboresAdapter saboresAdapter = new SaboresAdapter(saboresArrayList, tamanho, this);
        //O adapter é componente que prepara os dados para o ListView

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, sabores);
        //setAdapter é método que vai popular os dados dentro do ListView

        lstSabores.setAdapter(saboresAdapter);
        //Criar o clique de cada do ListView

        lstSabores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cliqueSabor = cliqueSabor + 1;

                if (cliqueSabor > tamanhoselecionado.getQtdSabores()) {

                    Toast.makeText(CardapioActivity.this, "acaboua selecao", Toast.LENGTH_SHORT).show();

                }else{
                   // Log.i("escolido", saboresEscolhidosArrayList.get(position).getNome());
                    saboresEscolhidosArrayList.add(saboresArrayList.get(position));
                    ///sabores adicionados com sucesso
                    txtContador.setText(txtContador.getText()+"-"+String.valueOf(saboresArrayList.get(position).getNome()));
                    //Log.i("veja", ""+saboresEscolhidosArrayList.get(position).getNome());
                }
//
                // saboresSelecionados
//               // passando tamanho
//               intent.putExtra("TAMANHO", tamanho);
//               //passando sabor
//               intent.putExtra("SABOR",saboresArrayList.get(position));
//                startActivity(intent);

            }
        });

        btnAvancarCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardapioActivity.this, BebidasActivity.class);

//                  CADASTRAR PIZZA

               // passando tamanho
               intent.putExtra("TAMANHO", tamanho);
                intent.putExtra("BORDA", borda);
               //passando sabor
               intent.putExtra("SABOR",saboresEscolhidosArrayList);
               startActivity(intent);


            }
        });

    }
}
