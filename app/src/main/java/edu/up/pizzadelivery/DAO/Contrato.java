package edu.up.pizzadelivery.DAO;

//https://www.sqlite.org/draft/datatype3.html
/// https://developer.android.com/training/data-storage/sqlite
// db browser sqlite

import android.provider.BaseColumns;

public final class Contrato {

    private Contrato() {
    }

    public static abstract class TabelaUsuario implements BaseColumns {
        public static final String NOME_DA_TABELA = "Usuarios";
        public static final String COLUNA_ID = "Id";
        public static final String COLUNA_EMAIL = "Email";
        public static final String COLUNA_NOME = "Nome";
        public static final String COLUNA_CPF = "Cpf";
        public static final String COLUNA_TELEFONE = "Telefone";
        public static final String COLUNA_SENHA = "Senha";


    }

    public static abstract class TabelaEndereco implements BaseColumns {
        public static final String NOME_DA_TABELA = "Enderecos";
        public static final String COLUNA_ID = "EnderecoId";
        public static final String COLUNA_CEP = "Cep";
        public static final String COLUNA_RUA = "Rua";
        public static final String COLUNA_BAIRRO = "Bairro";
        public static final String COLUNA_CIDADE = "Cidade";
        public static final String COLUNA_NUMERO = "Numero";
        public static final String COLUNA_COMPLEMENTO = "Complemento";
        public static final String COLUNA_USUARIOID = "UsuarioId";
    }


    public static abstract class TabelaFormaPagamento implements BaseColumns {
        public static final String NOME_DA_TABELA = "FormasPagamento";
        public static final String COLUNA_ID = "FormaPagamentoId";
        public static final String COLUNA_NOME = "NomeFormaPagamento";

    }

    public static abstract class TabelaBebida implements BaseColumns {
        public static final String NOME_DA_TABELA = "Bebidas";
        public static final String COLUNA_ID = "BebidaId";
        public static final String COLUNA_NOME = "NomeBebida";
        public static final String COLUNA_QTD = "Quantidade";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaBorda implements BaseColumns {
        public static final String NOME_DA_TABELA = "Bordas";
        public static final String COLUNA_ID = "BordaId";
        public static final String COLUNA_NOME = "NomeBorda";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaTamanho implements BaseColumns {
        public static final String NOME_DA_TABELA = "Tamanhos";
        public static final String COLUNA_ID = "TamanhoId";
        public static final String COLUNA_NOME = "NomeTamanho";
        public static final String COLUNA_QTDSABOR = "QtdSabor";
        public static final String COLUNA_PRECO = "Preco";

    }

    public static abstract class TabelaSabor implements BaseColumns {
        public static final String NOME_DA_TABELA = "Sabores";
        public static final String COLUNA_ID = "SaborId";
        public static final String COLUNA_NOME = "NomeSabor";
        public static final String COLUNA_DESCRICAO = "Descricao";
    }


    public static abstract class TabelaPizza implements BaseColumns {
        public static final String NOME_DA_TABELA = "Pizzas";
        public static final String COLUNA_ID = "PizzaId";
        public static final String COLUNA_TAMANHO = "TamanhoId";
        public static final String COLUNA_BORDA = "BordaId";

    }

    public static abstract class TabelaPizzaPedida implements BaseColumns {
        public static final String NOME_DA_TABELA = "PizzasPedida";
        public static final String COLUNA_ID = "PizzaPedidaId";
        public static final String COLUNA_PIZZA = "PizzaId";
        public static final String COLUNA_SABOR = "SaborId";
    }

    public static abstract class TabelaItemPedido implements BaseColumns {
        public static final String NOME_DA_TABELA = "ItensPedido";
        public static final String COLUNA_ID = "ItemPedidoId";
        public static final String COLUNA_PIZZA = "PizzaId";
        public static final String COLUNA_BEBIDA = "BebidaId";
        public static final String COLUNA_PEDIDO = "PedidoId";
        public static final String COLUNA_QUANTIDADE = "Quantidade";
        public static final String COLUNA_SUBTOTAL = "Subtotal";


    }

    public static abstract class TabelaPedido implements BaseColumns {
        public static final String NOME_DA_TABELA = "Pedidos";
        public static final String COLUNA_ID = "PedidoId";
        public static final String COLUNA_USUARIO = "UsuarioId";
        public static final String COLUNA_FORMA_PAGAMENTO = "FormaPagamentoId";
        // public static final String COLUNA_ENDERECO = "Fk_EnderecoId";
        public static final String COLUNA_DATA = "Data";
        public static final String COLUNA_TOTAL = "Total";

    }

}
