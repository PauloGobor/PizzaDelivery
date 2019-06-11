package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.up.pizzadelivery.R;

public class RelatorioPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_pedido);

    }

    public void btnNovoPedido(View view) {
        Intent novoPedido = new Intent(this, MainActivity.class);
        startActivity(novoPedido);
    }
}
