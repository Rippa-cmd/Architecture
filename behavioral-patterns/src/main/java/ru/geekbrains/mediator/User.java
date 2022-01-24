package ru.geekbrains.mediator;

public class User {
    private final String name;
    private final ChatRoomMediator mediator;

    public User(String name, ChatRoomMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        mediator.showMessage(this, message);
    }
}
