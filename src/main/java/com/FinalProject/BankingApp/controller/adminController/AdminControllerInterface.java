package com.FinalProject.BankingApp.controller.adminController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelActors.ThirdParty;

import java.math.BigDecimal;

public interface AdminControllerInterface {

    Account substractBalance(Long accountHolderId, BigDecimal amount);
    Account addBalance(Long accountHolderId, BigDecimal amount);

    ThirdParty createThirdParty(ThirdParty thirdParty);

}
