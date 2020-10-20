package com.kotsoft.persistence.util;

import com.kotsoft.persistence.entity.Contract;
import com.kotsoft.persistence.entity.Software;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Created by Matt on 24.05.2019 at 18:34.
 * Configuration class for Hibernate framework.
 */

public class HibernateUtil {

    /**
     * SessionFactory - reads the hibernate config file or config settings,
     * creates session objects,
     * heavy-weight object to be created only once.
     * Session - short-lived object retrieved from SessionFactory wraps a jdbc connection,
     * main object used to save & retrieve objects from DB
     */

    private static SessionFactory sessionFactory;

    /**
     * @return sessionFactory
     */

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                // credentials to be filled by the ***REMOVED***
                settings.put(AvailableSettings.DRIVER, "org.postgresql.Driver");
                settings.put(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/postgres");
                settings.put(AvailableSettings.USER, "postgres");
                settings.put(AvailableSettings.PASS, "***REMOVED***");
                settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(AvailableSettings.SHOW_SQL, "true");
                settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(AvailableSettings.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Contract.class);
                configuration.addAnnotatedClass(Software.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

}
