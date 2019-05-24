package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import edu.up.pizzadelivery.R;

public class PagamentoPedidoActivity extends AppCompatActivity {

    private ListView ListFormasPagameto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pedido);

        ListFormasPagameto = (ListView) findViewById(R.id.ListFormaPagamento);

        /// metodo para listar a forma de pagamento ja esta feito



    }
}
