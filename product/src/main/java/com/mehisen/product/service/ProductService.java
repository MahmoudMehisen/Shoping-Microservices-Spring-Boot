package com.mehisen.product.service;

import com.mehisen.product.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public String addProduct(Product product) {
        products.add(product);

        return "success";
    }

    public List<Product> listAllProducts() {
        return products;
    }


    public List<Product> productCategoryList(String category) {
        return products.stream().filter(product -> product.getCategory().getName().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public Product productById(Integer id) {
        return products.stream().filter(product -> product.getId() == id).findAny().get();
    }

    public String updateProduct(Product product) {
        for (Product prod : products) {
            if (prod.getId() == product.getId()) {
                prod.setName(product.getName());
                prod.setCategory(product.getCategory());
                prod.setDiscount(product.getDiscount());
                prod.setPrice(product.getPrice());
                prod.setDiscountDescription(product.getDiscountDescription());

                return "Product updated Successfully";
            }
        }

        return "Product update failed";
    }

    public String deleteProductById(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {

                products.remove(prod);
                return "Product deleted";
            }
        }

        return "Product deleted failed";
    }
}
