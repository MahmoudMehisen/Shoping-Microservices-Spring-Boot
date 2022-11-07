package com.mehisen.product.service;

import com.mehisen.product.ProductRepository;
import com.mehisen.product.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }


    public List<Product> productCategoryList(String category) {
        return productRepository.findByCategory(category);
    }

    public Product productById(Integer id) {
        return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {

        productRepository.save(product);

        return "Product updated Successfully";

    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "Product deleted";


    }
}
