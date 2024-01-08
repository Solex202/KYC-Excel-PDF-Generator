package com.example.lota_project.DynamicPDF.dtos;

import com.example.lota_project.DynamicPDF.model.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PaginatedResponse {

    private List<Transaction> transactions;

    private int currentPage;

    private int noOfPatients;

    private int pageSize;
}
