package com.verizon.prac.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	private Integer custId;
	private String name;
	private String number;
	private String address;
	private String timeSlot;
	private String title;
	
	public Customer() {
		
	}

	public Customer(Integer custId, String name, String number, String address, String timeSlot, String title) {
		this.custId = custId;
		this.name = name;
		this.number = number;
		this.address = address;
		this.timeSlot = timeSlot;
		this.title = title;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", number=" + number + ", address=" + address
				+ ", timeSlot=" + timeSlot + ", title=" + title + "]";
	}
	
	

}
