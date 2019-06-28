package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.CarrinhoAdapter;
import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.ItemPedido;

public class DetalhesPedidoActivity extends AppCompatActivity {

    private ListView lstDetlhesPedido;
    private TextView pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pedido);

        pedido =  findViewById(R.id.txtPedido);
        lstDetlhesPedido = (ListView) findViewById(R.id.lstDetalhesPedido);


        Bundle bundle = getIntent().getExtras();
        final int idPedido = bundle.getInt("IDPEDIDO");

        pedido.setText("Pedido n°:" + idPedido);


        final ArrayList<ItemPedido> itemsArrayList = ItemPedidoDAO.retornarItemPedido(this, idPedido);


        String[] items = new String[itemsArrayList.size()];

        for (int i = 0; i < itemsArrayList.size(); i++) {
            items[i] = String.valueOf(itemsArrayList.get(i).getPizza().getTamanho().getNome());
        }

        CarrinhoAdapter CarrinhoAdapter = new CarrinhoAdapter(itemsArrayList, this);

        lstDetlhesPedido.setAdapter(CarrinhoAdapter);



    }
}
