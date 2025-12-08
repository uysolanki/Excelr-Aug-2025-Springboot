package com.excelr.shopping.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.shopping.model.Product;
import com.excelr.shopping.model.Rating;

@RestController
public class ProductController {

	@RequestMapping("/greet")
	public String greet()
	{
		return "welcome to Spring boot";
	}
	
	@RequestMapping("/greet1")
	public Product greet1()
	{
		Product product=Product.builder()
				.title("laptop")
				.description("Dell latitude 512GB SSD 16 GB RAM 1 TB Storage")
				.price(1000.0)
				.rating(Rating.builder().rate(4.5).count(1000).build())
				.build();
		
		return product;
	}
}
