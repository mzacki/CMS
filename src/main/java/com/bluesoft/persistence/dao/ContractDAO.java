package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Contract;
import com.***REMOVED***.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Matt on 22.05.2019 at 20:04.
 */

@Component
public class ContractDAO {

    public List<Contract> getContracts() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Contract", Contract.class).list();
        }

    }

    public void save(Contract contract) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.saveOrUpdate(contract);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Contract getContractById(long id) {

        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Contract contract = session.get(Contract.class, id);
            transaction.commit();
            return contract;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Contract contract = session.get(Contract.class, id);
            if (contract != null) {
                session.delete(contract);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
