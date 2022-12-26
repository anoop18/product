package com.org.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.org.product.dto.ProductRequest;
import com.org.product.dto.ProductResponse;
import com.org.product.model.Product;
import com.org.product.repository.ProductRpository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	
	private final ProductRpository productRpository;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public void createProduct(ProductRequest productRequest) {
		Product  product = Product.builder()
				          .name(productRequest.getName())
				          .description(productRequest.getDescription())
				          .price(productRequest.getPrice())
				          .build();
		productRpository.save(product);
		log.info("Product {} is saved",product.getId());
	}

	public List<ProductResponse> getAllProduct() {
		List<Product> products = productRpository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		
	}

}
