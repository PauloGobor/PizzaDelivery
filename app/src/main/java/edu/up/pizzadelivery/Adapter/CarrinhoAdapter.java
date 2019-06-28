package edu.up.pizzadelivery.Adapter;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.DAO.ItemPedidoDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Borda;
import edu.up.pizzadelivery.model.ItemPedido;
import edu.up.pizzadelivery.model.Sabor;

public class CarrinhoAdapter extends BaseAdapter {

    private final List<ItemPedido> items;
    private final Activity act;
//    private Tamanho t;

    public CarrinhoAdapter(List<ItemPedido> items, Activity act) {
        this.items = items;
        this.act = act;
//        this.t = t;
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

        View view = act.getLayoutInflater().inflate(R.layout.lista_custom_carrinho, parent, false);
        final ItemPedido itemPedido = items.get(position);
        final int idpizza;

        TextView tamanho = (TextView)
                view.findViewById(R.id.txtCartTamanho);
        TextView borda = (TextView)
                view.findViewById(R.id.txtCartBorda);
        TextView qtd = (TextView)
                view.findViewById(R.id.txtCartQtd);
        TextView subtotal = (TextView)
                view.findViewById(R.id.txtCartSubtotal);
        TextView bebida = (TextView)
                view.findViewById(R.id.txtCartBebida);
        TextView sabores = (TextView)
                view.findViewById(R.id.txtCartSabores);

        idpizza = ((itemPedido.getPizza().getId()));


        borda.setText(itemPedido.getPizza().getBorda().getNome());
        tamanho.setText(itemPedido.getPizza().getTamanho().getNome());
        qtd.setText(String.valueOf(itemPedido.getQuantidade()));
        subtotal.setText(String.valueOf(itemPedido.getSubTotal()));
        bebida.setText(String.valueOf(itemPedido.getBebida().getNome()));
//        sabores.setText(String.valueOf(itemPedido.getPizza().getId()));


        final ArrayList<Sabor> saboresArrayList = ItemPedidoDAO.retornarSaboresPizza(act, idpizza);
        List<Sabor> saboresS = saboresArrayList;



//        for (int i = 0; i < saboresArrayList.size(); i++) {
//            saboresS[i] = saboresArrayList.get(i).getNome();
//        }

        for (Sabor sab : saboresS) {
            sabores.setText(sabores.getText() + String.valueOf(sab.getNome() + ","));

        }
        return view;

    }


}