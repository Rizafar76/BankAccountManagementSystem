package org.example.bankmanagement.repositorys;

import org.example.bankmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
