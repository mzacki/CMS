package com.***REMOVED***;

import com.***REMOVED***.persistence.dao.ContractDAO;
import com.***REMOVED***.persistence.entity.Contract;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Matt on 22.05.2019 at 20:08.
 */
public class Main {
    public static void main(String[] args) {

        ContractDAO contractDAO = new ContractDAO();

        Contract contract = new Contract("123/123", "Test", LocalDate.now(), LocalDate.now(), 123, "monthly", true);

        contractDAO.saveContract(contract);

        List<Contract> contracts = contractDAO.getContracts();

        contracts.forEach(s -> System.out.println(s.getContractNumber()));

    }
}
