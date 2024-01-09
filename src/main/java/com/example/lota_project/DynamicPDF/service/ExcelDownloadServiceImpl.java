package com.example.lota_project.DynamicPDF.service;

import com.example.lota_project.DynamicPDF.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

@Service
@RequiredArgsConstructor
public class ExcelDownloadServiceImpl implements ExcelDownloadService{

    private final TransactionService transactionService;
    @Override
    public ByteArrayInputStream downloadKyc(int page, int size) {
        try(Workbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            Sheet sheet = workbook.createSheet();
            var getKyc = transactionService.getPaginatedTransactions(page, size);
            String[] headers = {""};
            createHeader(headers, sheet, workbook);
            writeValueToExcelForAllMerchants(sheet);
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create sheet");
        };

        return null;
    }

    private void writeValueToExcelForAllMerchants(Sheet sheet) {


            int index = 0;
            for (Transaction transaction : merchants) {
                sheet.createRow(index + 1).createCell(0).setCellValue(transaction.getFullName());
                sheet.getRow(index + 1).getCell(1, CREATE_NULL_AS_BLANK).setCellValue(transaction.getId());
                sheet.getRow(index + 1).getCell(2, CREATE_NULL_AS_BLANK).setCellValue(transaction.getUsername());
                sheet.getRow(index + 1).getCell(3, CREATE_NULL_AS_BLANK).setCellValue(transaction.getPhoneNumber());
                sheet.getRow(index + 1).getCell(4, CREATE_NULL_AS_BLANK).setCellValue(transaction.getServices());
                var status = transaction.isDisabled() ? "InActive" : "Active";
                sheet.getRow(index + 1).getCell(5, CREATE_NULL_AS_BLANK).setCellValue(status);
                sheet.getRow(index + 1).getCell(6, CREATE_NULL_AS_BLANK).setCellValue(transaction.isKycVerified());
                sheet.getRow(index + 1).getCell(7, CREATE_NULL_AS_BLANK).setCellValue(transaction.isEmailVerified());
                index++;
            }
        }


    private void createHeader(String[] headers, Sheet sheet, Workbook workbook) {
        CellStyle headerStyle = createHeaderStyle(sheet, workbook);
        for (int index = 0; index < headers.length; index++){
            sheet.setColumnWidth(index, 5000);
            Cell cell = sheet.getRow(0).createCell(index);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(headers[index]);

        }
    }

    private CellStyle createHeaderStyle(Sheet sheet, Workbook workbook) {

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        font.setFontHeight((short) 200);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        sheet.createRow(0);
        return headerStyle;
    }
}