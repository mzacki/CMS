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

        Contract contract = new Contract("122/19", "Test2", LocalDate.now(), LocalDate.now(), 123, "monthly", true);
        Contract contract2 = new Contract("124/19", "Nasz", LocalDate.now(), LocalDate.now(), 3342, "monthly", false);
        Contract contract3 = new Contract("125/19", "Ich", LocalDate.now(), LocalDate.now(), 0, "yearly", true);
        contractDAO.save(contract);
        contractDAO.save(contract2);
        contractDAO.save(contract3);


        List<Contract> contracts = contractDAO.getContracts();

        contracts.forEach(s -> System.out.println(s.getContractNumber()));

    }
}
