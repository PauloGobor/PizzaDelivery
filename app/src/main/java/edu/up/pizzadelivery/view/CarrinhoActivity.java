package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView txtCarrinhoSubTotal;
    private double subtotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        final Tamanho tamanho = (Tamanho) getIntent().getSerializableExtra("TAMANHO");
       // final Sabor sabor = (Sabor) getIntent().getSerializableExtra("SABOR");
        final Borda borda = (Borda) getIntent().getSerializableExtra("BORDA");
        final Bebida bebida = (Bebida) getIntent().getSerializableExtra("BEBIDA");

        txtCarrinhoSubTotal = (TextView) findViewById(R.id.txtCarrinhoSubTotal);
//      recebendo da activy anterior itens escolhidos



       // subtotal = subtotal+tamanho.getPreco()+borda.getPreco();

      //  txtCarrinhoSubTotal.setText(""+bebida.getQuantidade());

        // listar itens do carrinho....





    }

    public void btnpgamento(View view) {
        Intent pagamento = new Intent(this, PagamentoPedidoActivity.class);
        startActivity(pagamento);

    }

    public void btnCardapio(View view) {
        Intent intent = new Intent(this, EscolherTamanhoActivity.class);
        startActivity(intent);




    }

    public void btnBebida(View view) {
        Intent intent = new Intent(this, BebidasActivity.class);
        startActivity(intent);
    }
}
