package com.excelr.shopping.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.shopping.dto.CustomerRequestDto;
import com.excelr.shopping.dto.CustomerResponseDto;
import com.excelr.shopping.model.Customer;
import com.excelr.shopping.model.CustomerAddress;
import com.excelr.shopping.model.Role;
import com.excelr.shopping.model.User;
import com.excelr.shopping.repository.CustomerRepository;
import com.excelr.shopping.repository.RoleRepository;
import com.excelr.shopping.repository.UserRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;

	public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

		Role userRole=roleRepository.findByRoleName("USER").orElseThrow(()->new RuntimeException("USER role not found"));
		
		User user = new User();
		user.setPassword(customerRequestDto.getCustomerPassword());
		user.setUserName(customerRequestDto.getCustomerEmail());
		user.setRoles(List.of(userRole));
		userRepository.save(user);
		

		Customer customer = modelMapper.map(customerRequestDto, Customer.class);
		customer.setUser(user);
		Customer savedCustomer = customerRepository.save(customer);

		return modelMapper.map(savedCustomer, CustomerResponseDto.class);

	}

	public CustomerResponseDto getCustomerById(int id) {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cannot Found Customer with id: " + id));

		return modelMapper.map(customer, CustomerResponseDto.class);

	}

	public CustomerResponseDto updateCustomerById(int id, CustomerRequestDto customerRequestDto) {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

		customer.setCustomerDob(customerRequestDto.getCustomerDob());
		customer.setCustomerEmail(customerRequestDto.getCustomerEmail());
		customer.setCustomerGender(customerRequestDto.getCustomerGender());
		customer.setCustomerName(customerRequestDto.getCustomerName());

		if (customerRequestDto.getCustomerAddress() != null) {

			// remove existing children
			customer.getCustomerAddress().clear();

			// map and add new children
			List<CustomerAddress> addressList = customerRequestDto.getCustomerAddress().stream()
					.map(dto -> modelMapper.map(dto, CustomerAddress.class)).toList();

			customer.getCustomerAddress().addAll(addressList);
		}

		Customer savedCustomer = customerRepository.save(customer);

		return modelMapper.map(savedCustomer, CustomerResponseDto.class);

	}

	public String deleteCustomerById(int id) {

		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return new String("Customer with id " + id + " deleted successfully");
		}
		return new String("Customer with id " + id + " NOT Found");
	}

}
