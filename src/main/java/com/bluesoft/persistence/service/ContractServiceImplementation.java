package com.***REMOVED***.persistence.service;

import com.***REMOVED***.persistence.dao.ContractDAO;
import com.***REMOVED***.persistence.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 18:34.
 */

@Service
public class ContractServiceImplementation implements ContractService {

    private ContractDAO contractDAO;

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
