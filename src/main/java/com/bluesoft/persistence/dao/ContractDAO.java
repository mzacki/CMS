package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Contract;
import com.***REMOVED***.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Matt on 22.05.2019 at 20:04.
 */
public class ContractDAO {

    public void saveContract(Contract contract) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start a transaction

            transaction = session.beginTransaction();

            // save the student object

            session.save(contract);

            // commit transaction

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            e.printStackTrace();

        }

    }

    public List<Contract> getContracts() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("from Contract", Contract.class).list();

        }

    }
}
