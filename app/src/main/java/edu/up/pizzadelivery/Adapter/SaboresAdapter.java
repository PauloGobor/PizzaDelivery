package edu.up.pizzadelivery.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Sabor;
import edu.up.pizzadelivery.model.Tamanho;


public class SaboresAdapter extends BaseAdapter {

    private final List<Sabor> sabores;
    private final Activity act;
    private Tamanho t;

    public SaboresAdapter(List<Sabor> sabores, Tamanho t, Activity act) {
        this.sabores = sabores;
        this.act = act;
        this.t = t;
    }

    @Override
    public int getCount() {
        return sabores.size();
    }

    @Override
    public Object getItem(int position) {
        return sabores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.list_custom_sabores_descricao, parent, false);
        final Sabor sabor = sabores.get(position);



        TextView nome = (TextView)
                view.findViewById(R.id.txtSaborCustom);
        TextView descricao = (TextView) view.findViewById(R.id.txtDescricaoCustom);

        TextView valor = (TextView) view.findViewById(R.id.txtTotalValor);

        nome.setText(sabor.getNome());
        descricao.setText(sabor.getDescricao());
        valor.setText("R$:"+t.getPreco());

        return view;

    }



}
