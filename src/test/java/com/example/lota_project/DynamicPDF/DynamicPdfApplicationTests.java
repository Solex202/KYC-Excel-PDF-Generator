package com.example.lota_project.DynamicPDF;

import com.example.lota_project.DynamicPDF.dtos.CreateTransactionRequest;
import com.example.lota_project.DynamicPDF.dtos.PaginatedResponse;
import com.example.lota_project.DynamicPDF.model.AppUser;
import com.example.lota_project.DynamicPDF.model.Transaction;
import com.example.lota_project.DynamicPDF.model.TransactionType;
import com.example.lota_project.DynamicPDF.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DynamicPdfApplicationTests {
	@Autowired
		private TransactionService transactionServiceImpl ;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateTransaction() {
		CreateTransactionRequest transaction = new CreateTransactionRequest();
		transaction.setAmount(200.00);
		transaction.setTransactionType(String.valueOf(TransactionType.WITHDRAWAL));
		String res = transactionServiceImpl.createTransaction("659c0f434a09f44026fbe3b8",transaction);

//		assertThat(res.equals("Transaction created successfully") );
	}

	@Test
	void testGetTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100.00);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		Transaction t = transactionServiceImpl.getTransaction("1");
		assertThat(t.getAmount(), is(0.0));
	}

	@Test
	void testUpdateTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100.00);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transactionServiceImpl.updateTransaction("1", transaction);
	}

	@Test
	void testDeleteTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100.00);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transactionServiceImpl.deleteTransaction("1");
	}

	@Test
	void testGetAllTransactions() {
		List<Transaction> list =  transactionServiceImpl.getAllTransactions();
		assertEquals(4, list.size()) ;
	}

	@Test
	void testGetAllPaginatedTransactions() {
		PaginatedResponse list =  transactionServiceImpl.getPaginatedTransactions(1, 10);
		assertEquals(4, list.getNoOfPatients()) ;
	}

	@Test
	void createUser(){
		AppUser user = new AppUser();
		user.setName("John");
		user.setEmail("lota");

		transactionServiceImpl.createUser(user);
	}

}
