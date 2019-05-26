package com.***REMOVED***.persistence.service;

import com.***REMOVED***.persistence.entity.Contract;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 18:34.
 */
public interface ContractService {

    List<Contract> getAll();
    List<Contract> getEnabled();
    void save(Contract contract);
    Contract getById(long id);
    void delete(long id);
}
