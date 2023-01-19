package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        User user1 = new User("Aboba", "Test1", (byte) 20);
//        User user2 = new User("Biba", "Test2", (byte) 0);
//        User user3 = new User("Boba", "Test3", (byte) 10);


        var userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Aboba", "Test1", (byte) 20);
        userDaoJDBC.saveUser("Biba", "Test2", (byte) 0);
        userDaoJDBC.saveUser("Boba", "Test3", (byte) 10);

        System.out.println(userDaoJDBC.getAllUsers());

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();

    }
}
