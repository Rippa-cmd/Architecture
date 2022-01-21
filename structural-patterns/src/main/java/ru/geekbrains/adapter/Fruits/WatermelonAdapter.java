package ru.geekbrains.adapter.Fruits;

public class WatermelonAdapter implements Fruit{

    private final Watermelon watermelon;

    public WatermelonAdapter(Watermelon watermelon) {
        this.watermelon = watermelon;
    }

    @Override
    public void eat() {
        watermelon.drink();
    }
}
