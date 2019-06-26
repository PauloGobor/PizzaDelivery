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


        TextView idpedido = (TextView)
                view.findViewById(R.id.txtId);
        TextView data = (TextView)
                view.findViewById(R.id.txtDataCompra);
        TextView nomeCliente = (TextView)
                view.findViewById(R.id.txtCliente);
        TextView pizza = (TextView)
                view.findViewById(R.id.txtListPizza);
        TextView valorPago = (TextView)
                view.findViewById(R.id.txtValorPago);



        idpedido.setText(pedido.getId());

        data.setText(pedido.getData());
        nomeCliente.setText(pedido.getUsuario().getNome());

//        final ArrayList<ItemPedido> itemPedidos = ItemPedidoDAO.retornarSaboresPizza(act, idPedidos);
//        List<ItemPedido> itemPedidosS = itemPedidos;
//
//
//
//        for (ItemPedido ped : itemPedidosS) {
//
//            pizza.setText(pizza.getText() + String.valueOf(ped.getPizza().getTamanho().getNome() + ","));
//            valorPago.setText(valorPago.getText() + String.valueOf(ped.getSubTotal() + ","));
//
//        }



        return view;

    }





}
