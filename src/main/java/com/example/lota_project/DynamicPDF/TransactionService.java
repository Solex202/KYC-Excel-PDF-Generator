package com.example.lota_project.DynamicPDF;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransaction(String id);
    Transaction updateTransaction(String id, Transaction transaction);
    void deleteTransaction(String id);

    List<Transaction> getAllTransactions();

    PaginatedResponse getPaginatedTransactions(int page, int size);
}
