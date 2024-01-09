package com.example.lota_project.DynamicPDF.service;

import com.example.lota_project.DynamicPDF.dtos.CreateTransactionRequest;
import com.example.lota_project.DynamicPDF.dtos.PaginatedResponse;
import com.example.lota_project.DynamicPDF.model.AppUser;
import com.example.lota_project.DynamicPDF.model.Transaction;
import com.example.lota_project.DynamicPDF.model.TransactionType;
import com.example.lota_project.DynamicPDF.repository.AppUserRepository;
import com.example.lota_project.DynamicPDF.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;
    private final AppUserRepository appUserRepository;

    public AppUser getUser(String id) {
        return appUserRepository.findById(id).orElseThrow(()-> new NoSuchElementException("not found"));
    }

    @Override
    public String createTransaction(String userId, CreateTransactionRequest createTransactionRequest) {
        AppUser appUser = getUser(userId);
        Transaction transaction = Transaction.builder()
                .transactionDate(LocalDateTime.now())
                .transactionType(TransactionType.valueOf(createTransactionRequest.getTransactionType()))
                .amount(createTransactionRequest.getAmount())
                .user(appUser)
                .build();
         transactionRepository.save(transaction);

         return "Transaction created successfully";
    }

    @Override
    public Transaction getTransaction(String id) {
        return transactionRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Transaction not found"));
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

    @Override
    public void createUser(AppUser user) {
        appUserRepository.save(user);
    }
}
