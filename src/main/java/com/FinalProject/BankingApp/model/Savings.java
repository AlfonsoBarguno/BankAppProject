package com.FinalProject.BankingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Savings extends Account {

    @Min(value=100, message="The minimum balance is 100.")
    private BigInteger minimumBalance;
    //default must be 1000

    @Max(value= 1/2) //Debe ser 0.5 como máximo. No se puede hacer con anotación porque requiere integer
    private BigInteger interestRate;
    //Por defecto debe ser de 0.0025

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String secretKey;
}
