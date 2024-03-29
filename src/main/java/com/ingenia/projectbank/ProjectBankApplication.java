package com.ingenia.projectbank;

import com.ingenia.projectbank.model.*;
import com.ingenia.projectbank.service.AccountService;
import com.ingenia.projectbank.service.BankCardService;
import com.ingenia.projectbank.service.MovementService;
import com.ingenia.projectbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class ProjectBankApplication implements CommandLineRunner {


	 @Autowired
	MovementService movementService;

	 @Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	@Autowired
	BankCardService bankCardService;

	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(ProjectBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		Account account1 = new Account("es2452645435454",3000.0, 600.00);
		Account account2 = new Account("es2452645435455",4000.0, 700.00);

		Movement movement1=new Movement(OperationType.REST, PaymentType.ACCOUNT, Instant.now(),LocalDate.now(),320.0,account1, CategoryType.UTILITIES);
		Movement movement2=new Movement(OperationType.REST, PaymentType.CREDIT,Instant.parse("2021-01-01T18:35:24.00Z"),LocalDate.parse("2021-01-01"),100.0,account1, CategoryType.CLOTHES);
		Movement movement3=new Movement(OperationType.REST, PaymentType.DEBIT,Instant.parse("2021-01-10T18:35:24.00Z"),LocalDate.parse("2021-01-10"),20.0,account1, CategoryType.FUEL);
		Movement movement4=new Movement(OperationType.REST, PaymentType.ACCOUNT,Instant.parse("2021-01-15T18:35:24.00Z"),LocalDate.parse("2021-01-15"),40.0,account1, CategoryType.RESTAURANTS);
		Movement movement5=new Movement(OperationType.REST, PaymentType.DEBIT,Instant.parse("2021-01-20T18:35:24.00Z"),LocalDate.parse("2021-01-20"),400.0,account1, CategoryType.UTILITIES);
		Movement movement6=new Movement(OperationType.SUM, PaymentType.ACCOUNT,Instant.parse("2021-02-01T18:35:24.00Z"),LocalDate.parse("2021-02-01"),1200.0,account1, CategoryType.PAID);
		Movement movement7=new Movement(OperationType.SUM, PaymentType.ACCOUNT,Instant.parse("2021-02-10T18:35:24.00Z"),LocalDate.parse("2021-02-10"),1200.0,account1, CategoryType.PAID);
		Movement movement8=new Movement(OperationType.REST, PaymentType.CREDIT,Instant.parse("2021-02-20T18:35:24.00Z"),LocalDate.parse("2021-02-20"),300.0,account2, CategoryType.CLOTHES);
		Movement movement9=new Movement(OperationType.SUM, PaymentType.ACCOUNT,Instant.parse("2021-02-22T18:35:24.00Z"),LocalDate.parse("2021-02-22"),1200.0,account2, CategoryType.PAID);
		Movement movement10=new Movement(OperationType.SUM, PaymentType.ACCOUNT,Instant.parse("2021-03-01T18:35:24.00Z"),LocalDate.parse("2021-03-01"),200.0,account2, CategoryType.PAID);
		Movement movement11=new Movement(OperationType.SUM, PaymentType.CREDIT,Instant.parse("2021-03-05T18:35:24.00Z"),LocalDate.parse("2021-03-05"),200.0,account2, CategoryType.PAID);
		Movement movement14=new Movement(OperationType.REST, PaymentType.DEBIT,Instant.parse("2021-04-01T18:35:24.00Z"),LocalDate.parse("2021-04-01"),200.0,account2, CategoryType.PAID);
		Movement movement15=new Movement(OperationType.SUM, PaymentType.DEBIT,Instant.parse("2021-04-10T18:35:24.00Z"),LocalDate.parse("2021-04-10"),200.0,account2, CategoryType.PAID);
		Movement movement16=new Movement(OperationType.SUM, PaymentType.DEBIT,Instant.parse("2021-04-15T18:35:24.00Z"),LocalDate.parse("2021-04-15"),200.0,account2, CategoryType.PAID);


		User user1 = new User("Borja", "Díaz", "borja@diaz",encoder.encode("1234"));
		User user2 = new User("Elena", "Fernández", "elena@fernandez",encoder.encode("1234"));
		User salvi = new User("salvi", "Lopez", "salvilopezpruebas@gmail.com",encoder.encode("salvi"));


		BankCard bankCard1 = new BankCard("392489234898492", "221", Instant.now());
		BankCard bankCard2 = new BankCard("1239123939q9q39", "114", Instant.now());


		account1.addMovimiento(movement1);
		account1.addMovimiento(movement2);
		account1.addMovimiento(movement3);
		account1.addMovimiento(movement4);
		account1.addMovimiento(movement5);
		account1.addMovimiento(movement6);
		account1.addMovimiento(movement7);
		account2.addMovimiento(movement10);
		account2.addMovimiento(movement11);
		account2.addMovimiento(movement14);
		account2.addMovimiento(movement15);
		account2.addMovimiento(movement16);







		movement1.setAccount(account1);
		movement2.setAccount(account1);
		movement3.setAccount(account1);
		movement4.setAccount(account1);
		movement5.setAccount(account1);
		movement6.setAccount(account1);
		movement7.setAccount(account1);
        movement10.setAccount(account2);
        movement11.setAccount(account2);
		movement14.setAccount(account2);
		movement15.setAccount(account2);
		movement16.setAccount(account2);






		user1.getAccounts().add(account1);
		user2.getAccounts().add(account2);

		account1.getUsers().add(user1);
		account2.getUsers().add(user2);

		account1.getCards().add(bankCard1);
		account2.getCards().add(bankCard2);

		bankCard1.setAccount(account1);
		bankCard2.setAccount(account2);
		account2.addMovimiento(movement8);
		movement8.setAccount(account2);
		account2.addMovimiento(movement9);
		movement9.setAccount(account2);

		accountService.createAccount(account1);
		accountService.createAccount(account2);


		userService.createUser(salvi);
		userService.createUser(user1);
		userService.createUser(user2);
		bankCardService.createBankCard(bankCard1);
		bankCardService.createBankCard(bankCard2);













	}
}
