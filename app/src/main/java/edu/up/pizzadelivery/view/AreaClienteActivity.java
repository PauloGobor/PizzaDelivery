package edu.up.pizzadelivery.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import edu.up.pizzadelivery.R;

public class AreaClienteActivity extends AppCompatActivity {

    private static  final  String ARQUIVO_PREF = "LogUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.editar:
               Intent  intent1 = new Intent(this, PerfilUsuarioActivity.class);
               startActivity(intent1);
               return true;
           case R.id.historico:
//               Intent  intent2 = new Intent(this, Historico.class);
//               startActivity(intent1);
               return true;
           case R.id.sair:
               SharedPreferences sheredPreferences = getSharedPreferences(ARQUIVO_PREF,0);
               SharedPreferences.Editor editor =  sheredPreferences.edit();

               editor.putString("Email","");
               editor.putString("Senha","");
               editor.commit();
               finish();
               return true;
               default:
                   return super.onOptionsItemSelected(item);
       }
    }
}
