package com.verizon.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.prac.models.Customer;
import com.verizon.prac.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerAPI {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> resp = null;

		if (resp == null) {
			Customer c = customerService.addCustomer(customer);		
			if (c == null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return resp;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") Integer custId) {
		ResponseEntity<Void> resp = null;

		if (customerService.deleteCustomer(custId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}

}
