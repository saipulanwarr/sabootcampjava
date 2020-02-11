package com.mycompany.app.database.hibernate.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "bank_account")

public class BankAccount {

    @Id // value will be generated based on the strategy
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, updatable = false)
    private String accountNumber;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

//    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
//    private List<AccountTransaction> transactions = new ArrayList<>();


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
