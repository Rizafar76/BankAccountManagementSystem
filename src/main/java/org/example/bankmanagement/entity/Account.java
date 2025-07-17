package org.example.bankmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;

    @Column
    private String accountHolderName;

    @Column
    private Double accountBalance;

    public Account() {
    }

    public Account(String accountHolderName, Double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
}
