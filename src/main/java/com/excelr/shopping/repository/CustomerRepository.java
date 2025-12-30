package com.excelr.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.shopping.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
