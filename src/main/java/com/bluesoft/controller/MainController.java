package com.***REMOVED***.controller;

import com.***REMOVED***.persistence.entity.Contract;
import com.***REMOVED***.persistence.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Matt on 21.05.2019 at 20:18.
 */

@Controller
public class MainController {

    private ContractService contractService;

    @Autowired
    public MainController(ContractService contractService) {
        this.contractService = contractService;
    }

    // test only, to be removed
    @ResponseBody
    @GetMapping("/greetings")
    public String greetings() {
        return "greetings";
    }

    // test only, to be removed
    @GetMapping("test")
    public String test(Model model) {

        LocalDateTime dateTime = LocalDateTime.now();
        model.addAttribute("Date", dateTime);
        return "test";
    }

    @GetMapping("list")
    public String listContracts(Model model) {

        List<Contract> contracts = contractService.getAll();
        model.addAttribute("contracts", contracts);

        return "list-contracts";
    }

    @GetMapping("showAddForm")
    public String showAddForm(Model model) {

        Contract contract = new Contract();
        model.addAttribute("contract", contract);

        return "contract-form";
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

    @GetMapping("delete")
    public String delete(@RequestParam("id") long id) {

        contractService.delete(id);
        return "redirect:/list";
    }

}
