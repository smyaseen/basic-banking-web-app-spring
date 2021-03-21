package org.smy.basicbankingapp.controller;

import org.smy.basicbankingapp.dao.TransactionRepository;
import org.smy.basicbankingapp.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping
    public String getTransactions(Model model) {
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions",transactions);
        return "transaction/transactions";
    }
}
