package edu.up.pizzadelivery.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.up.pizzadelivery.R;

import edu.up.pizzadelivery.model.Borda;

public class BordaAdapter extends BaseAdapter {

    private final List<Borda> bordas;
    private final Activity act;
//    private Tamanho t;

    public BordaAdapter(List<Borda> bordas, Activity act) {
        this.bordas = bordas;
        this.act = act;
//        this.t = t;
    }

    @Override
    public int getCount() {
        return bordas.size();
    }

    @Override
    public Object getItem(int position) {
        return bordas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.list_custom_borda ,parent, false);
        final Borda borda = bordas.get(position);

        TextView nome = (TextView)
                view.findViewById(R.id.txtBordaCustom);
        TextView valor = (TextView) view.findViewById(R.id.txtValorBorda);

        nome.setText(borda.getNome());
        valor.setText("R$:"+borda.getPreco());

        return view;

    }


}
