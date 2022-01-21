package ru.geekbrains.proxy.door;

public class LabDoor implements Door{
    @Override
    public void open() {
        System.out.println("Door is opened");
    }

    @Override
    public void close() {
        System.out.println("Door is closed");
    }
}
