package com.excelr.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.shopping.dto.CustomerRequestDto;
import com.excelr.shopping.dto.CustomerResponseDto;
import com.excelr.shopping.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/add-Customer-by-dto")
	public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto CustomerDto){
		
		return new ResponseEntity<CustomerResponseDto>(customerService.addCustomer(CustomerDto), HttpStatus.OK);
	}
	
	@GetMapping("/get-Customer-dto-by-id/{id}")
	public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable int id){
		
		return new ResponseEntity<CustomerResponseDto>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update-Customer-dto-by-id/{id}")
	public ResponseEntity<CustomerResponseDto> updateCustomerById(@PathVariable int id, @RequestBody CustomerRequestDto customerRequestDto){
		
		return new ResponseEntity<CustomerResponseDto>(customerService.updateCustomerById(id,customerRequestDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-Customer-by-id/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id){
		
		return new ResponseEntity<String>(customerService.deleteCustomerById(id), HttpStatus.OK);
	}
	

}
