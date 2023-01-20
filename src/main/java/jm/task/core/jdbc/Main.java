package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Aboba", "Test", (byte) 12);
        userServiceImpl.saveUser("Biba", "Test", (byte) 12);
        userServiceImpl.saveUser("Boba", "Test", (byte) 12);

        List<User> userList = userServiceImpl.getAllUsers();
        System.out.println(userList);

        userServiceImpl.removeUserById(1);

        userServiceImpl.cleanUsersTable();

    }
}
