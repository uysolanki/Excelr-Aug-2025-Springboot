package com.excelr.shopping.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@ToString
public class Customer  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerID;
	
	private String customerName;
	private LocalDate customerDob;
	private String customerGender;
	private String customerEmail;
	private String customerPassword;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name = "customerID", referencedColumnName = "customerID")
	List<CustomerAddress> customerAddress;
	

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
