package com.maxi.iPayback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.iPayback.dtos.TransactionDTO;
import com.maxi.iPayback.entities.transaction.Transaction;
import com.maxi.iPayback.serices.TransactionService;

@RestController
@RequestMapping("/api/ipay/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDTO obj) throws Exception {
        Transaction transaction = this.transactionService.createTransaction(obj);
        return ResponseEntity.ok().body(transaction);
    }

}
