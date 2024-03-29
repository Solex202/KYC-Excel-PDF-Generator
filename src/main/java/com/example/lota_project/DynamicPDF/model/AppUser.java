package com.example.lota_project.DynamicPDF.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {

    @Id
    private String id;
    private String name;
    private String email;
}
