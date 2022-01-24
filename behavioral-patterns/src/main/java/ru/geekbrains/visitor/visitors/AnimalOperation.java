package ru.geekbrains.visitor.visitors;

import ru.geekbrains.visitor.animals.Dolphin;
import ru.geekbrains.visitor.animals.Lion;
import ru.geekbrains.visitor.animals.Monkey;

public interface AnimalOperation {
    void visitMonkey(Monkey monkey);
    void visitLion(Lion lion);
    void visitDolphin(Dolphin dolphin);
}
