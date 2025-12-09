package com.excelr.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.excelr.shopping.model.Product;
import com.excelr.shopping.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}

	public List<Product> addProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
}
