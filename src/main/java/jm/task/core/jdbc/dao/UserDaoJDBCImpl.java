package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private static final String CREATE_USER_TABLE = """
            CREATE TABLE IF NOT EXISTS users_table(
                id SERIAL PRIMARY KEY, 
                name VARCHAR(128) NOT NULL, 
                last_name VARCHAR(128) NOT NULL,
                age SMALLINT   
            );
                        
            """;

    private static final String DROP_USER_TABLE = """
            DROP TABLE IF EXISTS users_table;
            """;

    private static final String SAVE_USER = """
            INSERT INTO users_table (name, last_name, age) 
            VALUES (?, ?, ?);
            """;

    private static final String REMOVE_USER_BY_ID = """
            DELETE FROM users_table 
            WHERE id = ?;
            """;

    private static final String GET_ALL_USERS = """
            SELECT * 
            FROM users_table;
            """;
    private static final String CLEAN_USERS_TABLE = """
            TRUNCATE users_table;
            """;

    public void createUsersTable() {
        try (var connection = Util.getConnection();
             var preparedStatement = connection.prepareStatement(CREATE_USER_TABLE)) {
            System.out.println(preparedStatement.execute());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (var connection = Util.getConnection();
             var preparedStatement = connection.prepareStatement(DROP_USER_TABLE)) {
            System.out.println(preparedStatement.execute());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (var connection = Util.getConnection();
             var preparedStatement = connection.prepareStatement(REMOVE_USER_BY_ID)) {
            preparedStatement.setLong(1, id);

            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (var connection = Util.getConnection();
             var preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {

            var resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void cleanUsersTable() {
        try (var connection = Util.getConnection();
             var preparedStatement = connection.prepareStatement(CLEAN_USERS_TABLE)) {
            System.out.println(preparedStatement.execute());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
