package ru.geekbrains.decorator.pizza;

public class BigPizza implements Pizza{
    @Override
    public int getCost() {
        return 600;
    }

    @Override
    public String getDescription() {
        return "Big pizza";
    }
}
