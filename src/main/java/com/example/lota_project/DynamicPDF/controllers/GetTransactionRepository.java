package com.example.lota_project.DynamicPDF.controllers;

import com.example.lota_project.DynamicPDF.service.ExcelDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class GetTransactionRepository {

    private final ExcelDownloadService excelDownloadService;

    @GetMapping("/get-transaction")
    public ResponseEntity<?> downloadKyc(@RequestParam(value = "pageNumber") int pageNumber, @RequestParam(value = "pageSize") int pageSize){
        String fileName = "kyc.xlsx";

        ByteArrayInputStream res = excelDownloadService.downloadKyc(pageNumber, pageSize);

        InputStreamResource resource = new InputStreamResource(res);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(resource);

    }
}
