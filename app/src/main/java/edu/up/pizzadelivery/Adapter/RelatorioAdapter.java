package edu.up.pizzadelivery.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Sabor;

public class RelatorioAdapter extends BaseAdapter {

    private final List<Pedido> items;
    private final Activity act;

    public RelatorioAdapter(List<Pedido> items, Activity act) {
        this.items = items;
        this.act = act;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.list_custom_relatorio, parent, false);
        final Pedido pedido = items.get(position);

        TextView id = (TextView)
                view.findViewById(R.id.txtIdPedidoRelatorio);

        TextView data = (TextView)
                view.findViewById(R.id.txtDataCompra);
        TextView nomeCliente = (TextView)
                view.findViewById(R.id.txtCliente);
        TextView valorPago = (TextView)
                view.findViewById(R.id.txtValorPago);
        TextView formaPagamento = (TextView)
                view.findViewById(R.id.txtFormaPagamentoPedido);



       // idpedido.setText(pedido.getId());
        id.setText(String.valueOf(pedido.getId()));
        data.setText(pedido.getData());
        nomeCliente.setText(pedido.getUsuario().getNome());
        valorPago.setText(String.valueOf(pedido.getTotal()));
        formaPagamento.setText(pedido.getFormaPagamento().getNome());

        return view;

    }





}
