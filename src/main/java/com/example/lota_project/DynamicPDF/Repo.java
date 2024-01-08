package com.example.lota_project.DynamicPDF;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<Transaction, String> {
}
