package edu.up.pizzadelivery.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Bebida;

public class BebidaAdapter extends BaseAdapter {

    private final List<Bebida> bebidas;
    private final Activity act;
//    private Tamanho t;

    public BebidaAdapter(List<Bebida> bebidas, Activity act) {
        this.bebidas = bebidas;
        this.act = act;
//        this.t = t;
    }

    @Override
    public int getCount() {
        return bebidas.size();
    }

    @Override
    public Object getItem(int position) {
        return bebidas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.lista_custom_bebida_price, parent, false);
        final Bebida bebida = bebidas.get(position);



        TextView nome = (TextView)
                view.findViewById(R.id.txtBebidaCustom);
        TextView valor = (TextView) view.findViewById(R.id.txtValorBebida);

        nome.setText(bebida.getNome());
        valor.setText("R$:"+bebida.getPreco());

        return view;

    }

}
