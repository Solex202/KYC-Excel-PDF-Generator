package com.example.lota_project.DynamicPDF.service;

import com.example.lota_project.DynamicPDF.dtos.PaginatedResponse;
import com.example.lota_project.DynamicPDF.model.Transaction;
import com.example.lota_project.DynamicPDF.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(String id) {
        return null;
    }

    @Override
    public Transaction updateTransaction(String id, Transaction transaction) {
        return null;
    }

    @Override
    public void deleteTransaction(String id) {

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public PaginatedResponse getPaginatedTransactions(int pageNumber, int pageSize) {
        Page<Transaction> allTransaction = transactionRepository
                .findAll(PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "transactionDate")));

        return PaginatedResponse.builder()
                .transactions(allTransaction.getContent())
                .currentPage(allTransaction.getNumber())
                .noOfPatients(allTransaction.getNumberOfElements())
                .pageSize(allTransaction.getSize())
                .build();
    }
}
