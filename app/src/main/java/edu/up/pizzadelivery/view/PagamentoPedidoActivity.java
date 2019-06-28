package edu.up.pizzadelivery.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.up.pizzadelivery.DAO.FormaPagamentoDAO;
import edu.up.pizzadelivery.DAO.TamanhoDAO;
import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Tamanho;

public class PagamentoPedidoActivity extends AppCompatActivity {

    private ListView ListFormasPagameto;
    private TextView PagarTotalPedido;
    private EditText edtTroco;
    private Button btnFinalizarTroco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pedido);

        Bundle bundle = getIntent().getExtras();
        final double subtotal= bundle.getDouble("SUBTOTAL");
        final int idPedido = bundle.getInt("IDPEDIDO");

        ListFormasPagameto = (ListView) findViewById(R.id.ListFormaPagamento);
        PagarTotalPedido = (TextView) findViewById(R.id.PagarTotalPedido);
        edtTroco = findViewById(R.id.edtTroco);
        btnFinalizarTroco = findViewById(R.id.btnFinalizarTroco);

        PagarTotalPedido.setText("R$: "+String.valueOf(subtotal));

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

        ListFormasPagameto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                int posicaoClic =  formaPagamentosArrayList.get(position).getId();
                if(posicaoClic == 3){

                    final int posicaoPag = formaPagamentosArrayList.get(position).getId();
                    final String posicaoNome = formaPagamentosArrayList.get(position).getNome();
                    edtTroco.setEnabled(true);
                    btnFinalizarTroco.setEnabled(true);

                    btnFinalizarTroco.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            double a = Double.valueOf(edtTroco.getText().toString());
                            if (a>subtotal) {

                                Pedido p = new Pedido();
                                FormaPagamento f = new FormaPagamento();
                                f.setId(posicaoPag);
                                f.setNome(posicaoNome);
                                p.setFormaPagamento(f);
                                p.setTotal(subtotal);

                                long updatePagamento = FormaPagamentoDAO.AtualizaFormaPagamento(PagamentoPedidoActivity.this, p, idPedido);

                                if (updatePagamento != -1) {
                                    MenssagemConfCad();
                                } else {
                                    Toast.makeText(PagamentoPedidoActivity.this, "Erro Ao Finalizar Pedido!", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(PagamentoPedidoActivity.this, "Valor menor que o total!", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

                }else {

                    Pedido p = new Pedido();
                    FormaPagamento f = new FormaPagamento();
                    f.setId(formaPagamentosArrayList.get(position).getId());
                    f.setNome(formaPagamentosArrayList.get(position).getNome());
                    p.setFormaPagamento(f);
                    p.setTotal(subtotal);

                    long updatePagamento  =  FormaPagamentoDAO.AtualizaFormaPagamento(PagamentoPedidoActivity.this, p, idPedido);

                    if(updatePagamento != -1){
                        MenssagemConfCad();

                    }else {
                        Toast.makeText(PagamentoPedidoActivity.this, "Erro Ao Finalizar Pedido!", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }
    private void MenssagemConfCad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pedido realizado com sucesso ");
        builder.setMessage("Você será redireiconado para a sua area onde poderá verifcar o historico de pedido!");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent telaLogin = new Intent(PagamentoPedidoActivity.this, AreaClienteActivity.class);
                startActivity(telaLogin);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
