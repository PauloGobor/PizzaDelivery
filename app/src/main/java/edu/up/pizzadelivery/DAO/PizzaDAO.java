package edu.up.pizzadelivery.DAO;

import android.content.Context;

import edu.up.pizzadelivery.model.Pizza;

public class PizzaDAO {
    public static long CadastrarPedido(Context context, Pizza pizza) {
        BancoDeDado banco = new BancoDeDado(context);
        return banco.CadastrarPizza(pizza);

    }

}
