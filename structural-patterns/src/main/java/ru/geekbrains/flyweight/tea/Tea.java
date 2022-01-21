package ru.geekbrains.flyweight.tea;

public class Tea {
    private final String description;

    public Tea(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
