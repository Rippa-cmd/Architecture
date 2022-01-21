package ru.geekbrains.adapter;

import ru.geekbrains.adapter.Fruits.*;

public class Main {
    public static void main(String[] args) {
        Fruit fruit1 = new Banana();
        Fruit fruit2 = new Apple();
        Watermelon watermelon = new Watermelon();
        Fruit fruit3 = new WatermelonAdapter(watermelon);
        fruit1.eat();
        fruit2.eat();
        fruit3.eat();
    }
}
