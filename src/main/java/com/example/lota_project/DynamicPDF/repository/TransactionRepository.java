package com.example.lota_project.DynamicPDF.repository;

import com.example.lota_project.DynamicPDF.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
