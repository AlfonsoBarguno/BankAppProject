package com.FinalProject.BankingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class AccountHolder extends BankUser {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Enter valid date.")
    @NotEmpty(message="Enter valid date.")
    private LocalDate dateOfBirth;

    @Embedded
    private Address address;


    @Email(message="Enter valid Email.")
    private String mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> accountList;

    @OneToMany
    @JsonIgnore
    private List<Transaction> transactionList;

}
