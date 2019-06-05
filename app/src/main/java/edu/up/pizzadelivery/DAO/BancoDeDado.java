package edu.up.pizzadelivery.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import edu.up.pizzadelivery.model.Bebida;
import edu.up.pizzadelivery.model.FormaPagamento;
import edu.up.pizzadelivery.model.Ingrediente;
import edu.up.pizzadelivery.model.Login;
import edu.up.pizzadelivery.model.Tamanho;
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

    //   ############################################################
    //   ####### STRING DE CRIACAO DAS TABELAS #####################
    //   ###########################################################
    private static final String SQL_CRIAR_TABELA_USUARIO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaUsuario.NOME_DA_TABELA + "(" +
                    Contrato.TabelaUsuario.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_EMAIL + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_CPF + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_TELEFONE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.COLUNA_SENHA + TIPO_TEXTO + ")";  //FK


    private static final String SQL_CRIAR_TABELA_ENDERECO =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaEndereco.NOME_DA_TABELA + "(" +
                    Contrato.TabelaEndereco.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_CEP + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_BAIRRO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_RUA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_NUMERO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_CIDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_COMPLEMENTO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaEndereco.COLUNA_USUARIOID + TIPO_INTEIRO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaEndereco.COLUNA_USUARIOID + ")" +
                    " REFERENCES " + Contrato.TabelaUsuario.NOME_DA_TABELA +
                    "(" + Contrato.TabelaUsuario.COLUNA_ID + ")" + ")";

    private static final String SQL_CRIAR_TABELA_BEBIDA =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaBebida.NOME_DA_TABELA + "(" +
                    Contrato.TabelaBebida.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaBebida.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaBebida.COLUNA_PRECO + ")";

    private static final String SQL_CRIAR_TABELA_BORDA =
            "CREATE TABLE IF NOT EXISTS " +
                    Contrato.TabelaBorda.NOME_DA_TABELA + "(" +
                    Contrato.TabelaBorda.COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaBorda.COLUNA_NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaBorda.COLUNA_PRECO + TIPO_REAL + ")";


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
                    Contrato.TabelaPedido.COLUNA_USUARIO + TIPO_INTEIRO + VIRGULA + //FK
                    Contrato.TabelaPedido.COLUNA_ITEM_PEDIDO + TIPO_INTEIRO + VIRGULA + //FK
                    Contrato.TabelaPedido.COLUNA_FORMA_PAGAMENTO + TIPO_INTEIRO + VIRGULA +//FK
                    Contrato.TabelaPedido.COLUNA_ENDERECO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaPedido.COLUNA_DATA + TIPO_TEXTO + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_USUARIO + ")" +
                    " REFERENCES " + Contrato.TabelaUsuario.NOME_DA_TABELA +
                    "(" + Contrato.TabelaUsuario.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_ITEM_PEDIDO + ")" +
                    " REFERENCES " + Contrato.TabelaItemPedido.NOME_DA_TABELA +
                    "(" + Contrato.TabelaItemPedido.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_FORMA_PAGAMENTO + ")" +
                    " REFERENCES " + Contrato.TabelaFormaPagamento.NOME_DA_TABELA +
                    "(" + Contrato.TabelaFormaPagamento.COLUNA_ID + ")" + VIRGULA +
                    " FOREIGN KEY (" + Contrato.TabelaPedido.COLUNA_ENDERECO + ")" +
                    " REFERENCES " + Contrato.TabelaEndereco.NOME_DA_TABELA +
                    "(" + Contrato.TabelaEndereco.COLUNA_ID + ")" + ")";

