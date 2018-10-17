package com.verizon.prac.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.prac.models.Plan;
import com.verizon.prac.service.PlanService;

@RestController
@CrossOrigin
@RequestMapping("/plans")
public class RestAPI {
	
	@Autowired
	private PlanService planService;
	
	
	@GetMapping
	public ResponseEntity<List<Plan>> getAllPlans() {
		return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{title}")
	public ResponseEntity<Plan> getPlanById(@PathVariable("title") String title) {
		ResponseEntity<Plan> resp;
		Plan c = planService.getPlanByTitle(title);     
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Plan> addContact(@RequestBody Plan plan) {
		ResponseEntity<Plan> resp = null;


		if (resp == null) {
			Plan c = planService.addPlan(plan);		
			if (c == null)
				resp = new ResponseEntity<Plan>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Plan>(c, HttpStatus.OK);
		}
		return resp;
	}
	
	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Plan>> getAllContacts(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") Double searchValue) {

		ResponseEntity<List<Plan>> resp;

		switch (fieldBy) {
		case "netSpeed":
			Plan cByNetSpeed = planService.findByNetSpeed(searchValue);		
			if (cByNetSpeed != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByNetSpeed), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "maxUsage":
			Plan cByMaxUsage = planService.findByMaxUsage(searchValue);
			if (cByMaxUsage != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByMaxUsage), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "charge":
			Plan cByCharge = planService.findByCharge(searchValue);
			if (cByCharge != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByCharge), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			break;
		}

		return resp;
	}

}
