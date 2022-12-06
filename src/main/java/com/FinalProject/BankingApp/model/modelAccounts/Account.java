package com.FinalProject.BankingApp.model.modelAccounts;


import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    private String secretKey;

    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    @JsonIgnore
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    @JsonIgnore
    private AccountHolder secondaryOwner;

    private final BigDecimal penaltyFee = BigDecimal.valueOf(40.0);

    @OneToMany(mappedBy="sendingAccount", fetch = FetchType.EAGER)
    private List<Transaction> sendingTransactionList = new ArrayList<>();

    @OneToMany(mappedBy="receivingAccount", fetch = FetchType.EAGER)
    private List<Transaction> receivingTransactionList = new ArrayList<>();


    public Account(BigDecimal balance, Status status, LocalDate creationDate, String secretKey,
                   AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList,
                   List<Transaction> receivingTransactionList) {
        this.balance = balance;
        this.status = status;
        this.creationDate = creationDate;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.sendingTransactionList = sendingTransactionList;
        this.receivingTransactionList = receivingTransactionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }


    public List<Transaction> getSendingTransactionList() {
        return sendingTransactionList;
    }

    public void setSendingTransactionList(List<Transaction> sendingTransactionList) {
        this.sendingTransactionList = sendingTransactionList;
    }

    public List<Transaction> getReceivingTransactionList() {
        return receivingTransactionList;
    }

    public void setReceivingTransactionList(List<Transaction> receivingTransactionList) {
        this.receivingTransactionList = receivingTransactionList;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
