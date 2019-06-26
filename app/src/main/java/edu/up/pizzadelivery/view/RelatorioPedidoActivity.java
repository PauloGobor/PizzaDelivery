package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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



        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, MODE_PRIVATE);
        String verificaexistencia1 = (String) settings.getString("Email","" );
        //Pega Id do usuario para fazer busca
        Usuario usuario =  UsuarioDAO.RetornaUsuario(this, verificaexistencia1);
        int idUsuario = usuario.getId();


        final ArrayList<Pedido> itemsArrayList = PedidoDAO.retornarPedidos(this, idUsuario);
        String[] items = new String[itemsArrayList.size()];

        for (int i = 0; i < itemsArrayList.size(); i++) {
            items[i] = String.valueOf(itemsArrayList.get(i).getId());
            items[i] = String.valueOf(itemsArrayList.get(i).getData());
            items[i] = String.valueOf(itemsArrayList.get(i).getUsuario().getNome());
            items[i] = String.valueOf(itemsArrayList.get(i).getItensPedido());
            items[i] = String.valueOf(itemsArrayList.get(i).getFormaPagamento().getNome());

        }
        //O adapter é componente que prepara os dados para o ListView
        RelatorioAdapter relatorio = new RelatorioAdapter(itemsArrayList, this);


        //setAdapter é método que vai popular os dados dentro do ListView
        lstPedido.setAdapter(relatorio);

    }

    public void btnNovoPedido(View view) {
        Intent novoPedido = new Intent(this, EscolherTamanhoActivity.class);
        startActivity(novoPedido);
    }
}
