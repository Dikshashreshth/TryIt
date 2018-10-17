package com.verizon.prac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.prac.dao.PlanDAO;
import com.verizon.prac.models.Plan;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanDAO planDAO;

	@Override
	public Plan getPlanByTitle(String title) {
		Plan plan = null;
		
		Optional<Plan> optContact =planDAO.findById(title);
		if(optContact.isPresent()) {
			plan = optContact.get();
		}
		
		return plan;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planDAO.findAll();
	}

	@Override
	public Plan addPlan(Plan plan) {
		return planDAO.save(plan);
	}

	@Override
	public boolean existsByNetSpeed(Double netSpeed) {
		return planDAO.existsByNetSpeed(netSpeed);
	}

	@Override
	public boolean existsByMaxUsage(Double maxUsage) {
		return planDAO.existsByMaxUsage(maxUsage);
	}

	@Override
	public boolean existsByCharge(Double charge) {
		return planDAO.existsByCharge(charge);
	}

	@Override
	public Plan findByNetSpeed(Double netSpeed) {
		return planDAO.findByNetSpeed(netSpeed);
	}

	@Override
	public Plan findByMaxUsage(Double maxUsage) {
		return planDAO.findByMaxUsage(maxUsage);
	}

	@Override
	public Plan findByCharge(Double charge) {
		return planDAO.findByCharge(charge);
	}

}
