package ru.geekbrains.orm;

import java.sql.Connection;
import java.util.Optional;

public class UserRepository {

    private final Connection conn;

    private UnitOfWork unitOfWork;

    private final UserMapper userMapper;

    public UserRepository(Connection conn) {
        this.conn = conn;
        this.userMapper = new UserMapper(conn);
        this.unitOfWork = new UnitOfWork(userMapper);
    }

    public Optional<User> findById(long id) {
        return userMapper.findById(id);
    }

    public void beginTransaction() {
        this.unitOfWork = new UnitOfWork(userMapper);
    }

    public void registerNew(User user) {
        unitOfWork.registerNew(user);
    }

    public void updateUser(User user) {
        unitOfWork.updateUser(user);
    }
    public void deleteUser(User user) {
        unitOfWork.deleteUser(user);
    }

    public void commit() {
        unitOfWork.commit();
    }
}
