package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
//        userDaoHibernate.closeSessionFactory();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.closeSessionFactory();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
//        userDaoHibernate.closeSessionFactory();
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
//        userDaoHibernate.closeSessionFactory();
    }

    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
//        userDaoHibernate.closeSessionFactory();
    }
}
