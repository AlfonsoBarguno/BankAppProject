package com.FinalProject.BankingApp.model.modelAccounts;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends Account {


    @Min(value=100, message="The minimum balance is 100.")
    private BigDecimal minimumBalance = BigDecimal.valueOf(1000);
    //default must be 1000

    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);
    //Por defecto debe ser de 0.0025 y máximo de 0.5


    public SavingsAccount(BigDecimal balance, Status status, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList, List<Transaction> receivingTransactionList, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(balance, status, secretKey, primaryOwner, secondaryOwner, sendingTransactionList, receivingTransactionList);
        setMinimumBalance(minimumBalance);
        setInterestRate(interestRate);
    }






   /* public BigDecimal getBalance() {
        return balance;
    }

    public void setSavingsAccountBalance(BigDecimal balance) {

        this.balance = balance;
        //si el balance es menor que el minimum, se resta la penaltyFee
        if(balance.intValue()< minimumBalance.intValue()){

            this.balance = (balance.subtract(getPenaltyFee()));

            //con BigDecimal (substract)
        }

        //cada año se le aplica la tasa de interés
        LocalDate oneYear = LocalDate.ofEpochDay(creationDate.getYear()+1);
        if(oneYear.isAfter(creationDate)){

        } //método que comprueba fecha, aplicar interestRate
    }*/



    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {

        this.minimumBalance = minimumBalance;

        if(minimumBalance.intValue()<100){

            this.minimumBalance= BigDecimal.valueOf(100);

            System.out.println("The minimum balance is 100.");


        }

    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
        if(interestRate.doubleValue() > 0.5){
            this.interestRate= BigDecimal.valueOf(0.5);
            System.out.println("The maxium interest rate is 0.5%.");
        }

    }





}
