package com.FinalProject.BankingApp.model;

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
public class StudentCheckingAccount extends Account{


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    //@Future(message="Enter valid date.")
    private LocalDate creationDate;
    private Status status;
    @NotEmpty(message="Enter valid secret key.")
    private String secretKey;
}
