package com.kotsoft.persistence.dao;

import com.kotsoft.persistence.entity.Software;
import com.kotsoft.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Created by Matt on 24.05.2019 at 19:19.
 * Implementation of DAO interface for Software entity class.
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