//    insere tamanhos

    private static final String SQL_INSERIR_BROTO = "INSERT INTO " +
            Contrato.TabelaTamanho.NOME_DA_TABELA +
            "(Nome, QtdSabor, Preco) VALUES ('Broto', 1, 15)";

    private static final String SQL_INSERIR_MEDIA = "INSERT INTO " +
            Contrato.TabelaTamanho.NOME_DA_TABELA +
            "(Nome, QtdSabor, Preco) VALUES ('Média', 1, 22)";


    private static final String SQL_INSERIR_GRANDE = "INSERT INTO " +
            Contrato.TabelaTamanho.NOME_DA_TABELA +
            "(Nome, QtdSabor, Preco) VALUES ('Grande', 1, 30)";

    private static final String SQL_INSERIR_BIG = "INSERT INTO " +
            Contrato.TabelaTamanho.NOME_DA_TABELA +
            "(Nome, QtdSabor, Preco) VALUES ('Big', 4, 40)";

    /// insere formas de pagamentos

    private static final String SQL_INSERIR_FP_DIN = "INSERT INTO " +
            Contrato.TabelaFormaPagamento.NOME_DA_TABELA +
            "(Nome) VALUES ('Dinheiro')";

    private static final String SQL_INSERIR_FP_CDT = "INSERT INTO " +
            Contrato.TabelaFormaPagamento.NOME_DA_TABELA +
            "(Nome) VALUES ('Credito')";

    private static final String SQL_INSERIR_FP_DBT = "INSERT INTO " +
            Contrato.TabelaFormaPagamento.NOME_DA_TABELA +
            "(Nome) VALUES ('Débito')";

    //insere bebidas

    private static final String SQL_INSERIR_BEBIDA_CC = "INSERT INTO " +
            Contrato.TabelaBebida.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Coca-Cola 2L', 9)";

    private static final String SQL_INSERIR_BEBIDA_FL = "INSERT INTO " +
            Contrato.TabelaBebida.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Fanta Laranja 2L', 7)";

    private static final String SQL_INSERIR_BEBIDA_GA = "INSERT INTO " +
            Contrato.TabelaBebida.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Guaraná 2L', 7)";


    // insere bordas

    private static final String SQL_INSERIR_BORDA_CH = "INSERT INTO " +
            Contrato.TabelaBorda.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Cheddar', 4)";


    private static final String SQL_INSERIR_BORDA_CT = "INSERT INTO " +
            Contrato.TabelaBorda.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Catupiry', 4)";

    private static final String SQL_INSERIR_BORDA_CP = "INSERT INTO " +
            Contrato.TabelaBorda.NOME_DA_TABELA +
            "(Nome, Preco) VALUES ('Chocolate Preto', 5)";

