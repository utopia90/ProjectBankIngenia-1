package com.ingenia.projectbank;

import com.ingenia.projectbank.model.*;
import com.ingenia.projectbank.service.AccountService;
import com.ingenia.projectbank.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class ProjectBankApplication implements CommandLineRunner {


	 @Autowired
	MovementService movementService;

	 @Autowired
	AccountService accountService;


	public static void main(String[] args) {
		SpringApplication.run(ProjectBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		String dateInString1 = "2021-01-16T15:23:20Z";
		String dateInString2 = "2021-02-16T15:23:20Z";
		String dateInString3 = "2021-03-16T15:23:20Z";
		String dateInString4 = "2021-04-16T15:23:20Z";
		String dateInString5 = "2021-05-02T15:23:20Z";
		String dateInString6 = "2021-01-01T15:23:20Z";
		String dateInString7 = "2021-02-01T15:23:20Z";

		Instant instant1 = Instant.parse(dateInString1);
		Instant instant2 = Instant.parse(dateInString2);
		Instant instant3 = Instant.parse(dateInString3);
		Instant instant4 = Instant.parse(dateInString4);
		Instant instant5 = Instant.parse(dateInString5);
		Instant instant6 = Instant.parse(dateInString6);


		Account account1 = new Account("es2452645435454",3000.0);
		Movement movement1=new Movement(OperationType.REST, PaymentType.ACCOUNT, Instant.now(),320.0,account1, CategoryType.UTILITIES);
		Movement movement2=new Movement(OperationType.REST, PaymentType.CARD,instant1,100.0,account1, CategoryType.CLOTHES);
		Movement movement3=new Movement(OperationType.REST, PaymentType.CARD,instant2,20.0,account1, CategoryType.FUEL);
		Movement movement4=new Movement(OperationType.REST, PaymentType.ACCOUNT,instant3,40.0,account1, CategoryType.RESTAURANTS);
		Movement movement5=new Movement(OperationType.REST, PaymentType.CARD,instant4,400.0,account1, CategoryType.UTILITIES);
		Movement movement6=new Movement(OperationType.SUM, PaymentType.ACCOUNT,instant5,1200.0,account1, CategoryType.PAID);
		Movement movement7=new Movement(OperationType.SUM, PaymentType.ACCOUNT,instant6,1200.0,account1, CategoryType.PAID);
		account1.addMovimiento(movement1);
		account1.addMovimiento(movement2);
		account1.addMovimiento(movement3);
		account1.addMovimiento(movement4);
		account1.addMovimiento(movement5);
		account1.addMovimiento(movement6);
		account1.addMovimiento(movement7);
		movement1.setAccount(account1);
		movement2.setAccount(account1);
		movement3.setAccount(account1);
		movement4.setAccount(account1);
		movement5.setAccount(account1);
		movement6.setAccount(account1);
		movement7.setAccount(account1);
		accountService.createAccount(account1);

	}
}
