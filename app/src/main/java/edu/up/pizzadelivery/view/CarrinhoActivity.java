package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView txtCarrinhoSubTotal;
    private double subtotalbebida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        txtCarrinhoSubTotal = (TextView) findViewById(R.id.txtCarrinhoSubTotal);
// recebendo da ativy anterior itens escolhidos

        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
        final Sabor sabor = (Sabor) getIntent().getSerializableExtra("SABOR");
        final Bebida bebida = (Bebida) getIntent().getSerializableExtra("BEBIDA");


        txtCarrinhoSubTotal.setText("Valor");

        // listar itends do carrinho....


    }

    public void btnpgamento(View view) {
        Intent pagamento = new Intent(this, PagamentoPedidoActivity.class);
        startActivity(pagamento);

    }

    public void btnBebidas(View view) {
        Intent bebidas = new Intent(this, BebidasActivity.class);
        startActivity(bebidas);


    }
}
