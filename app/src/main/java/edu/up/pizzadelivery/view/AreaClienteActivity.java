package edu.up.pizzadelivery.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.up.pizzadelivery.DAO.PedidoDAO;
import edu.up.pizzadelivery.DAO.UsuarioDAO;
import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.model.Pedido;
import edu.up.pizzadelivery.model.Usuario;

public class AreaClienteActivity extends AppCompatActivity {

    private static final String ARQUIVO_PREF = "LogUsuario";
    Button btnFazerPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnFazerPedido = findViewById(R.id.btnFazerPedido);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
// *****************************************************************************
//******        aqui eu consigo o resultado da data completa    *****************
// ************************************************************************* ***
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String data_completa = dateFormat.format(data_atual);
        Log.i("data_completa", data_completa);

// *****************************************************************************
//****** ***********       cadastro de um pedido    *************************
// ************************************************************************* **
//******************   verificar aonde consigo colocar o pedido ***************
// ************************************************************************
        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, MODE_PRIVATE);
        String shedEmail = (String) settings.getString("Email", "");
        Log.i("emailretorno: ", "" + shedEmail);

        final Usuario usuario = UsuarioDAO.RetornaUsuario(this, shedEmail);
        Pedido pedido = new Pedido();
        pedido.setData(data_completa);
        pedido.setUsuario(usuario);
        // pedido.setUsuario();
Log.i("data pedido",""+pedido.getData());
        final int idPedido = (int) PedidoDAO.CadastrarPedido(this, pedido);


        //pizza sendo cadastrada...
        Log.i("Idpedido: ", "" + idPedido);
        Log.i("IdpedidoData: ", "" + pedido.getData());
        Log.i("Idlong-ID: ", "" + idPedido);




//
// ********************************************************************************


        btnFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fazerPedido = new Intent(AreaClienteActivity.this, EscolherTamanhoActivity.class);

                fazerPedido.putExtra("IDPEDIDO",idPedido);
                startActivity(fazerPedido);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editar:
                Intent intent1 = new Intent(this, PerfilUsuarioActivity.class);
                startActivity(intent1);
                return true;
            case R.id.historico:
               Intent  intent2 = new Intent(this, RelatorioPedidoActivity.class);
               startActivity(intent2);
                return true;
            case R.id.sair:
                SharedPreferences sheredPreferences = getSharedPreferences(ARQUIVO_PREF, 0);
                SharedPreferences.Editor editor = sheredPreferences.edit();

                editor.putString("Email", "");
                editor.putString("Senha", "");
                editor.commit();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
