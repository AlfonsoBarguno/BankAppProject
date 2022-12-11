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
import java.time.Period;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class SavingsAccount extends Account {


    @Min(value = 100, message = "The minimum balance is 100.")
    private BigDecimal minimumBalance = BigDecimal.valueOf(1000);
    //default must be 1000

    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);
    //Por defecto debe ser de 0.0025 y máximo de 0.5


    public SavingsAccount(BigDecimal balance, Status status, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList, List<Transaction> receivingTransactionList, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(balance, status, secretKey, primaryOwner, secondaryOwner, sendingTransactionList, receivingTransactionList);
        setMinimumBalance(minimumBalance);
        setInterestRate(interestRate);
    }

    public void applyPenaltyFee() {

        if (getBalance().intValue() < minimumBalance.intValue()) {

            setBalance(getBalance().subtract(getPenaltyFee()));
        }
    }

    public void applyInterestRate() {

        Period oneYear1 = Period.between(getCreationDate(), LocalDate.now());

        if (oneYear1.getYears() > 1) {
            setBalance(BigDecimal.valueOf(getBalance().doubleValue()
                    * interestRate.doubleValue()).add(BigDecimal.valueOf(getBalance().doubleValue())));

        }

    }


    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {

        this.minimumBalance = minimumBalance;

        if (minimumBalance.intValue() < 100) {

            this.minimumBalance = BigDecimal.valueOf(100);

            System.out.println("The minimum balance is 100.");


        }

    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
        if (interestRate.doubleValue() > 0.5) {
            this.interestRate = BigDecimal.valueOf(0.5);
            System.out.println("The maxium interest rate is 0.5%.");
        }

    }


}
