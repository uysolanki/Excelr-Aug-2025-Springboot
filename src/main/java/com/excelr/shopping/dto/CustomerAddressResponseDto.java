package com.excelr.shopping.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString
public class CustomerAddressResponseDto {
	
	private int houseNumber;
	private String street;
	private String city;
	private String state;
	private int pinCode;

}
