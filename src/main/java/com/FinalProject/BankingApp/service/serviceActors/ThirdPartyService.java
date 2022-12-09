package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelActors.ThirdParty;
import com.FinalProject.BankingApp.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Override
    public ThirdParty createThirdParty(ThirdParty thirdParty) {
        return thirdPartyRepository.save(thirdParty);
    }
}
