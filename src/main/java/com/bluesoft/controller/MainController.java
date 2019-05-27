package com.***REMOVED***.controller;

import com.***REMOVED***.persistence.entity.Contract;
import com.***REMOVED***.persistence.entity.Software;
import com.***REMOVED***.persistence.service.ContractService;
import com.***REMOVED***.persistence.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Matt on 21.05.2019 at 20:18.
 */

@Controller
public class MainController {

    private ContractService contractService;
    private SoftwareService softwareService;

    @Autowired
    public MainController(ContractService contractService, SoftwareService softwareService) {
        this.contractService = contractService;
        this.softwareService = softwareService;
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("datatable")
    public String datatable() {
        return "datatable";
    }


    @GetMapping("list")
    public String listContracts(Model model) {

        List<Contract> contracts = contractService.getAll();
        model.addAttribute("contracts", contracts);

        return "list-contracts";
    }

    @GetMapping("listActive")
    public String listActive(Model model) {

        List<Contract> contracts = contractService.getEnabled();
        model.addAttribute("contracts", contracts);

        return "list-contracts";
    }

    @GetMapping("systemDetails")
    public String systemDetails(Model model, long id) {

        //Software software = softwareService.getDetailedSoftware(id);
        //model.addAttribute("system", software);
        Contract contract = contractService.getById(id);
        model.addAttribute("contract", contract);


        return "system-details";
    }

    @GetMapping("systems")
    public String listSystems(Model model) {

        List<Software> systems = softwareService.getAll();
        model.addAttribute("systems", systems);

        return "list-systems";
    }

    @GetMapping("showAddForm")
    public String showAddForm(Model model) {

        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "new-contract-form";
    }

    @GetMapping("showUpdateForm")
    public String showUpdateForm(@RequestParam("id") long id, Model model) {

        Contract contract = contractService.getById(id);
        model.addAttribute("contract", contract);
        return "contract-form";
    }

    @PostMapping("save")
    public String saveContract(@ModelAttribute("contract") Contract contract) {

        contractService.save(contract);
        return "redirect:/list";
    }

    @GetMapping("disable")
    public String disableContract(@RequestParam long id) {

        Contract contract = contractService.getById(id);
        contract.setEnabled(false);
        contractService.save(contract);
        return "redirect:/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") long id) {

        contractService.delete(id);
        return "redirect:/list";
    }

}
