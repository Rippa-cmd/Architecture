package ru.geekbrains.decorator.pizza.pizza_additions;

import ru.geekbrains.decorator.pizza.Pizza;

public class Cheese implements Pizza {

    private final Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese";
    }
}
