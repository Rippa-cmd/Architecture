package ru.geekbrains.decorator.pizza;

public class SmallPizza implements Pizza{
    @Override
    public int getCost() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "Small pizza";
    }
}
