package com.example.lota_project.DynamicPDF;

import com.example.lota_project.DynamicPDF.service.ExcelDownloadService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExcelDownloadServiceTest {

    @Autowired
    private  ExcelDownloadService excelDownloadService;

    @Test
    void downloadKyc() {
       ByteArrayInputStream res = excelDownloadService.downloadKyc(1, 10);
       assertThat(res, is(res));

    }
}
