package com.excelr.shopping.dto;

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
public class CustomerAddressRequestDto {
	
	private int houseNumber;
	private String street;
	private String city;
	private String state;
	private int pinCode;

}
