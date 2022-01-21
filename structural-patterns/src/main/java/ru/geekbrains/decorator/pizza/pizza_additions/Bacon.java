package ru.geekbrains.decorator.pizza.pizza_additions;

import ru.geekbrains.decorator.pizza.Pizza;

public class Bacon implements Pizza {

    private final Pizza pizza;

    public Bacon(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", bacon";
    }
}
