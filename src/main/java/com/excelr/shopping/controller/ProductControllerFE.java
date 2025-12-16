package com.excelr.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.shopping.model.Product;
import com.excelr.shopping.service.ProductService;

@Controller
@RequestMapping("/amazon")
public class ProductControllerFE {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/greet")
	public String greet()
	{
		return "virat";
	}
	
	@RequestMapping("/add-product-form")
	public String addProductForm(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "add-product-form";
	}
	
	@PostMapping("/add-product")
	public String addProductForm(@ModelAttribute Product product)
	{
		productService.addProduct(product);
		return "redirect:/amazon/all-products";
	}
	
	@RequestMapping("/all-products")
	public String allProducts(Model model)
	{
		List<Product> products=productService.getAllProducts();
		model.addAttribute("products",products);
		return "all-products";
	}
	
	@RequestMapping("/delete-product/{pid}")
	public String deleteProduct(@PathVariable int pid)
	{
		productService.deleteProduct(pid);
		return "redirect:/amazon/all-products";
	}
	
	@RequestMapping("/update-product-form/{pid}")
	public String updateProductForm(@PathVariable int pid, Model model)
	{
		Product product=productService.getSingleProduct(pid);
		model.addAttribute("product",product);
		return "update-product-form";
		
	}
	
	@PostMapping("/update-product/{prodId}")
	public String updateProduct(@PathVariable int prodId,@ModelAttribute Product newValues)
	{
		productService.updateProduct(prodId,newValues);
		return "redirect:/amazon/all-products";
	}
	
}

