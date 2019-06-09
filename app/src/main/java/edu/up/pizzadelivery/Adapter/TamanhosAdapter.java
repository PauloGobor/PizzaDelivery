package edu.up.pizzadelivery.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Tamanho;


public class TamanhosAdapter extends BaseAdapter {


    private final List<Tamanho> tamanhos;
    private final Activity act;

    public TamanhosAdapter(List<Tamanho> tamanhos, Activity act) {
        this.tamanhos = tamanhos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return tamanhos.size();
    }

    @Override
    public Object getItem(int position) {
        return tamanhos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = act.getLayoutInflater().inflate(R.layout.lista_custom_tamanhos, parent, false);
        final Tamanho tamanho = tamanhos.get(position);


        TextView nome = (TextView)
                view.findViewById(R.id.txtTamanho);
        RadioButton radio = (RadioButton)
                view.findViewById(R.id.rdoTamanho);
        RadioGroup radioGroup = (RadioGroup)
                view.findViewById(R.id.G1);

        nome.setText(tamanho.getNome());


//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//
//            }
//        });

        return view;

    }

}
