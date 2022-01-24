package ru.geekbrains.visitor.animals;

import ru.geekbrains.visitor.visitors.AnimalOperation;

public interface Animal {
    void accept(AnimalOperation operation);
}
