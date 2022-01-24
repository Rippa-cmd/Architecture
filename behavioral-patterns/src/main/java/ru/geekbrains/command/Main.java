package ru.geekbrains.command;

import ru.geekbrains.command.commands.Command;
import ru.geekbrains.command.commands.TurnOff;
import ru.geekbrains.command.commands.TurnOn;

public class Main {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        Command on = new TurnOn(bulb);
        Command off = new TurnOff(bulb);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.submit(on);
        remoteControl.submit(off);
    }
}
