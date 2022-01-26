package ru.geekbrains.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final Connection connection;

    private final List<User> users = new ArrayList<>(0);
    private final List<User> updateUsers = new ArrayList<>(0);
    private final List<User> deleteUsers = new ArrayList<>(0);

    private PreparedStatement ps;

    public UnitOfWork(Connection connection) {
        this.connection = connection;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() throws SQLException {
        ps = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?);");
        for (User user : users) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    private void update() throws SQLException {
        ps = connection.prepareStatement("UPDATE users SET login = ?, password = ? WHERE (Id = ?);");
        for (User user : updateUsers) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getId());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    private void delete() throws SQLException {
        ps = connection.prepareStatement("DELETE FROM users WHERE (Id = ?);");
        for (User user : deleteUsers) {
            ps.setLong(1, user.getId());
            ps.addBatch();
        }
        ps.executeBatch();
    }
}
