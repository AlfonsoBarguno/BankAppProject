package com.FinalProject.BankingApp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        //httpSecurity.authorizeHttpRequests().anyRequest().permitAll();

       httpSecurity.authorizeHttpRequests()

               .requestMatchers(HttpMethod.PATCH,"/admin/substract/{accountId}").hasRole("ADMIN")
               .requestMatchers(HttpMethod.PATCH,"/admin/add/{accountId}").hasRole("ADMIN")
               .requestMatchers(HttpMethod.POST,"/admin/createThirdParty").hasRole("ADMIN")
               .requestMatchers(HttpMethod.GET,"/accountholder/create").hasRole("ADMIN")
               .requestMatchers(HttpMethod.GET,"/accountHolder/findAll").hasRole("ADMIN")
               .requestMatchers(HttpMethod.DELETE,"/accountHolder/delete/{id}").hasRole("ADMIN")
               .requestMatchers(HttpMethod.GET,"/accountHolder/findById/{id}").hasRole("ADMIN")


               .requestMatchers(HttpMethod.GET,"/checkBalance/{accountHolderId}/{accountId}").hasRole("USER")
               .requestMatchers(HttpMethod.POST,"/transaction/{sendingAccountId}/{receivingAccountId}/{amount}").hasRole("USER")



               .anyRequest().permitAll();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
