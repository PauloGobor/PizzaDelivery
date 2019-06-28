package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.CarrinhoAdapter;
import edu.up.pizzadelivery.Adapter.RelatorioAdapter;
import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.DAO.PedidoDAO;
import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Usuario;

public class RelatorioPedidoActivity extends AppCompatActivity {

    private static  final  String ARQUIVO_PREF = "LogUsuario";
    private ListView lstPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_pedido);


        lstPedido = (ListView) findViewById(R.id.lstPedido);

        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, MODE_PRIVATE);
        String verificaexistencia1 = (String) settings.getString("Email","" );
        //Pega Id do usuario para fazer busca
        Usuario usuario =  UsuarioDAO.RetornaUsuario(this, verificaexistencia1);
        int idUsuario = usuario.getId();


        final ArrayList<Pedido> itemsArrayList = PedidoDAO.RetornaHistoricoPedido(this, idUsuario);
        final String[] items = new String[itemsArrayList.size()];



        for (int i = 0; i < itemsArrayList.size(); i++) {
            items[i] = String.valueOf(itemsArrayList.get(i).getData());
        }
        //O adapter é componente que prepara os dados para o ListView
        RelatorioAdapter relatorio = new RelatorioAdapter(itemsArrayList, this);

//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, items);


        //setAdapter é método que vai popular os dados dentro do ListView
        lstPedido.setAdapter(relatorio);


        lstPedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(RelatorioPedidoActivity.this, DetalhesPedidoActivity.class);
                intent.putExtra("IDPEDIDO",itemsArrayList.get(position).getId());
                startActivity(intent);

            }
        });



    }

    public void btnNovoPedido(View view) {
        Intent novoPedido = new Intent(this, AreaClienteActivity.class);
        startActivity(novoPedido);
    }
}
