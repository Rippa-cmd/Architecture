package ru.geekbrains.flyweight.tea;

import ru.geekbrains.flyweight.tea.Tea;

import java.util.HashMap;
import java.util.Map;

public class TeaMaker {

    private final Map<String, Tea> availableTea = new HashMap<>();

    public Tea make(String description) {
        if (availableTea.containsKey(description)) {
            return availableTea.get(description);
        } else {
            Tea tea = new Tea(description);
            availableTea.put(description, tea);
            return tea;
        }
    }
}
