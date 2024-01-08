package com.example.lota_project.DynamicPDF.service;

import com.example.lota_project.DynamicPDF.dtos.PaginatedResponse;
import com.example.lota_project.DynamicPDF.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransaction(String id);
    Transaction updateTransaction(String id, Transaction transaction);
    void deleteTransaction(String id);

    List<Transaction> getAllTransactions();

    PaginatedResponse getPaginatedTransactions(int page, int size);
}