//    //insere ingredientes
//    private static final String SQL_INSERIR_INGREDIENTE_1 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Provolone')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_2 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Mussarella')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_3 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Calabresa')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_4 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Manjericao')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_5 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Manjericao')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_6 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Presunto')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_7 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Azeitona')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_8 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Cebola')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_9 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Tomate')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_10 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Catupiry')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_11 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Gorgonzola')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_12 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Cheddar')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_13 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Chocolate')";
//
//    private static final String SQL_INSERIR_INGREDIENTE_14 = "INSERT INTO " +
//            Contrato.TabelaIngrediente.NOME_DA_TABELA +
//            "(Nome) VALUES ('Chocolate Branco')";
//
//
//
//
//    // insere sabores
//
//    private static final String SQL_INSERIR_SABOR_FC = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome, Fk_IngredienteId) VALUES ('Frango c/ Catupiry', 1)";
//
//    private static final String SQL_INSERIR_SABOR_CA = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Calabresa')";
//
//    private static final String SQL_INSERIR_SABOR_PI = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Pizzaiolo')";
//
//    private static final String SQL_INSERIR_SABOR_RO = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Romana')";
//
//    private static final String SQL_INSERIR_SABOR_MA = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Marguerita')";
//
//    private static final String SQL_INSERIR_SABOR_TO = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Toscana')";
//
//    private static final String SQL_INSERIR_SABOR_PO = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('Portuguesa')";
//
//    private static final String SQL_INSERIR_SABOR_4Q = "INSERT INTO " +
//            Contrato.TabelaBorda.NOME_DA_TABELA +
//            "(Nome) VALUES ('4 Queijos')";
//
//    //


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
        //insere dados ao criar banco
        //Log.i("Criar banco", SQL_INSERIR_BROTO);
        //TAMANHO
        db.execSQL(SQL_INSERIR_BROTO);
        db.execSQL(SQL_INSERIR_MEDIA);
        db.execSQL(SQL_INSERIR_GRANDE);
        db.execSQL(SQL_INSERIR_BIG);
        //FORMA PAGAMENTO
        db.execSQL(SQL_INSERIR_FP_CDT);
        db.execSQL(SQL_INSERIR_FP_DBT);
        db.execSQL(SQL_INSERIR_FP_DIN);
        //BEBIDA
        db.execSQL(SQL_INSERIR_BEBIDA_CC);
        db.execSQL(SQL_INSERIR_BEBIDA_FL);
        db.execSQL(SQL_INSERIR_BEBIDA_GA);
        //BORDA
        db.execSQL(SQL_INSERIR_BORDA_CH);
        db.execSQL(SQL_INSERIR_BORDA_CT);
        db.execSQL(SQL_INSERIR_BORDA_CP);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long CadastrarUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        // PRIMEIRO FAZER A INSERÇÃO NA TABELA DE USUARIO PRA DEPOIS
        //PEGAR O USUARIO ID E COLOCAR DENTRO DA TABELA ENDERECO .....
        values.put(Contrato.TabelaUsuario.COLUNA_NOME, usuario.getNome());
        values.put(Contrato.TabelaUsuario.COLUNA_EMAIL, usuario.getEmail());
        values.put(Contrato.TabelaUsuario.COLUNA_CPF, usuario.getCpf());
        values.put(Contrato.TabelaUsuario.COLUNA_TELEFONE, usuario.getTelefone());
        values.put(Contrato.TabelaUsuario.COLUNA_SENHA, usuario.getSenha());
        //inseri os dados na tabela usuario
        db.insert(Contrato.TabelaUsuario.NOME_DA_TABELA, null, values);
