package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 19:19.
 */
public class SystemDAOImplementation implements SystemDAO {

    // HQL statement false positive in IDE
    @Override
    public List<System> getSystems() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from System", System.class).list();
        }
    }
}
