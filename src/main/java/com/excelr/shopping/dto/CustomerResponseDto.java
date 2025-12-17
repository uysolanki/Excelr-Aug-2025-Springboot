package com.excelr.shopping.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class CustomerResponseDto {
	
	private String customerName;
	private LocalDate customerDob;
	private String customerGender;
	private String customerEmail;
	private String customerPassword;
	
	List<CustomerAddressResponseDto> customerAddress;

}
