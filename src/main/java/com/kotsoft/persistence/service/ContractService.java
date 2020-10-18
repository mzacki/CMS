package com.kotsoft.persistence.service;

import com.kotsoft.persistence.entity.Contract;

import java.util.List;

/**
 * @author Created by Matt on 24.05.2019 at 18:34.
 * Service interface for Contract entity. Service layer separates DAO from business logic operations.
 */

public interface ContractService {

    List<Contract> getAll();

    List<Contract> getEnabled();

    void save(Contract contract);

    Contract getById(long id);

    void delete(long id);
}
