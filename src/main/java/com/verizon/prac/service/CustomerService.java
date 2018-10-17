package com.verizon.prac.service;

import java.util.List;

import com.verizon.prac.models.Customer;

public interface CustomerService {
	
	Customer getCustomerById(Integer custId);
	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
	boolean deleteCustomer(Integer custId);

}
