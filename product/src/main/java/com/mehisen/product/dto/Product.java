package com.mehisen.product.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description =  "Contains all the attributes required under product entity")
public class Product {

    @Id
    @ApiModelProperty("This is the unique Id of the product, will be generated by the system itself")
    private String id;

    @NotNull(message = "Product Name should not be null")
    @ApiModelProperty("Name of the product")
    private String name;

    @NotNull(message = "Category of the product should not be null")
    private Category category;

    @Min(0)
    private double price;

    @ApiModelProperty("List of URL of the product images")
    private List<String> imageURLs;

    private String currency;

    @Max(100)
    private double discount;
    private String discountDescription;


}
