package com.drive.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.model.Plan;
import com.drive.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanService planService; 

    @Autowired
    public PlanController(PlanService planService){
        this.planService = planService; 
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllPlans(){
        List<Plan>plans = planService.getAllPlans();
        Map<String, Object> response = new HashMap<>(); 
        response.put("total", plans.size()); 
        response.put("plans", plans); 
        return ResponseEntity.ok(response); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id){
        Plan plan = planService.getPlanById(id);
        if(plan == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(plan);
    }

    @PostMapping("")
    public ResponseEntity<Object> addPlan(@RequestBody Plan plan){
        Map<String, Object> response = new HashMap<>(); 
        Plan addedPlan = planService.addPlan(plan);
        if(addedPlan == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        response.put("plan", addedPlan);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    
}
