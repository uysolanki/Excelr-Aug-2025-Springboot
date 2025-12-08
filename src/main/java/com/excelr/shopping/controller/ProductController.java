package com.excelr.shopping.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.shopping.model.Product;
import com.excelr.shopping.model.Rating;
import com.excelr.shopping.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/greet")
	public String greet()
	{
		return "welcome to Spring boot";
	}
	
	@RequestMapping("/product")
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
	
	@RequestMapping("/productList")
	public List<Product> productList()
	{
		Product product1=Product.builder()
				.title("laptop")
				.description("Dell latitude 512GB SSD 16 GB RAM 1 TB Storage")
				.price(1000.0)
				.rating(Rating.builder().rate(4.5).count(1000).build())
				.build();
		
		Product product2=Product.builder()
				.title("mobile")
				.description("One Plus 512GB SSD 16 GB RAM 1 TB Storage")
				.price(800.0)
				.rating(Rating.builder().rate(4.5).count(1000).build())
				.build();
		
		Product product3=Product.builder()
				.title("TV")
				.description("LG LED TV")
				.price(1200.0)
				.rating(Rating.builder().rate(4.5).count(1000).build())
				.build();
		List<Product> products=new ArrayList(Arrays.asList(product1,product2,product3));
		return products;
	}
	
	@PostMapping("/add-product")
	public String addProduct()
	{
		Product product=Product.builder()
				.title("laptop")
				.description("Dell latitude 512GB SSD 16 GB RAM 1 TB Storage")
				.price(1000.0)
				.rating(Rating.builder().rate(4.5).count(1000).build())
				.build();
		
		productService.addProduct(product);
		return "Product Addedd Successfully";
	}
}
