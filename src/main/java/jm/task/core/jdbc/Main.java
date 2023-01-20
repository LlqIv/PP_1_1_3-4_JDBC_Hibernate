package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        User user = new User("Biba", "B", (byte) 11);






//        try (var sessionFactory = Util.getSessionFactory();
//             var session = sessionFactory.openSession()) {
//
//            session.beginTransaction();
//            session.save(user);
//
//            System.out.println("OK");
//        }
        
    }
}
