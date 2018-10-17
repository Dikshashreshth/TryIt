package com.verizon.prac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.prac.models.Plan;

@Repository
public interface PlanDAO extends JpaRepository<Plan, String>{
	
	boolean existsByNetSpeed(Double netSpeed);
	boolean existsByMaxUsage(Double maxUsage);
	boolean existsByCharge(Double charge);
	
	Plan findByNetSpeed(Double netSpeed);
	Plan findByMaxUsage(Double maxUsage);
	Plan findByCharge(Double charge);

}
