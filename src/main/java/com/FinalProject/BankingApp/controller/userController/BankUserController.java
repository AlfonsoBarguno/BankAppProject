package com.FinalProject.BankingApp.controller.userController;

import com.FinalProject.BankingApp.model.modelActors.Admin;
import com.FinalProject.BankingApp.model.modelActors.BankUser;
import com.FinalProject.BankingApp.model.modelSecurity.Role;
import com.FinalProject.BankingApp.repository.RoleRepository;
import com.FinalProject.BankingApp.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankUserController {

    @Autowired
    BankUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/create-user")
    public void createUser(@RequestBody BankUser user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        Role role = roleRepository.save(new Role("USER", user));

    }

    @PostMapping("/create-admin-user")
    public void createAdminUser(@RequestBody Admin user) {
        //codificamos el password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        Role role1 = roleRepository.save(new Role("USER", user));
        Role role2 = roleRepository.save(new Role("ADMIN", user));

    }

    @GetMapping("user-area")
    public String showUserArea() {
        return "Estás en el area solo para usuarios";
    }

    @GetMapping("user-admin-area/admin")
    public String showAdminArea() {
        return "Estás en el area solo para administradores";
    }


    @GetMapping("/user-details")
    public BankUser getUserDetails(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(name = "id") Long id) {
        return userRepository.findByUsername(userDetails.getUsername()).get();
    }

}
