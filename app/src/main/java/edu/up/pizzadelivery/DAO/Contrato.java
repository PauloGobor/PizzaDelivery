package edu.up.pizzadelivery.DAO;

//https://www.sqlite.org/draft/datatype3.html
/// https://developer.android.com/training/data-storage/sqlite
// db browser sqlite

import android.provider.BaseColumns;

public final class Contrato {

    private Contrato() {
    }

    public static abstract class TabelaUsuario implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Usuario";
        public static final String COLUNA_ID = "Id";
        public static final String COLUNA_EMAIL = "Email";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_CPF = "Cpf";
        public static final String COLUNA_TELEFONE = "Telefone";
        public static final String COLUNA_SENHA = "Senha";


    }

    public static abstract class TabelaEndereco implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Endereco";
        public static final String COLUNA_ID = "EnderecoId";
        public static final String COLUNA_CEP = "Cep";
        public static final String COLUNA_RUA = "Rua";
        public static final String COLUNA_BAIRRO = "Bairro";
        public static final String COLUNA_CIDADE = "Cidade";
        public static final String COLUNA_NUMERO = "Numero";
        public static final String COLUNA_COMPLEMENTO = "Complemento";
        public static final String COLUNA_USUARIOID = "Fk_UsuarioId";
    }


    public static abstract class TabelaFormaPagamento implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_FormaPagamento";
        public static final String COLUNA_ID = "FormaPagamentoId";
        public static final String COLUNA_NOME = "Nome";

    }

    public static abstract class TabelaBebida implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Bebida";
        public static final String COLUNA_ID = "BebidaId";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_QTD = "Quantidade";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaBorda implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Borda";
        public static final String COLUNA_ID = "BordaId";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaTamanho implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Tamanho";
        public static final String COLUNA_ID = "TamanhoId";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_QTDSABOR = "QtdSabor";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaSabor implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Sabor";
        public static final String COLUNA_ID = "SaborId";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_INGREDIENTES = "Fk_ingredienteId";
    }


    public static abstract class TabelaPizza implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Pizza";
        public static final String COLUNA_ID = "PizzaId";
        public static final String COLUNA_SABOR = "Fk_SaborId";
        public static final String COLUNA_TAMANHO = "Fk_TamanhoId";
        public static final String COLUNA_BORDA = "Fk_BordaId";

    }

    public static abstract class TabelaItemPedido implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_ItensPedido";
        public static final String COLUNA_ID = "ItemPedidoId";
        public static final String COLUNA_PIZZA = "Fk_PizzaId";
        public static final String COLUNA_BEBIDA = "Fk_BebidaId";
        public static final String COLUNA_PEDIDO = "Fk_VendaId";
        public static final String COLUNA_QUANTIDADE = "Quantidade";
        public static final String COLUNA_SUBTOTAL = "Subtotal";
        public static final String COLUNA_PRECOPEDIDO = "PrecoPedido";

    }

    public static abstract class TabelaPedido implements BaseColumns {
        public static final String NOME_DA_TABELA = "tb_Pedido";
        public static final String COLUNA_ID = "PedidoId";
        public static final String COLUNA_USUARIO = "Fk_UsuarioId";
       // public static final String COLUNA_ITEM_PEDIDO = "Fk_ItemPedidoId";
        public static final String COLUNA_FORMA_PAGAMENTO = "Fk_formaPagamentoId";
       // public static final String COLUNA_ENDERECO = "Fk_EnderecoId";
        public static final String COLUNA_DATA = "Data";

    }

}
