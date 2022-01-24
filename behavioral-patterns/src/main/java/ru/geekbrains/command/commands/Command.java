package ru.geekbrains.command.commands;

public interface Command {
    void execute();
    void undo();
    void redo();
}
