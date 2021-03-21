package org.smy.basicbankingapp.controller;

import org.smy.basicbankingapp.dao.CustomerRepository;
import org.smy.basicbankingapp.dao.TransactionRepository;
import org.smy.basicbankingapp.entities.Customer;
import org.smy.basicbankingapp.entities.Transaction;
import org.smy.basicbankingapp.entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping
    public String getCustomers(Model model) {
            List<Customer> customerList = customerRepository.findAll();
            model.addAttribute("customers",customerList);
            return "customer/customers";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getACustomer(@PathVariable String id, Model model) {
        Customer customer = customerRepository.findById(Long.parseLong(id)).get();
        List<Customer> customerList = customerRepository.findAll();
        Transfer transfer = new Transfer();
        model.addAttribute("transfer",transfer);
        model.addAttribute("customer",customer);
        model.addAttribute("customers",customerList);
        return "customer/aCustomer";
    }

    @GetMapping("/new-customer")
    public String displayEmployeeForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer/new-customer";
    }

    @PostMapping("/save")
    public String createEmployee(Customer customer, Model model) {
        customerRepository.save(customer);
        return "redirect:";
    }

    @RequestMapping(value = "/transfer/{fromId}", method = RequestMethod.POST)
    public String transferAmount(@PathVariable String fromId, Transfer transfer, Model model) {

        Customer toCustomer = customerRepository.findById(transfer.getToId()).get();
        Customer fromCustomer = customerRepository.findById(Long.parseLong(fromId)).get();

        if (fromCustomer.getBalance() >= transfer.getBalance()) {
        customerRepository.updateCustomer(fromCustomer.getBalance() - transfer.getBalance(),
                fromCustomer.getCustomerId());
        customerRepository.updateCustomer(toCustomer.getBalance() + transfer.getBalance(),
                toCustomer.getCustomerId());
        }

        model.addAttribute("customer",fromCustomer);

        Transaction transaction = new Transaction(fromCustomer.getName(),
                toCustomer.getName(),fromCustomer.getCustomerId(),
                toCustomer.getCustomerId(),transfer.getBalance());

        transactionRepository.save(transaction);

        return "redirect:/customers";
    }

}
