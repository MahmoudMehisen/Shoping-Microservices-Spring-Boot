package com.mehisen.product.controller;

import com.mehisen.product.dto.Product;
import com.mehisen.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {


    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    ResponseEntity<Product> addProduct(@RequestBody Product product) {

        String status = productService.addProduct(product);
        logger.info("Product added statsu - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    List<Product> productList(){
        return productService.listAllProducts();
    }

    @GetMapping("/productList/{category}")
    List<Product> productCategoryList(@PathVariable String category){
        return productService.productCategoryList(category);
    }

    @GetMapping("/product/{id}")
    Product productById(@PathVariable Integer id){
        return productService.productById(id);
    }
    @PutMapping("/productUpdate")
    String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    String deleteProductById(@PathVariable Integer id){
        return productService.deleteProductById(id);
    }
}
