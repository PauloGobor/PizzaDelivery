package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView txtCarrinhoSubTotal;
    private double subtotal;
    private Button btnCardapio, btnPagamento;


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

        btnCardapio = (Button) findViewById(R.id.btnCardapio);
        btnPagamento = (Button) findViewById(R.id.btnPagamento);
        txtCarrinhoSubTotal = (TextView) findViewById(R.id.txtCarrinhoSubTotal);
//      recebendo da activy anterior itens escolhidos


        // subtotal = subtotal+tamanho.getPreco()+borda.getPreco();
        Pedido p = new Pedido();
        p.setId(idPedido);
        final double subtotal = ItemPedidoDAO.RetornarSomaCarrinho(this,p);
        txtCarrinhoSubTotal.setText(String.valueOf(subtotal));

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
                intent.putExtra("SUBTOTAL", subtotal);
                startActivity(intent);
            }
        });



    }



    public void btnBebida(View view) {
        Intent intent = new Intent(this, BebidasActivity.class);
        startActivity(intent);
    }
}
