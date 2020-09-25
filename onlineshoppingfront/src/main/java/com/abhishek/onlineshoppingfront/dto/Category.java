package com.abhishek.onlineshoppingfront.dto;

import lombok.Data;

@Data
public class Category {
    private String name;
    private String description;
    private String imageUrl;
    private boolean active = true;
}
