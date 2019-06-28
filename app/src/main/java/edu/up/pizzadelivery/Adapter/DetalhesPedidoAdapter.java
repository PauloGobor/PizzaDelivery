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
import edu.up.pizzadelivery.model.Sabor;

public class DetalhesPedidoAdapter extends BaseAdapter {

    private final List<ItemPedido> items;
    private final Activity act;

    public DetalhesPedidoAdapter(List<ItemPedido> items, Activity act) {
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

        View view = act.getLayoutInflater().inflate(R.layout.lista_custom_detalhes_pedido, parent, false);
        final ItemPedido itemPedido = items.get(position);
        final int idpizza;

        TextView tamanho = (TextView)
                view.findViewById(R.id.txtCartTamanho1);
        TextView borda = (TextView)
                view.findViewById(R.id.txtCartBorda1);
        TextView qtd = (TextView)
                view.findViewById(R.id.txtCartQtd1);
        TextView subtotal = (TextView)
                view.findViewById(R.id.txtCartSubtotal1);
        TextView bebida = (TextView)
                view.findViewById(R.id.txtCartBebida1);
        TextView sabores = (TextView)
                view.findViewById(R.id.txtCartSabores1);

        idpizza = ((itemPedido.getPizza().getId()));


        borda.setText(itemPedido.getPizza().getBorda().getNome());
        tamanho.setText(itemPedido.getPizza().getTamanho().getNome());
        qtd.setText(String.valueOf(itemPedido.getQuantidade()));
        subtotal.setText(String.valueOf(itemPedido.getSubTotal()));
        bebida.setText(String.valueOf(itemPedido.getBebida().getNome()));

        final ArrayList<Sabor> saboresArrayList = ItemPedidoDAO.retornarSaboresPizza(act, idpizza);
        List<Sabor> saboresS = saboresArrayList;

        for (Sabor sab : saboresS) {
            sabores.setText(sabores.getText() + String.valueOf(sab.getNome() + ","));

        }
        return view;

    }
}


