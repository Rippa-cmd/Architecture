package ru.geekbrains.command;

import ru.geekbrains.command.commands.Command;

public class RemoteControl {
    public void submit(Command command) {
        command.execute();
    }
}
