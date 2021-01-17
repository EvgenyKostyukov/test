package by.bot.test.rest;

import by.bot.test.rest.entity.Cities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {



        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cities.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();

            Cities cities = new Cities("Moscow", "info-1");

            session.beginTransaction();
            session.save(cities);
            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
