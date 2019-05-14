package edu.up.pizzadelivery.view;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.up.pizzadelivery.R;

public class CadastroPessoasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoas);

        // comandos a seguir estao temporarios
        // ate que possa ser separado em camadas...

        try {

            SQLiteDatabase bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //PEDIDOS
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pedidos" +
                    "(idPedido  PRIMARY KEY AUTOINCREMENT," +
                    "usuario ," +       //FK
                    "ITENS," +          //FK
                    "formapagamento," + //FK
                    "endereco, " +      //FK
                    "data DATE)");

            //ITEM PEDIDO
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS itenspedido" +
                    "(itemId  PRIMARY KEY AUTOINCREMENT," +
                    "pizza VARCHAR NOT NULL," + // FK
                    "bebida varchar," + // FK
                    "quantidade INTEGER(2)," +
                    "subTotal DOUBLE," +
                    "precoPedido DOUBLE)");


            //FORMA DE PAGAMENTO
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS formaDePagamentos" +
                    "(idFormaPagamento  PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR NOT NULL)");

            //PIZZA
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pizzas" +
                    "(idPizza  PRIMARY KEY AUTOINCREMENT," +
                    "sabor," +          // FK
                    "tamnahho," +       // FK
                    "borda," +          //FK
                    "preco DOUBLE)");

            //INGREDIENTES
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS ingredientes" +
                    "(idIngrediente  PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR NOT NULL)");

            //TAMANHOS
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS tamanhos" +
                    "(idTamanho  PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR NOT NULL," +
                    "qtdPedacos integer(2) NOT NULL)");

            bancodedados.execSQL("INSERT INTO tamanhos(nome,qtdPedacos) VALUES('Broto',4)");

            //BEBIDAS
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS bebidas " +
                    "(idBebida  PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR NOT NULL," +
                    "preco DOUBLE NOT NULL)");

            //BORDAS
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS bordas " +
                    "(idBorda  PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR NOT NULL)");

            bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Catupiry')");
            bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Cheddar')");
            bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Chocolate')");

            //ENDERECO
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS enderecos" +
                    "(idEndereco INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "cep VARCHAR NOT NULL," +
                    "rua VARCHAR NOT NULL," +
                    "bairro VARCHAR NOT NULL," +
                    "cidade VARCHAR," +
                    "numero INTEGER(5)," +
                    "complemento VARCHAR)");


            // USUARIOS
            bancodedados.execSQL("CREATE TABLE  IF NOT EXISTS usuarios" +
                    "(email VARCHAR PRIMARY KEY NOT NULL," +
                    "nome VARCHAR NOT NULL," +
                    "cpf VARCHAR," +
                    "telefone VARCHAR," +
                    "senha VARCHAR NOT NULL," +
                    "confSenha VARCHAR NOT NULL)");// falta FK Endereço


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
