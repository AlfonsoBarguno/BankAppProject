package com.FinalProject.BankingApp.controller.adminController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelActors.BankUser;
import com.FinalProject.BankingApp.model.modelActors.ThirdParty;
import com.FinalProject.BankingApp.model.modelSecurity.Role;
import com.FinalProject.BankingApp.repository.BankUserRepository;
import com.FinalProject.BankingApp.repository.RoleRepository;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceActors.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/admin")
public class AdminController implements AdminControllerInterface{


    @Autowired
    AccountService accountService;

    @Autowired
    ThirdPartyService thirdPartyService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BankUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/create-user")
    public void createUser(@RequestBody BankUser user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        Role role = roleRepository.save(new Role("USER", user));

    }

    @PostMapping("/create-admin-user")
    public void createAdminUser(@RequestBody BankUser user) {
        //codificamos el password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        Role role1 = roleRepository.save(new Role("USER", user));
        Role role2 = roleRepository.save(new Role("ADMIN", user));

    }


    //un método con pathVariable y requestParam
    @Override
    @PatchMapping("/substract/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public Account substractBalance(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        return accountService.substractBalance(accountId,amount);
    }

    //otro con dos requestParam
    @Override
    @PatchMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Account addBalance(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        return accountService.addBalance(accountId,amount);
    }

    @Override
    @PostMapping("/createThirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty) {
        return thirdPartyService.createThirdParty(thirdParty);
    }
}
