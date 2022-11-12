package com.mehisen.product.service;

import com.mehisen.product.dto.ProductResponse;
import com.mehisen.product.exception.CurrencyNotValidException;
import com.mehisen.product.exception.ProductNotFoundException;
import com.mehisen.product.repsoitory.ProductRepository;
import com.mehisen.product.dto.Product;
import com.mehisen.product.exception.OfferNotValidException;
import com.mehisen.product.service.config.ProductConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductConfiguration productConfiguration;

    public ProductResponse addProduct(Product product) {


        log.info("adding product");
        if (product.getPrice() == 0 && product.getDiscount() > 0) {
            throw new OfferNotValidException("No discount is allowed at 0 product price");
        }

        if (!productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase())) {
            throw new CurrencyNotValidException("Invalid Currency. Valid currencies- " + productConfiguration.getCurrencies());
        }

        productRepository.save(product);
        Product savedProduct = productRepository.save(product);

        return new ProductResponse("success",savedProduct.getName() + "added into the system");
    }

    public List<Product> listAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No product found for the given query");
        }
        return products;
    }


    public List<Product> productCategoryList(String category) {
        List<Product> productsByCategory = productRepository.findByCategory(category);
        if (productsByCategory.isEmpty()) {
            throw new ProductNotFoundException("No product found for the category-" + category);
        }
        return productsByCategory;
    }

    public Product productById(String id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for id - " + id));
    }

    public ProductResponse updateProduct(Product product) {

        Optional<Product> prod = productRepository.findById(product.getId());
        if (!prod.isPresent()) {
            return new ProductResponse("FAILED", "Product to be updated not found in the system");
        }

        Product updatedProduct = productRepository.save(product);

        return new ProductResponse("SUCCESS", "Product Updated - " + updatedProduct.getName());
    }

    public ProductResponse deleteProductById(String id) {
        Optional<Product> prod = productRepository.findById(id);
        if (!prod.isPresent()) {
            return new ProductResponse("FAILED", "Product to be deleted not found in the system");
        }

        productRepository.deleteById(id);

        return new ProductResponse("SUCCESS", "Product Deleted");
    }
}
