package com.example.lota_project.DynamicPDF;

import com.example.lota_project.DynamicPDF.dtos.PaginatedResponse;
import com.example.lota_project.DynamicPDF.model.Transaction;
import com.example.lota_project.DynamicPDF.model.TransactionType;
import com.example.lota_project.DynamicPDF.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DynamicPdfApplicationTests {
	@Autowired
		private TransactionService transactionServiceImpl ;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100.00);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transactionServiceImpl.createTransaction(transaction);
	}

	@Test
	void testGetTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAmount(100.00);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transactionServiceImpl.getTransaction("1");
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

}
