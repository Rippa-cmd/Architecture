package ru.geekbrains.decorator.pizza.pizza_additions;

import ru.geekbrains.decorator.pizza.Pizza;

public class Pepperoni implements Pizza {

    private final Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }
}
