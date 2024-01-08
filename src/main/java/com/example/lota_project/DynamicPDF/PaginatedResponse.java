package com.example.lota_project.DynamicPDF;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PaginatedResponse {

    private List<Transaction> patients;

    private int currentPage;

    private int noOfPatients;

    private int pageSize;
}
