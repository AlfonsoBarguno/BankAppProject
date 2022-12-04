package com.FinalProject.BankingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;

@PrimaryKeyJoinColumn(name="id")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckingAccount extends Account{

    private BigInteger monthyMaintenanceFee; //12 al mes

    @NotEmpty(message="Enter valid ssecret key")
    private String secretKey;

    private BigInteger minimumBalance; //min=250; si se baja, balance=balance-penaltyFee

    @DateTimeFormat(pattern = "dd/MM/yyyy")

    //@Future(message="Enter valid date.")
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;




}
