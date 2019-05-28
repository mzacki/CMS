package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Contract;

import java.util.List;

/**
 * @author Created by Matt on 24.05.2019 at 18:21.
 * Data Access Object interface for Contract entity.
 */

public interface ContractDAO {

    List<Contract> getContracts();

    List<Contract> getActiveContracts();

    void saveContract(Contract contract);

    Contract getContractById(long id);

    void deleteContract(long id);

}
