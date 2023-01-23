# BankAppProject
![cover](https://github.com/AlfonsoBarguno/BankAppProject/blob/main/BankAppSystemImage2.png)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Final bootcamp project demonstrating the use of Java and SpringBoot to build a microservice to be used by an online bank.
The system has 4 types of accounts, StudentChecking, Checking, Savings, and CreditCard. You can access either as an Admin or as a User, create an Account Holder or a Third Party user, and chose between four types of accounts. 
The system is able to modify accounts, make transfers, apply interest rates and penalty fees.
It is based in a SQL Database (you can change the name in in the application.properties file), has a Basic Auth level of security for Admins and Users and I'm currently working in the integration tests.

## Technologies
Project is created with:
- Java 18
- Spring Boot
- Maven
- MySQL Driver
- Spring Data JPA
- Spring Web
- Spring Boot DevTools
- Spring Security
- Project lombok
- SQL


	
## Setup
To run this project, download it using the git command *git clone* to the folder you want:
    ```
    C:\User\User> D:
    D:\ cd myProject
    D:\ myProject>git clone https://github.com/user/web_example.git
    ```




## Running locally 
```
localhost:9000/
```
Remember to set the password in application.properties.




### Author
<li><a href="https://github.com/AlfonsoBarguno">Alfonso Barguñó</a></li>






