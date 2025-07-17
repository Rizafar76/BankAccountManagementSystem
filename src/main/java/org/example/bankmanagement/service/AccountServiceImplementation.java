package org.example.bankmanagement.service;

import org.example.bankmanagement.entity.Account;
import org.example.bankmanagement.repositorys.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
       return  repo.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
         Account account = repo.findById(accountNumber).orElse(null);
        if(account == null){
            throw new RuntimeException("Account not found");
        }
        else
            return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    @Override
    public Account depositeAmount(Long accountNumber, Double money) {
        Account account = repo.findById(accountNumber).orElse(null);
        if(account == null){
            throw new RuntimeException("Account not found");
        }
        else{
//            Account accountPresent = account.get();
//            Account AccountPrsent = repo.findById();
            Double totalBalance = account.getAccountBalance() + money;
            account.setAccountBalance(totalBalance);
            repo.save(account);
            return account;
        }

    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double money) {

        Account account = repo.findById(accountNumber).orElse(null);
        if(account == null){
            throw new RuntimeException("Account not found");
        }
        else{
            Double totalBalance = account.getAccountBalance() - money;
            account.setAccountBalance(totalBalance);
            repo.save(account);
        }
        return account;
    }



    @Override
    public void closeAccount(Long accountNumber) {
//        Account account = repo.findById(accountNumber).orElse(null);
            repo.deleteById(accountNumber);


    }
}
