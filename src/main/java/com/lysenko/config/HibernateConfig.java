package com.lysenko.config;

import com.lysenko.entity.Developer;
import com.lysenko.entity.Skill;
import com.lysenko.entity.Specialty;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Создание объекта Configuration с настройками Hibernate
                Configuration configuration = new Configuration();

                // Указание настроек подключения к базе данных
                configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/crud");
                configuration.setProperty("hibernate.connection.username", "postgres");
                configuration.setProperty("hibernate.connection.password", "Qq111111");

                // Добавление классов, которые будут сопоставлены с таблицами
                configuration.addAnnotatedClass(Developer.class);
                configuration.addAnnotatedClass(Specialty.class);
                configuration.addAnnotatedClass(Skill.class);

                // Создание SessionFactory
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                throw new RuntimeException("Failed to build SessionFactory " + e);
            }
        }
        return sessionFactory;
    }
}
