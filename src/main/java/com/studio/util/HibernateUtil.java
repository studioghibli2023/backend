package com.studio.util;

import java.util.Properties;

import com.studio.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                //settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test?useSSL=false");
                //settings.put(Environment.USER, "root");
                //settings.put(Environment.PASS, "euNaoSei8765");
                //settings.put(Environment.SHOW_SQL, "true");
                //settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                //TODO adding h2 for local test
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:mem:testdb");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "password");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
               throw new RuntimeException("Error connecting to database");
            }
        }
        return sessionFactory;
    }
}
