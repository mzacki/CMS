package com.kotsoft.persistence.service;

import com.kotsoft.persistence.dao.ContractDAO;
import com.kotsoft.persistence.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Matt on 24.05.2019 at 18:34.
 * Service interface implementation for Contract entity. Service layer separates DAO from business logic operations.
 */

@Service
public class ContractServiceImplementation implements ContractService {

    private final ContractDAO contractDAO;

    @Autowired
    public ContractServiceImplementation(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Override
    public List<Contract> getAll() {
        return contractDAO.getContracts();
    }

    @Override
    public List<Contract> getEnabled() {
        return contractDAO.getActiveContracts();
    }

    @Override
    public void save(Contract contract) {
        contractDAO.saveContract(contract);
    }

    @Override
    public Contract getById(long id) {
        return contractDAO.getContractById(id);
    }

    @Override
    public void delete(long id) {
        contractDAO.deleteContract(id);
    }
}
