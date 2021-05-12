package com.ingenia.projectbank;

import com.ingenia.projectbank.model.*;
import com.ingenia.projectbank.service.AccountService;
import com.ingenia.projectbank.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String fecha1 = "2021-01-19 15:03:23";
		String fecha2 = "2021-02-20 15:03:23";
		String fecha3 = "2021-03-05 15:03:23";
		String fecha4 = "2020-04-06 15:03:23";
		String fecha5 = "2020-03-01 15:03:23";
		String fecha6 = "2020-04-01 15:03:23";
		Date fechaConHora1 = sdf.parse(fecha1);
		Date fechaConHora2 = sdf.parse(fecha2);
		Date fechaConHora3 = sdf.parse(fecha3);
		Date fechaConHora4 = sdf.parse(fecha4);
		Date fechaConHora5 = sdf.parse(fecha5);
		Date fechaConHora6 = sdf.parse(fecha6);

		Account account1 = new Account("es2452645435454",3000.0);
		Movement movement1=new Movement(OperationType.REST, PaymentType.ACCOUNT,new Date(),320.0,account1, CategoryType.UTILITIES);
		Movement movement2=new Movement(OperationType.REST, PaymentType.CARD,fechaConHora1,100.0,account1, CategoryType.CLOTHES);
		Movement movement3=new Movement(OperationType.REST, PaymentType.CARD,fechaConHora2,20.0,account1, CategoryType.FUEL);
		Movement movement4=new Movement(OperationType.REST, PaymentType.ACCOUNT,fechaConHora3,40.0,account1, CategoryType.RESTAURANTS);
		Movement movement5=new Movement(OperationType.REST, PaymentType.CARD,fechaConHora4,400.0,account1, CategoryType.UTILITIES);
		Movement movement6=new Movement(OperationType.SUM, PaymentType.ACCOUNT,fechaConHora5,1200.0,account1, CategoryType.PAID);
		Movement movement7=new Movement(OperationType.SUM, PaymentType.ACCOUNT,fechaConHora6,1200.0,account1, CategoryType.PAID);

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
