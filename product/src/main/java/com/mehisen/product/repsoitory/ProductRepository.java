package com.mehisen.product.repsoitory;

import com.mehisen.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
