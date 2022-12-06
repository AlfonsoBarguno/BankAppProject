package com.FinalProject.BankingApp.model.modelAccounts;

import com.FinalProject.BankingApp.model.modelActors.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class StudentCheckingAccount extends Account {



    @NotEmpty(message="Enter valid secret key.")
    private String secretKey;
}
