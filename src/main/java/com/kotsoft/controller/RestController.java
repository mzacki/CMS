package com.kotsoft.controller;

import com.kotsoft.persistence.entity.Contract;
import com.kotsoft.persistence.service.ContractService;
import com.kotsoft.persistence.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Created by Matt on 27.05.2019 at 18:01.
 * REST controller for jquery datatables implementation.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private ContractService contractService;
    private SoftwareService softwareService;

    @Autowired
    public RestController(ContractService contractService, SoftwareService softwareService) {
        this.contractService = contractService;
        this.softwareService = softwareService;
    }

    @RequestMapping(value = "/getList")
    public @ResponseBody
    List<Contract> getList() {
        return contractService.getAll();
    }

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Contract getContractById(@PathVariable("id") long id) {
        return contractService.getById(id);
    }
}
