package edu.up.pizzadelivery.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Usuario;

public class BancoDeDado extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "PizzaDelivery.db";
    private static final int VERSAO_BANCO = 1;

    private static final String TIPO_TEXTO = " TEXT";
    private static final String TIPO_INTEIRO = " INTEGER";
    private static final String TIPO_REAL = " REAL";
    private static final String VIRGULA = ", ";

    public BancoDeDado(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);

    }

    private static final String SQL_CRIAR_TABELA_USUARIO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaUsuario.NOME_DA_TABELA + "(" +
                    Contrato.TabelaUsuario.COLUNA_EMAIL + TIPO_INTEIRO + " PRIMARY KEY" + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_CPF + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_TELEFONE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_SENHA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_CONFSENHA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_ENDERECOID + TIPO_INTEIRO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaUsuario.COLUNA_ENDERECOID + ")" +
                    " REFERENCES " + Contrato.TabelaEndereco.NOME_DA_TABELA + "(" + Contrato.TabelaEndereco.COLUNA_ID + ")" + ")";  //FK


    private static final String SQL_CRIAR_TABELA_ENDERECO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaEndereco.NOME_DA_TABELA + "(" +
                    Contrato.TabelaEndereco.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_CEP + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_BAIRRO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_RUA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_NUMERO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_CIDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_COMPLEMENTO + TIPO_TEXTO + ")";

    private static final String SQL_CRIAR_TABELA_BEBIDA =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaBebida.NOME_DA_TABELA + "(" +
                    Contrato.TabelaBebida.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaBebida.COLUNA_NOME + TIPO_TEXTO + ")";

    private static final String SQL_CRIAR_TABELA_BORDA =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaBorda.NOME_DA_TABELA + "(" +
                    Contrato.TabelaBorda.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaBorda.COLUNA_NOME + TIPO_TEXTO + ")";


    private static final String SQL_CRIAR_TABELA_INGREDIENTE =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaIngrediente.NOME_DA_TABELA + "(" +
                    Contrato.TabelaIngrediente.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaIngrediente.COLUNA_NOME + TIPO_TEXTO + ")";

    private static final String SQL_CRIAR_TABELA_SABOR =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaSabor.NOME_DA_TABELA + "(" +
                    Contrato.TabelaSabor.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY" + VIRGULA +
                    Contrato.TabelaSabor.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaSabor.COLUNA_INGREDIENTES + TIPO_INTEIRO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaSabor.COLUNA_INGREDIENTES + ")" +
                    " REFERENCES " + Contrato.TabelaIngrediente.NOME_DA_TABELA +
                    "(" + Contrato.TabelaSabor.COLUNA_ID + ")" + ")";  //FK



    private static final String SQL_CRIAR_TABELA_TAMANHO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaTamanho.NOME_DA_TABELA + "(" +
                    Contrato.TabelaTamanho.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaTamanho.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaTamanho.COLUNA_QTDSABOR + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaTamanho.COLUNA_PRECO + TIPO_REAL + ")";

    private static final String SQL_CRIAR_TABELA_PIZZA =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaPizza.NOME_DA_TABELA + "(" +
                    Contrato.TabelaPizza.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaPizza.COLUNA_SABOR + TIPO_INTEIRO + VIRGULA + //FK

                    Contrato.TabelaPizza.COLUNA_TAMANHO + TIPO_INTEIRO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPizza.COLUNA_SABOR + ")" +
                    " REFERENCES " + Contrato.TabelaSabor.NOME_DA_TABELA +
                    "(" + Contrato.TabelaSabor.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPizza.COLUNA_TAMANHO + ")" +
                    " REFERENCES " + Contrato.TabelaTamanho.NOME_DA_TABELA +
                    "(" + Contrato.TabelaTamanho.COLUNA_ID + ")" + ")";


    private static final String SQL_CRIAR_TABELA_FORMAPAGAMENTO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaFormaPagamento.NOME_DA_TABELA + "(" +
                    Contrato.TabelaFormaPagamento.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaFormaPagamento.COLUNA_NOME + TIPO_TEXTO + ")";


    private static final String SQL_CRIAR_TABELA_ITEMPEDIDO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaItemPedido.NOME_DA_TABELA + "(" +
                    Contrato.TabelaItemPedido.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaItemPedido.COLUNA_PIZZA + TIPO_INTEIRO + VIRGULA + //FK
                    Contrato.TabelaItemPedido.COLUNA_BEBIDA + TIPO_INTEIRO + VIRGULA +//FK
                    Contrato.TabelaItemPedido.COLUNA_BORDA + TIPO_INTEIRO + VIRGULA +//FK
                    Contrato.TabelaItemPedido.COLUNA_QUANTIDADE + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaItemPedido.COLUNA_SUBTOTAL + TIPO_REAL + VIRGULA +
                    Contrato.TabelaItemPedido.COLUNA_PRECOPEDIDO + TIPO_REAL + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaItemPedido.COLUNA_PIZZA + ")" +
                    " REFERENCES " + Contrato.TabelaPizza.NOME_DA_TABELA +
                    "(" + Contrato.TabelaPizza.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaItemPedido.COLUNA_BEBIDA + ")" +
                    " REFERENCES " + Contrato.TabelaBebida.NOME_DA_TABELA +
                    "(" + Contrato.TabelaBebida.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaItemPedido.COLUNA_BORDA + ")" +
                    " REFERENCES " + Contrato.TabelaBorda.NOME_DA_TABELA +
                    "(" + Contrato.TabelaBorda.COLUNA_ID + ")" + ")";


    private static final String SQL_CRIAR_TABELA_PEDIDO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaPedido.NOME_DA_TABELA + "(" +
                    Contrato.TabelaPedido.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaPedido.COLUNA_ITEM_PEDIDO + TIPO_INTEIRO + VIRGULA + //FK
                    Contrato.TabelaPedido.COLUNA_FORMA_PAGAMENTO + TIPO_INTEIRO + VIRGULA +//FK
                    Contrato.TabelaPedido.COLUNA_ENDERECO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaPedido.COLUNA_DATA + TIPO_TEXTO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_ITEM_PEDIDO + ")" +
                    " REFERENCES " + Contrato.TabelaItemPedido.NOME_DA_TABELA +
                    "(" + Contrato.TabelaItemPedido.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_FORMA_PAGAMENTO + ")" +
                    " REFERENCES " + Contrato.TabelaFormaPagamento.NOME_DA_TABELA +
                    "(" + Contrato.TabelaFormaPagamento.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_ENDERECO + ")" +
                    " REFERENCES " + Contrato.TabelaEndereco.NOME_DA_TABELA +
                    "(" + Contrato.TabelaEndereco.COLUNA_ID + ")" + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_TABELA_BEBIDA);
        db.execSQL(SQL_CRIAR_TABELA_USUARIO);
        db.execSQL(SQL_CRIAR_TABELA_ENDERECO);
        db.execSQL(SQL_CRIAR_TABELA_BORDA);
        db.execSQL(SQL_CRIAR_TABELA_INGREDIENTE);
        db.execSQL(SQL_CRIAR_TABELA_FORMAPAGAMENTO);
        db.execSQL(SQL_CRIAR_TABELA_TAMANHO);
        db.execSQL(SQL_CRIAR_TABELA_SABOR);
        db.execSQL(SQL_CRIAR_TABELA_PIZZA);
        db.execSQL(SQL_CRIAR_TABELA_ITEMPEDIDO);
        db.execSQL(SQL_CRIAR_TABELA_PEDIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long CadastrarUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Contrato.TabelaUsuario.COLUNA_NOME, usuario.getNome());
        values.put(Contrato.TabelaUsuario.COLUNA_EMAIL, usuario.getEmail());
        values.put(Contrato.TabelaUsuario.COLUNA_CPF, usuario.getCpf());
        values.put(Contrato.TabelaUsuario.COLUNA_TELEFONE, usuario.getTelefone());
        values.put(Contrato.TabelaUsuario.COLUNA_SENHA, usuario.getSenha());
        values.put(Contrato.TabelaUsuario.COLUNA_CONFSENHA, usuario.getConfSenha());
