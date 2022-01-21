package ru.geekbrains.decorator;

import ru.geekbrains.decorator.pizza.BigPizza;
import ru.geekbrains.decorator.pizza.Pizza;
import ru.geekbrains.decorator.pizza.SmallPizza;
import ru.geekbrains.decorator.pizza.pizza_additions.Bacon;
import ru.geekbrains.decorator.pizza.pizza_additions.Cheese;
import ru.geekbrains.decorator.pizza.pizza_additions.Pepperoni;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new SmallPizza();
        Pizza pizzaWPepper = new Pepperoni(pizza);
        Pizza pizzaWCheese = new Cheese(pizzaWPepper);
        Pizza pizzaWBacon = new Bacon(pizzaWCheese);
        System.out.println(pizzaWBacon.getDescription() + ". Cost: " + pizzaWBacon.getCost());
    }
}
