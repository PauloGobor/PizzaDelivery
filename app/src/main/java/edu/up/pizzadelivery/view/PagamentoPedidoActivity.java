package edu.up.pizzadelivery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.up.pizzadelivery.DAO.FormaPagamentoDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Tamanho;

public class PagamentoPedidoActivity extends AppCompatActivity {

    private ListView ListFormasPagameto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pedido);

        ListFormasPagameto = (ListView) findViewById(R.id.ListFormaPagamento);

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
}
