package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Pizza;
import edu.up.pizzadelivery.model.PizzaPedida;

public class PizzaPedidaDAO {
    public static long CadastrarPizzaPedida(Context context, PizzaPedida pizza) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarPizzaPedida(pizza);
    }

}
