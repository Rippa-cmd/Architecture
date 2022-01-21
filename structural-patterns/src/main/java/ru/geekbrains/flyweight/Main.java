package ru.geekbrains.flyweight;

import ru.geekbrains.flyweight.tea.TeaMaker;
import ru.geekbrains.flyweight.tea.TeaShop;

public class Main {
    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        TeaShop teaShop = new TeaShop(teaMaker);
        teaShop.takeOrder(1, "Black tea with sugar");
        teaShop.takeOrder(2, "Green tea without sugar");
        teaShop.takeOrder(3, "Black tea with sugar");
        teaShop.takeOrder(4, "Black tea without sugar");
        teaShop.serve();
    }
}
