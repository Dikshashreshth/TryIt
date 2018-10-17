package com.verizon.prac.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plans")
public class Plan {
	
	@Id
	private String title;
	private Double netSpeed;
	private Double maxUsage;
	private Double charge;
	
	public Plan() {
		
	}

	public Plan(String title, Double netSpeed, Double maxUsage, Double charge) {
		this.title = title;
		this.netSpeed = netSpeed;
		this.maxUsage = maxUsage;
		this.charge = charge;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getNetSpeed() {
		return netSpeed;
	}

	public void setNetSpeed(Double netSpeed) {
		this.netSpeed = netSpeed;
	}

	public Double getMaxUsage() {
		return maxUsage;
	}

	public void setMaxUsage(Double maxUsage) {
		this.maxUsage = maxUsage;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "Plan [title=" + title + ", netSpeed=" + netSpeed + ", maxUsage=" + maxUsage + ", charge=" + charge
				+ "]";
	}


}
