package com.FinalProject.BankingApp.model.modelActors;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class AccountHolder extends BankUser {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    @NotNull(message="Enter valid address.")
    @Embedded
    private Address address;


    @AttributeOverrides({
            @AttributeOverride(name="streetAddress",column=@Column(name="mailing_street")),
            @AttributeOverride(name="city",column=@Column(name="mailing_city")),
            @AttributeOverride(name="postalCode",column=@Column(name="mailing_postal"))
    })
    @Embedded
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> accountList = new ArrayList<>();

    @OneToMany(mappedBy = "secondaryOwner")
    private List<Account> secondaryOwnerAccountList = new ArrayList<>();


    public AccountHolder(String name, LocalDate dateOfBirth, Address address,
                         Address mailingAddress, List<Account> accountList, List<Account> secondaryOwnerAccountList) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mailingAddress = mailingAddress;
        this.accountList = accountList;
        this.secondaryOwnerAccountList = secondaryOwnerAccountList;
    }

    public AccountHolder(String name, LocalDate of, Address address, Address address1) {
    }

    /*public AccountHolder(Address address) {
    }*/

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }


}
