package ru.geekbrains.orm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final UserMapper mapper;

    private final List<User> users = new ArrayList<>(0);
    private final List<User> updateUsers = new ArrayList<>(0);
    private final List<User> deleteUsers = new ArrayList<>(0);

    public UnitOfWork(UserMapper mapper) {
        this.mapper = mapper;
    }

    public void registerNew(User user) {
        users.add(user);
    }

    public void updateUser(User user) {
        updateUsers.add(user);
    }

    public void deleteUser(User user) {
        deleteUsers.add(user);
    }

    public void commit() {
        try {
            insert();
            update();
            delete();
            clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() throws SQLException {
        mapper.insert(users);
    }

    private void update() throws SQLException {
        mapper.update(updateUsers);
    }

    private void delete() throws SQLException {
        mapper.delete(deleteUsers);
    }

    private void clear() {
        users.clear();
        updateUsers.clear();
        deleteUsers.clear();
    }
}
