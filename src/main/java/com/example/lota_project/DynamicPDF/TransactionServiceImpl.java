package com.example.lota_project.DynamicPDF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private Repo repo;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return repo.save(transaction);
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
        return repo.findAll();
    }

    @Override
    public PaginatedResponse getPaginatedTransactions(int pageNumber, int pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "registeredDate");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(order));

        Page<Transaction> allTransaction = repo.findAll(pageable);

        PaginatedResponse response = PaginatedResponse.builder()
                .patients(allTransaction.getContent())
                .currentPage(allTransaction.getNumber())
                .noOfPatients(allTransaction.getNumberOfElements())
                .pageSize(allTransaction.getSize())
                .build();

        return response;
    }
}
