package ru.geekbrains.observer;

import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String[] args) {
        CatholicChurch observable = new CatholicChurch();
        observable.addPropertyChangeListener(new Parishioner("Lucy"));
        PropertyChangeListener listener = new Parishioner("Judas");
        observable.addPropertyChangeListener(listener);

        observable.setNews("Something happens");

        observable.removePropertyChangeListener(listener);

        observable.setNews("Something happens again");

    }
}
