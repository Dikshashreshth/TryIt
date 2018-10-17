package com.verizon.prac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.prac.models.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	

}
