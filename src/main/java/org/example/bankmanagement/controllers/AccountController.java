package org.example.bankmanagement.controllers;

import org.example.bankmanagement.entity.Account;
import org.example.bankmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    static class AccountControllerService {

    };

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
    }

    @GetMapping("/{id}")
    public Account getAccountDetailsByAccountNumber(@PathVariable("id")Long accountNumber) {
        return service.getAccountDetailsByAccountNumber(accountNumber);

    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PatchMapping("/deposit/{id}/{amount}")
    public Account deposit(@PathVariable("id") Long accountNumber,@PathVariable Double amount) {
        return service.depositeAmount(accountNumber,amount);
    }

    @PatchMapping("/withdraw/{id}/{amount}")
    public Account withdraw(@PathVariable("id") Long accountNumber,@PathVariable Double amount) {
        return service.withdrawAmount(accountNumber,amount);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable ("id")  Long accountNumber) {
        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
    }

}
