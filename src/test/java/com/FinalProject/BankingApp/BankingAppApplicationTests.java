package com.FinalProject.BankingApp;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Address;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BankingAppApplicationTests {

	/*
	@Autowired

	private WebApplicationContext context;

	@Autowired
	private AccountRepository accountRepository;

	//MockMvc: Nos sirve para falsear peticiones http
	MockMvc mockMvc;

	//ObjectMapper: Convierte objetos a formato json
	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void setUp() {
		//Construimos el falseador, introduciendo el contexto de la app
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}


	//POST Methods
	@Test
	void shouldAddNewAccountHolder_whenPostIsPerformed() throws Exception {
		AccountHolder accountHolder = new AccountHolder(new Address("Calle Barcelona", "Granollers", "08028"));
		//Convertimos el objeto a formato json
		String body = objectMapper.writeValueAsString(accountHolder);

        Método perform: realiza una llamada http
        Método content: añade contenido (json) al request body
        Método contentType: define el tipo de contenido APPLICATION_JSON
        Método andExpect: Espera un determinado response status
        Método return: finaliza la llamada


		MvcResult result = mockMvc.perform(post("/accountHolder/create").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("Barcelona"));
	}

	//este no funciona
	@Test
	void shouldAddNewCheckingAccount_whenPostIsPerformed() throws Exception {
		CheckingAccount checkingAccount = new CheckingAccount(null, Status.ACTIVE,null, "gereonto",null,null,null,null,null);
		//Convertimos el objeto a formato json
		String body = objectMapper.writeValueAsString(checkingAccount);

		MvcResult result = mockMvc.perform(post("/checkingAccount/create").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("ACTIVE"));
	}

	@Test
	void shouldAddNewStudentCheckingAccount_whenPostIsPerformed() throws Exception {
		StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(); //construir objeto ACTIVE;
		//Convertimos el objeto a formato json
		String body = objectMapper.writeValueAsString(studentCheckingAccount);

		MvcResult result = mockMvc.perform(post("/studentCheckingAccount/create")
				.content(body).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("ACTIVE"));
	}

	@Test
	void shouldAddNewCreditCardAccount_whenPostIsPerformed() throws Exception {
		CreditCardAccount creditCardAccount = new CreditCardAccount(); //construir objeto ACTIVE;
		//Convertimos el objeto a formato json
		String body = objectMapper.writeValueAsString(creditCardAccount);

		MvcResult result = mockMvc.perform(post("/creditCard/create")
						.content(body).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();

		assertTrue(result.getResponse().getContentAsString().contains("ACTIVE"));
	}


	//GET Methods
	/*@Test
	public void shouldReturnAnAccount() throws Exception {

		MvcResult result = mockMvc.perform(get("/chekingAccount/findById/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Saporo")));
	}

	//PATCH Methods

	@Test
	public void shouldAddAmountToBalance () throws Exception{
	}

	public void shouldSubstractAmountFromBalance() throws Exception{
	}

	//DELETE Methods

	@Test
	public void shouldDeleteAnAccount() throws Exception{
	}

	//TRANSACTION

	@Test
	public void shouldTransferMoneyFromOneAccountToAnother() throws Exception{
	}

	@Test
	void contextLoads() {
	}*/

}
