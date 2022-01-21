package ru.geekbrains.proxy;

import ru.geekbrains.proxy.door.LabDoor;
import ru.geekbrains.proxy.door.SecuredDoor;

public class Main {
    public static void main(String[] args) {
        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("as");
        door.open("pass");
        door.close();
    }
}
