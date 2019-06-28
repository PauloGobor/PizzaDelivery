package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.up.pizzadelivery.Adapter.BordaAdapter;
import edu.up.pizzadelivery.Adapter.CarrinhoAdapter;
import edu.up.pizzadelivery.Adapter.SaboresAdapter;
import edu.up.pizzadelivery.DAO.BancoDeDado;
import edu.up.pizzadelivery.DAO.BebidaDAO;
import edu.up.pizzadelivery.DAO.BordaDAO;
import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView txtCarrinhoSubTotal;
    private double subtotal;
    private Button btnCardapio, btnPagamento, btnBebida;
    private ListView lstCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
        // final Sabor sabor = (Sabor) getIntent().getSerializableExtra("SABOR");
        final Borda borda = (Borda) getIntent().getSerializableExtra("BORDA");
        final Bebida bebida = (Bebida) getIntent().getSerializableExtra("BEBIDA");
        Bundle bundle = getIntent().getExtras();
        final int idPedido = bundle.getInt("IDPEDIDO");
        final int idItemPedido = bundle.getInt("IDITEMPEDIDO");

        btnCardapio = (Button) findViewById(R.id.btnCardapio);
        btnPagamento = (Button) findViewById(R.id.btnPagamento);
        txtCarrinhoSubTotal = (TextView) findViewById(R.id.txtCarrinhoSubTotal);
        lstCarrinho = (ListView) findViewById(R.id.lstCarrinho);
        btnBebida = (Button) findViewById(R.id.btnBebidas);
//      recebendo da activy anterior itens escolhidos


        // subtotal = subtotal+tamanho.getPreco()+borda.getPreco();
        Pedido p = new Pedido();
        p.setId(idPedido);
        double subtotal = ItemPedidoDAO.RetornarSomaCarrinho(this, p);

        txtCarrinhoSubTotal.setText(String.valueOf(subtotal));

        final ArrayList<ItemPedido> itemsArrayList = ItemPedidoDAO.retornarItemPedido(this, idPedido);


        final double subTotalPagamento = subtotal;

        String[] items = new String[itemsArrayList.size()];

        for (int i = 0; i < itemsArrayList.size(); i++) {
            items[i] = String.valueOf(itemsArrayList.get(i).getPizza().getTamanho().getNome());
        }
        //O adapter é componente que prepara os dados para o ListView
        CarrinhoAdapter CarrinhoAdapter = new CarrinhoAdapter(itemsArrayList, this);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, items);

        //BordaAdapter bordasAdapter = new BordaAdapter(itemsArrayList, this);
        //setAdapter é método que vai popular os dados dentro do ListView
        lstCarrinho.setAdapter(CarrinhoAdapter);

        // listar itens do carrinho....




        btnCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrinhoActivity.this, EscolherTamanhoActivity.class);
                intent.putExtra("IDPEDIDO", idPedido);
                startActivity(intent);

            }
        });

        btnPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrinhoActivity.this, PagamentoPedidoActivity.class);
                intent.putExtra("SUBTOTAL", subTotalPagamento);
                intent.putExtra("IDPEDIDO", idPedido);
                startActivity(intent);
            }
        });

        btnBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrinhoActivity.this, BebidasActivity.class);
                intent.putExtra("BORDA", borda);
                intent.putExtra("TAMANHO", tamanho);
                intent.putExtra("IDPEDIDO", idPedido);
                intent.putExtra("IDITEMPEDIDO", idItemPedido);
                startActivity(intent);
            }
        });



    }

}
