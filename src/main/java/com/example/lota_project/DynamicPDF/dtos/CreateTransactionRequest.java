package com.example.lota_project.DynamicPDF.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTransactionRequest {

    private String transactionType;
    private double amount;

}
