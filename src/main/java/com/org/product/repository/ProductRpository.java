package com.org.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.product.model.Product;

@Repository
public interface ProductRpository extends MongoRepository<Product, String>{

}
