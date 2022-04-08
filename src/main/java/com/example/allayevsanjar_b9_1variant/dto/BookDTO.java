package com.example.allayevsanjar_b9_1variant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author Sanjarbek Allayev, пт 10:01. 08.04.2022
 */
@Data
public class BookDTO {

    private String name;

    private String category;

    private Double price;
}
