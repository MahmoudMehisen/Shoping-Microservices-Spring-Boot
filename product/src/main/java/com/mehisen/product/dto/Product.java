package com.mehisen.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection  = "product")
public class Product {

    @Id
    private Integer id;
    private String name;
    private Category category;
    private double price;

    private List<String> imageURLs;

    private String currency;

    private double discount;
    private String discountDescription;



}
