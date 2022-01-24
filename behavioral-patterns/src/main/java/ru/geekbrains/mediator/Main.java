package ru.geekbrains.mediator;

public class Main {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();
        User Ivan = new User("Ivan", mediator);
        User Petr = new User("Petr", mediator);
        Ivan.send("Hello!");
        Petr.send("Hi, Ivan!");
    }
}
