package com.mehisen.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private Integer id;

    @NotNull(message = "Product Name should not be null")
    private String name;

    @NotNull(message = "Category should not be null")
    private Category category;

    @Min(0)
    private double price;

    private List<String> imageURLs;

    private String currency;

    @Max(100)
    private double discount;
    private String discountDescription;


}
