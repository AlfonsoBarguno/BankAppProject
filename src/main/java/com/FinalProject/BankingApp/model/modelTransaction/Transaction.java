package com.FinalProject.BankingApp.model.modelTransaction;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "receivingAccount_id")
    @JsonIgnore
    private Account receivingAccount;

    @ManyToOne
    @JoinColumn(name = "sendingAccount_id")
    @JsonIgnore
    private Account sendingAccount;

    private BigDecimal amount;

    public Transaction(Account receivingAccount, Account sendingAccount, BigDecimal amount) {
        this.receivingAccount = receivingAccount;
        this.sendingAccount = sendingAccount;
        this.amount = amount;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(Account receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    public Account getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(Account sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
