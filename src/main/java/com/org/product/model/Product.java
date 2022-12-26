package com.org.product.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value  = "product")
public class Product {
	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	//private double discount;
	

	//private Category category;
	
//	private List<String> imageURLs;
	

}
