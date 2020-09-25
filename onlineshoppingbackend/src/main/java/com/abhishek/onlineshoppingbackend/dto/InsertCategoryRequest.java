package com.abhishek.onlineshoppingbackend.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Data
public class InsertCategoryRequest {
    @NotBlank
    private String name;
    private String description;
    private String imageUrl;
    private boolean active;
}
