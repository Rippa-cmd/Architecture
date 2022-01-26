package ru.geekbrains.orm;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserRepository repository = new UserRepository(DBConnector.getConnection());
        System.out.println(repository.findById(1).get().getLogin());
        repository.beginTransaction();
        repository.registerNew(new User(2, "secondOne", "qwerty"));
        repository.updateUser(new User(1, "anotherOne", "qwert"));
        repository.deleteUser(new User(1, null, null));
        repository.commit();

    }
}
