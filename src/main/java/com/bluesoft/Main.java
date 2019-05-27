package com.***REMOVED***;

import com.***REMOVED***.persistence.dao.ContractDAOImplementation;
import com.***REMOVED***.persistence.entity.Contract;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Matt on 22.05.2019 at 20:08.
 */
public class Main {
    public static void main(String[] args) {

        ContractDAOImplementation contractDAOImplementation = new ContractDAOImplementation();

        Contract contract = new Contract("122/19", LocalDate.now(), LocalDate.now(), 123, "monthly", true);
        Contract contract2 = new Contract("124/19", LocalDate.now(), LocalDate.now(), 3342, "monthly", false);
        Contract contract3 = new Contract("125/19", LocalDate.now(), LocalDate.now(), 0, "yearly", true);
        contractDAOImplementation.saveContract(contract);
        contractDAOImplementation.saveContract(contract2);
        contractDAOImplementation.saveContract(contract3);


        List<Contract> contracts = contractDAOImplementation.getContracts();

        contracts.forEach(s -> System.out.println(s.getContractNumber()));

    }
}
