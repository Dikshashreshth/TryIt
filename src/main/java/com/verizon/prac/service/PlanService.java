package com.verizon.prac.service;

import java.util.List;

import com.verizon.prac.models.Plan;

public interface PlanService {
	
	Plan getPlanByTitle(String title);
	List<Plan> getAllPlans();
	Plan addPlan(Plan plan);
	
	boolean existsByNetSpeed(Double netSpeed);
	boolean existsByMaxUsage(Double maxUsage);
	boolean existsByCharge(Double charge);
	
	Plan findByNetSpeed(Double netSpeed);
	Plan findByMaxUsage(Double maxUsage);
	Plan findByCharge(Double charge);

}
