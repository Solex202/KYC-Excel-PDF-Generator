package com.example.lota_project.DynamicPDF.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    private String id;
    private TransactionType transactionType;
    private AppUser user;
    private double amount;
    private LocalDateTime transactionDate;
}
