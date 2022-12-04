package com.FinalProject.BankingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class CreditCardAccount extends Account{

    private BigInteger interestRate;
    //por defecto, 0.2; puede ser menor que 0.2 pero no menor que 0.1;
    // se carga al balance cada mes.
    @Min(value=100)
    private BigInteger creditLimit;
    //por defecto, 100. Puede ser mayor que 100 pero menor que 1000000
}
