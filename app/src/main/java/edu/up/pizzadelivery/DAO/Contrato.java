package edu.up.pizzadelivery.DAO;

//https://www.sqlite.org/draft/datatype3.html
/// https://developer.android.com/training/data-storage/sqlite
// db browser sqlite

import android.provider.BaseColumns;

public final class Contrato {

    private Contrato(){    }

    public static abstract class TabelaUsuario implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Usuarios";
        public static final String COLUNA_EMAIL= "Email";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_CPF = "Cpf";
        public static final String COLUNA_TELEFONE = "Telefone";
        public static final String COLUNA_SENHA = "Senha";
        public static final String COLUNA_CONFSENHA = "ConfSenha";
        //public static final String COLUNA_TELEFONE = "Telefone"; FK Endereco

    }

    public static abstract class TabelaEndereco implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Enderecos";
        public static final String COLUNA_ID= "EnderecoId";
        public static final String COLUNA_CEP = "Cep";
        public static final String COLUNA_RUA = "Rua";
        public static final String COLUNA_BAIRRO = "Bairro";
        public static final String COLUNA_CIDADE = "Cidade";
        public static final String COLUNA_NUMERO = "Numero";
        public static final String COLUNA_COMPLEMENTO = "Complemento";
        //public static final String COLUNA_TELEFONE = "Telefone"; FK Endereco
    }

    public static abstract class TabelaBebida implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Bebidas";
        public static final String COLUNA_ID= "BebidaId";
        public static final String COLUNA_NOME = "Nome";


    }

    public static abstract class TabelaBorda implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Bordas";
        public static final String COLUNA_ID= "BordasId";
        public static final String COLUNA_NOME = "Nome";

    }
    public static abstract class TabelaSabor implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Sabores";
        public static final String COLUNA_ID= "SaboresId";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_SABOR = "Fk_SaborId";
    }



    //Itempedido
    //Pizza

    //Pedido



    public static abstract class TabelaTamanho implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Tamanhos";
        public static final String COLUNA_ID= "TamanhoId";
        public static final String COLUNA_NOME = "Nome";

    }

    public static abstract class TabelaFormaPagamento implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_FormaPagamento";
        public static final String COLUNA_ID= "FormaPagamentoId";
        public static final String COLUNA_NOME = "Nome";

    }




//        try {
//
//        SQLiteDatabase bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);
//
//        //PEDIDOS
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pedidos" +
//                "(idPedido  PRIMARY KEY AUTOINCREMENT," +
//                "usuario ," +       //FK
//                "ITENS," +          //FK
//                "formapagamento," + //FK
//                "endereco, " +      //FK
//                "data DATE)");
//
//        //ITEM PEDIDO
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS itenspedido" +
//                "(itemId  PRIMARY KEY AUTOINCREMENT," +
//                "pizza VARCHAR NOT NULL," + // FK
//                "bebida varchar," + // FK
//                "quantidade INTEGER(2)," +
//                "subTotal DOUBLE," +
//                "precoPedido DOUBLE)");
//
//
//        //FORMA DE PAGAMENTO
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS formaDePagamentos" +
//                "(idFormaPagamento  PRIMARY KEY AUTOINCREMENT," +
//                "nome VARCHAR NOT NULL)");
//
//        //PIZZA
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pizzas" +
//                "(idPizza  PRIMARY KEY AUTOINCREMENT," +
//                "sabor," +          // FK
//                "tamnahho," +       // FK
//                "borda," +          //FK
//                "preco DOUBLE)");
//
//        //INGREDIENTES
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS ingredientes" +
//                "(idIngrediente  PRIMARY KEY AUTOINCREMENT," +
//                "nome VARCHAR NOT NULL)");
//
//        //TAMANHOS
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS tamanhos" +
//                "(idTamanho  PRIMARY KEY AUTOINCREMENT," +
//                "nome VARCHAR NOT NULL," +
//                "qtdPedacos integer(2) NOT NULL)");
//
//        bancodedados.execSQL("INSERT INTO tamanhos(nome,qtdPedacos) VALUES('Broto',4)");
//
//        //BEBIDAS
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS bebidas " +
//                "(idBebida  PRIMARY KEY AUTOINCREMENT," +
//                "nome VARCHAR NOT NULL," +
//                "preco DOUBLE NOT NULL)");
//
//        //BORDAS
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS bordas " +
//                "(idBorda  PRIMARY KEY AUTOINCREMENT," +
//                "nome VARCHAR NOT NULL)");
//
//        bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Catupiry')");
//        bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Cheddar')");
//        bancodedados.execSQL("INSERT INTO bordas(nome) VALUES('Chocolate')");
//
//        //ENDERECO
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS enderecos" +
//                "(idEndereco INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "cep VARCHAR NOT NULL," +
//                "rua VARCHAR NOT NULL," +
//                "bairro VARCHAR NOT NULL," +
//                "cidade VARCHAR," +
//                "numero INTEGER(5)," +
//                "complemento VARCHAR)");
//
//
//        // USUARIOS
//        bancodedados.execSQL("CREATE TABLE  IF NOT EXISTS usuarios" +
//                "(email VARCHAR PRIMARY KEY NOT NULL," +
//                "nome VARCHAR NOT NULL," +
//                "cpf VARCHAR," +
//                "telefone VARCHAR," +
//                "senha VARCHAR NOT NULL," +
//                "confSenha VARCHAR NOT NULL," +
//                "CONSTRAINT fk_UserEnd FOREIGN KEY(idEndereco) REFERENCES enderecos(idEndereco))");// FK Endereço
//
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }

}
