package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Contract;
import com.***REMOVED***.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Created by Matt on 22.05.2019 at 20:04.
 * Implementation of DAO interface for Contract entity class.
 */

@Component
public class ContractDAOImplementation implements ContractDAO {


    // HQL statement may give false positive in IntelliJ IDE
    @Override
    public List<Contract> getContracts() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Contract", Contract.class).getResultList();
        }

    }

    @Override
    public List<Contract> getActiveContracts() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Contract c where c.enabled=true", Contract.class).getResultList();
        }
    }

    @Override
    public void saveContract(Contract contract) {

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

    @Override
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

    @Override
    public void deleteContract(long id) {

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