// preenche a tabela endereco
        //provavelmente mude  *****
        values.put(Contrato.TabelaEndereco.COLUNA_CEP, usuario.getEndereco().getCep());
        values.put(Contrato.TabelaEndereco.COLUNA_BAIRRO, usuario.getEndereco().getBairro());
        values.put(Contrato.TabelaEndereco.COLUNA_RUA, usuario.getEndereco().getRua());
        values.put(Contrato.TabelaEndereco.COLUNA_NUMERO, usuario.getEndereco().getNumero());
        values.put(Contrato.TabelaEndereco.COLUNA_COMPLEMENTO, usuario.getEndereco().getComplemento());
        values.put(Contrato.TabelaEndereco.COLUNA_CIDADE, usuario.getEndereco().getCidade());
        //

        //values.put(Contrato.TabelaUsuario.COLUNA_ENDERECOID,usuario.getEndereco().getIdEndereco() );

        return db.insert(Contrato.TabelaUsuario.NOME_DA_TABELA, null, values);

    }



    public boolean ValidadaLogin(Login login){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                Contrato.TabelaUsuario.NOME_DA_TABELA + " WHERE "   +
                Contrato.TabelaUsuario.COLUNA_EMAIL   + " = ? AND " +
                Contrato.TabelaUsuario.COLUNA_SENHA   + " = ? ",
                new String[]{login.getEmail(), login.getSenha()});

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean JaCadastrado(String email, String cpf){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                        Contrato.TabelaUsuario.NOME_DA_TABELA + " WHERE "   +
                        Contrato.TabelaUsuario.COLUNA_EMAIL   + " = ? AND " +
                        Contrato.TabelaUsuario.COLUNA_CPF     + " = ? ",
                new String[]{email, cpf});
        ;
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        else{
            return true;
        }
    }

}