// preenche a tabela endereco
        // *****
        values.put(Contrato.TabelaEndereco.COLUNA_CEP, usuario.getEndereco().getCep());
        values.put(Contrato.TabelaEndereco.COLUNA_BAIRRO, usuario.getEndereco().getBairro());
        values.put(Contrato.TabelaEndereco.COLUNA_RUA, usuario.getEndereco().getRua());
        values.put(Contrato.TabelaEndereco.COLUNA_NUMERO, usuario.getEndereco().getNumero());
        values.put(Contrato.TabelaEndereco.COLUNA_COMPLEMENTO, usuario.getEndereco().getComplemento());
        values.put(Contrato.TabelaEndereco.COLUNA_CIDADE, usuario.getEndereco().getCidade());
        values.put(Contrato.TabelaEndereco.COLUNA_USUARIOID, usuario.getId());
        db.insert(Contrato.TabelaEndereco.NOME_DA_TABELA, null, values);

        return db.insert(Contrato.TabelaUsuario.NOME_DA_TABELA, null, values);
    }

    public boolean ValidadaLogin(Login login) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                        Contrato.TabelaUsuario.NOME_DA_TABELA + " WHERE " +
                        Contrato.TabelaUsuario.COLUNA_EMAIL + " = ? AND " +
                        Contrato.TabelaUsuario.COLUNA_SENHA + " = ? ",
                new String[]{login.getEmail(), login.getSenha()});

        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        } else {
            return true;
        }
    }

    public boolean JaCadastrado(String email, String cpf) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                        Contrato.TabelaUsuario.NOME_DA_TABELA + " WHERE " +
                        Contrato.TabelaUsuario.COLUNA_EMAIL + " = ? AND " +
                        Contrato.TabelaUsuario.COLUNA_CPF + " = ? ",
                new String[]{email, cpf});
        ;
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        } else {
            return true;
        }
    }

    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR FORMAS DE PAGAMENTO EM FORMA DE LISTA #######   ///
    //  ########################################################################   ///
    public ArrayList<FormaPagamento> RetornarFormasPagamento() {
        ArrayList<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>();
        SQLiteDatabase db = getReadableDatabase();

        String[] colunas = {
                Contrato.TabelaFormaPagamento.COLUNA_ID,
                Contrato.TabelaFormaPagamento.COLUNA_NOME
        };

        Cursor cursor = db.query(Contrato.TabelaFormaPagamento.NOME_DA_TABELA, colunas,
                null, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                FormaPagamento fp = new FormaPagamento();
                fp.setNome(cursor.getString(1));
                formasPagamento.add(fp);
            } while (cursor.moveToNext());
        }
        return formasPagamento;
    }

    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR TAMANHOS DE PIZZA EM FORMA DE LISTA #######   ///
    //  ########################################################################   ///
    public ArrayList<Tamanho> RetornarTamanhos() {
        ArrayList<Tamanho> tamanhos = new ArrayList<Tamanho>();
        SQLiteDatabase db = getReadableDatabase();

        String[] colunas = {
                Contrato.TabelaTamanho.COLUNA_ID,
                Contrato.TabelaTamanho.COLUNA_NOME,
                Contrato.TabelaTamanho.COLUNA_QTDSABOR,
                Contrato.TabelaTamanho.COLUNA_PRECO
        };

        Cursor cursor = db.query(Contrato.TabelaTamanho.NOME_DA_TABELA, colunas,
                null, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                Tamanho t = new Tamanho();
                t.setId(cursor.getInt(0));
                t.setNome(cursor.getString(1));
                t.setQtdSabores(cursor.getInt(2));
                t.setPreco(cursor.getDouble(3));
                tamanhos.add(t);
            } while (cursor.moveToNext());
        }
        return tamanhos;
    }

    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR BEBIDAS EM FORMA DE LISTA #######   ///
    //  ########################################################################   ///
    public ArrayList<Bebida> RetornarBebidas() {
        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
        SQLiteDatabase db = getReadableDatabase();

        String[] colunas = {
                Contrato.TabelaTamanho.COLUNA_ID,
                Contrato.TabelaTamanho.COLUNA_NOME,

        };

        Cursor cursor = db.query(Contrato.TabelaBebida.NOME_DA_TABELA, colunas,
                null, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                Bebida b = new Bebida();
                b.setId(cursor.getInt(0));
                b.setNome(cursor.getString(1));

                bebidas.add(b);
            } while (cursor.moveToNext());
        }
        return bebidas;
    }


    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR INGREDIENTES DE PIZZA EM FORMA DE LISTA #######   ///
    //  ########################################################################   ///
    public ArrayList<Ingrediente> RetornarIngredientes() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        SQLiteDatabase db = getReadableDatabase();

        String[] colunas = {
                Contrato.TabelaIngrediente.COLUNA_ID,
                Contrato.TabelaIngrediente.COLUNA_NOME
        };

        Cursor cursor = db.query(Contrato.TabelaIngrediente.NOME_DA_TABELA, colunas,
                null, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                Ingrediente i = new Ingrediente();
                i.setNome(cursor.getString(1));
                ingredientes.add(i);
            } while (cursor.moveToNext());
        }
        return ingredientes;
    }

    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR ALTERAR DADOS DO USUARIO #######   ///
    //  ########################################################################   ///

    public long alterarUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        // DECLARAR DADOS QUE SERAO ALTERADOS


        String condicao = Contrato.TabelaUsuario.COLUNA_ID + " = ?";
        String[] argumentos = {String.valueOf(usuario.getId())

        };

        return db.update(Contrato.TabelaUsuario.NOME_DA_TABELA, values, condicao, argumentos);

    }
    //  ########################################################################   ///
    //  ##### METODO PARA RETORNAR ENCERRAR CONTA DO USUARIO #######   ///
    //  ########################################################################   ///

    public long removerUsuario(Usuario c) {
        SQLiteDatabase db = getWritableDatabase();

        String condicao = Contrato.TabelaUsuario.COLUNA_ID + " = ?";
        String[] argumentos = {
                String.valueOf(c.getId())
        };
        return db.delete(Contrato.TabelaUsuario.NOME_DA_TABELA,
                condicao, argumentos);
    }
}

