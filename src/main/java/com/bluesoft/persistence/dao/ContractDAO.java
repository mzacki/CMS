package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Contract;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 18:21.
 */

public interface ContractDAO {

    List<Contract> getContracts();
    void saveContract(Contract contract);
    Contract getContractById(long id);
    void deleteContract(long id);

}
