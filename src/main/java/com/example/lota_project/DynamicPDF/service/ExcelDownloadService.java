package com.example.lota_project.DynamicPDF.service;

import java.io.ByteArrayInputStream;

public interface ExcelDownloadService {

    ByteArrayInputStream downloadKyc(int page, int size);
}
