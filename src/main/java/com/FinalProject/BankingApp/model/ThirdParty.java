package com.FinalProject.BankingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdParty {

    @Id
    private String hashKey;
    @NotEmpty(message="Enter a valid name.")
    private String name;
}
