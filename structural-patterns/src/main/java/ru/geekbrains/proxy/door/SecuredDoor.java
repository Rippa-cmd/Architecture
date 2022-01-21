package ru.geekbrains.proxy.door;

public class SecuredDoor {

    private final Door door;
    private final String PASS = "pass";

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {
        if (password.equals(PASS)) {
            door.open();
        } else {
            System.out.println("Wrong password");
        }
    }

    public void close() {
        door.close();
    }
}
