package com.example.lota_project.DynamicPDF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private String id;
    private TransactionType transactionType;
    private DynamicPDF user;
    private double amount;
    private String transactionDate;
}
