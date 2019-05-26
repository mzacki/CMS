package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Software;
import com.***REMOVED***.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 19:19.
 */
@Component
public class SoftwareDAOImplementation implements SoftwareDAO {

    // HQL statement false positive in IDE
    @Override
    public List<Software> getSoftwareSystems() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Software", Software.class).list();
        }
    }

    @Override
    public Software getSoftwareById(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Software software = session.get(Software.class, id);
            transaction.commit();
            return software;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;

    }
}
