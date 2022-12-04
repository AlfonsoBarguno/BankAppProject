package com.FinalProject.BankingApp.controller;

import com.FinalProject.BankingApp.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController implements CheckingControllerInterface{

    @Autowired
    CheckingService checkingService;
}
