package com.FinalProject.BankingApp.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class Address {

    @NotEmpty(message="Enter valid street address.")
    private String streetAddress;
    @NotEmpty(message="Enter valid city.")
    private String city;
    @NotEmpty(message="Enter valid postal code.")
    private String postalCode;
}
