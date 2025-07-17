package org.example.bankmanagement.service;

import org.example.bankmanagement.entity.Account;
import org.example.bankmanagement.repositorys.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {



    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccounts();
    public Account depositeAmount(Long accountNumber, Double money);
    public Account withdrawAmount(Long accountNumber, Double money);
    public void closeAccount(Long accountNumber);
}
