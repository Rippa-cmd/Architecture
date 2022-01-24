package ru.geekbrains.visitor.visitors;

import ru.geekbrains.visitor.animals.Dolphin;
import ru.geekbrains.visitor.animals.Lion;
import ru.geekbrains.visitor.animals.Monkey;

public class Speak implements AnimalOperation{
    @Override
    public void visitMonkey(Monkey monkey) {
        monkey.shout();
    }

    @Override
    public void visitLion(Lion lion) {
        lion.roar();
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        dolphin.speak();
    }
}
