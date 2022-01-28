package ru.geekbrains.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection connection;

    private final Map<Long, User> identityMap = new HashMap<>();

    private PreparedStatement ps;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            this.ps = connection.prepareStatement("select id, login, password from users where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    protected void insert(List<User> users) throws SQLException {
        ps = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?);");
        for (User user : users) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    protected void update(List<User> updateUsers) throws SQLException {
        ps = connection.prepareStatement("UPDATE users SET login = ?, password = ? WHERE (Id = ?);");
        for (User user : updateUsers) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getId());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    protected void delete(List<User> deleteUsers) throws SQLException {
        ps = connection.prepareStatement("DELETE FROM users WHERE (Id = ?);");
        for (User user : deleteUsers) {
            ps.setLong(1, user.getId());
            ps.addBatch();
        }
        ps.executeBatch();
    }
}
