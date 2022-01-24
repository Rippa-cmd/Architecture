package ru.geekbrains.visitor;

import ru.geekbrains.visitor.animals.Animal;
import ru.geekbrains.visitor.animals.Dolphin;
import ru.geekbrains.visitor.animals.Lion;
import ru.geekbrains.visitor.animals.Monkey;
import ru.geekbrains.visitor.visitors.AnimalOperation;
import ru.geekbrains.visitor.visitors.Jump;
import ru.geekbrains.visitor.visitors.Speak;

public class Main {
    public static void main(String[] args) {
        Animal monkey = new Monkey();
        Animal lion = new Lion();
        Animal dolphin = new Dolphin();

        AnimalOperation speak = new Speak();

        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);

        AnimalOperation jump = new Jump();

        monkey.accept(jump);
        lion.accept(jump);
        dolphin.accept(jump);
    }
}
