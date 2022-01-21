package ru.geekbrains.flyweight.tea;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {

    private final Map<Integer, Tea> orders = new HashMap<>();
    private final TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public void takeOrder(int table, String teaType) {
        orders.put(table, teaMaker.make(teaType));
    }

    public void serve() {
        for (Map.Entry<Integer, Tea> entry:orders.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getDescription());
        }
    }
}
