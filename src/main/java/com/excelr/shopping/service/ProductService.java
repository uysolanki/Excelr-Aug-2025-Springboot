package com.excelr.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getSingleProduct(int pid) 
	{
		Optional<Product> optionalProduct=productRepository.findById(pid);
		Product product=null;
		if(optionalProduct.isPresent())
		{
			product=optionalProduct.get();
			return product;
		}
		
		throw new RuntimeException("Product Not Found");
	}

	public List<Product> getProductByCategory(String category) {
		return productRepository.findByCategoryContaining(category);
	}

	public List<Product> getProductByPricegreaterthan(double basePrice) {
		return productRepository.findByPriceGreaterThanEqual(basePrice);
	}
	
}
