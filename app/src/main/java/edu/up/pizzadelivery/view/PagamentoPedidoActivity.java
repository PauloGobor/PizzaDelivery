package edu.up.pizzadelivery.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.up.pizzadelivery.DAO.FormaPagamentoDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Tamanho;

public class PagamentoPedidoActivity extends AppCompatActivity {

    private ListView ListFormasPagameto;
    private TextView PagarTotalPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pedido);

        Bundle bundle = getIntent().getExtras();
        final double subtotal= bundle.getDouble("SUBTOTAL");

        ListFormasPagameto = (ListView) findViewById(R.id.ListFormaPagamento);
        PagarTotalPedido = (TextView) findViewById(R.id.PagarTotalPedido);

        PagarTotalPedido.setText(String.valueOf(subtotal));

        final ArrayList<FormaPagamento> formaPagamentosArrayList = FormaPagamentoDAO.retornarFormasPagamento(this);
        String[] formaspagamento = new String[formaPagamentosArrayList.size()];



        for (int i = 0; i < formaPagamentosArrayList.size(); i++) {
            formaspagamento[i] = formaPagamentosArrayList.get(i).getNome();

        }

        //O adapter é componente que prepara os dados para o ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, formaspagamento);
        //setAdapter é método que vai popular os dados dentro do ListView
        ListFormasPagameto.setAdapter(adapter);
        //Criar o clique de cada do ListView

    }

    public void btnFinalizarPedido(View view) {
        Toast.makeText(PagamentoPedidoActivity.this, "Pedido Realizado com sucesso", Toast.LENGTH_SHORT).show();

        Intent relatorio = new Intent(this, AreaClienteActivity.class);
        startActivity(relatorio);
    }
}
