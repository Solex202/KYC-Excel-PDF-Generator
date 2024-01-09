package com.example.lota_project.DynamicPDF.repository;

import com.example.lota_project.DynamicPDF.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {
}
