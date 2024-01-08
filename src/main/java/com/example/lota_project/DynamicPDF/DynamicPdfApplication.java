package com.example.lota_project.DynamicPDF;

import com.example.lota_project.DynamicPDF.model.AppUser;
import com.example.lota_project.DynamicPDF.model.Transaction;
import com.example.lota_project.DynamicPDF.model.TransactionType;
import com.example.lota_project.DynamicPDF.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DynamicPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPdfApplication.class, args);
	}
		@Bean
		public CommandLineRunner runner(TransactionRepository transactionRepository) {
			return args -> {
				Transaction transaction = Transaction.builder()
						.id("1")
						.transactionType(TransactionType.DEPOSIT)
						.user(AppUser.builder()
								.id("1")
								.name("John")
								.email("lota@email.com")
						.build()).build();

				Transaction transaction1 = Transaction.builder()
						.id("2")
						.transactionType(TransactionType.WITHDRAWAL)
						.user(AppUser.builder()
								.id("2")
								.name("deola")
								.email("deola@email.com")
								.build()).build();

			transactionRepository.save(transaction);
			transactionRepository.save(transaction1);
			};


	}

}
