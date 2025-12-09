package com.excelr.shopping.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/add-product-by-requestparam")
	public Product addProductByRequestParam(@RequestParam("a") String pTtitle,
			@RequestParam("b") double pPrice,
			@RequestParam("c") String pDesc,
			@RequestParam("d") String pCat,
			@RequestParam("e") String pImage,
			@RequestParam("f") double pRate,
			@RequestParam("g") int pCount
			)
	{
		Product product=Product.builder()
				.title(pTtitle)
				.description(pDesc)
				.price(pPrice)
				.category(pCat)
				.image(pImage)
				.rating(Rating.builder().rate(pRate).count(pCount).build())
				.build();
		
		return productService.addProduct(product);
		//return "Product Addedd Successfully";
	}
	
	
	@PostMapping("/add-product-by-pathvariable/{a}/{b}/{c}/{d}/{e}/{f}/{g}")
	public Product addProductByPathVariable(@PathVariable("a") String pTtitle,
			@PathVariable("b") double pPrice,
			@PathVariable("c") String pDesc,
			@PathVariable("d") String pCat,
			@PathVariable("e") String pImage,
			@PathVariable("f") double pRate,
			@PathVariable("g") int pCount
			)
	{
		Product product=Product.builder()
				.title(pTtitle)
				.description(pDesc)
				.price(pPrice)
				.category(pCat)
				.image(pImage)
				.rating(Rating.builder().rate(pRate).count(pCount).build())
				.build();
		
		return productService.addProduct(product);
		//return "Product Addedd Successfully";
	}
	
	
	@PostMapping("/add-product-by-pathvariable1/{pTtitle}/{pPrice}/{pDesc}/{pCat}/{pImage}/{pRate}/{pCount}")
	public Product addProductByPathVariable1(@PathVariable String pTtitle,
			@PathVariable double pPrice,
			@PathVariable String pDesc,
			@PathVariable String pCat,
			@PathVariable String pImage,
			@PathVariable double pRate,
			@PathVariable int pCount
			)
	{
		Product product=Product.builder()
				.title(pTtitle)
				.description(pDesc)
				.price(pPrice)
				.category(pCat)
				.image(pImage)
				.rating(Rating.builder().rate(pRate).count(pCount).build())
				.build();
		
		return productService.addProduct(product);
		//return "Product Addedd Successfully";
	}
	
	
	@PostMapping("/add-product-by-requestbody")
	public Product addProductByRequestBody(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@PostMapping("/add-multiple-product-by-requestbody")
	public List<Product> addMutipleProductByRequestBody(@RequestBody List<Product> products)
	{
		return productService.addProducts(products);
	}
	
	//***************************
	
	
	@GetMapping("/get-all-products")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	
	@GetMapping("/get-single-product/{pid}")
	public Product getSingleProduct(@PathVariable int pid)
	{
		return productService.getSingleProduct(pid);
	}
}


/*
 {
    "id": 6,
    "title": "Mens Casual Slim Fit",
    "price": 15.99,
    "description": "The color could be slightly different between on the screen and in practice",
    "category": "men's clothing",
    "image": "myimage1.png",
    "rating": {
        "rid": 6,
        "rate": 2.1,
        "count": 430
    }
}
*/
