package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Address;
import com.FinalProject.BankingApp.model.modelActors.ThirdParty;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Override
    public ThirdParty createThirdParty(ThirdParty thirdParty) {

        AccountHolder accountHolder = new AccountHolder();

        accountHolder.setName(thirdParty.getName());

        accountHolder.setAddress(new Address("Calle Java", "JavaCity", "08028"));

        accountHolderRepository.save(accountHolder);

        thirdParty.setId(accountHolder.getId());

        return thirdPartyRepository.save(thirdParty);
    }
}
