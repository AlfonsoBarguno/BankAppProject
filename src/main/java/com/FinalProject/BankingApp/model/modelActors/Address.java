package com.FinalProject.BankingApp.model.modelActors;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class Address {

    private String streetAddress;
    private String city;
    private String postalCode;
}
