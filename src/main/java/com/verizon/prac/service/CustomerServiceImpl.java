package com.verizon.prac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.prac.dao.CustomerDAO;
import com.verizon.prac.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer getCustomerById(Integer custId) {
		Customer customer=null;
		
		Optional<Customer> optContact =customerDAO.findById(custId);
		if(optContact.isPresent()) {
			customer = optContact.get();
		}
		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public boolean deleteCustomer(Integer custId) {
		boolean isDeleted=false;
		if(customerDAO.existsById(custId)) {
			customerDAO.deleteById(custId);
			isDeleted=true;
		}
		return isDeleted;
	}

}
