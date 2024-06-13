package com.drive.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drive.model.Plan;
import com.drive.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final String url = "http://localhost:4000";
    private final PlanService planService; 

    @Autowired
    public PlanController(PlanService planService){
        this.planService = planService; 
    }

    @GetMapping("")
    public ResponseEntity<Object> getPlans(
        @RequestParam(name = "page", defaultValue = "0") int page, 
        @RequestParam(name = "size", defaultValue = "2") int size
    ){
        List<Plan>plans = planService.getPlans(size, page);
        Map<String, Object> response = new HashMap<>(); 
        response.put("total", plans.size()); 
        response.put("plans", plans);
        if(plans.size() == size) response.put("nextPage", url + "/plans?" + "page=" + (page + 1) + "&size=" + size);
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlan(@PathVariable Long id , @RequestBody Plan plan){
        Map<String, Object> response = new HashMap<>(); 
        plan.setId(id);
        Plan updatedPlan = planService.updatePlan(plan);
        if(updatedPlan == null){
            response.put("message", "Plan with id " + id + " not found");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } 
        response.put("message", "Plan with id " + id + " updated successfully");
        response.put("plan", updatedPlan);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlan(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>(); 
        int numRows = planService.deletePlan(id); 
        if(numRows == 0){
            response.put("message", "Plan with id " + id + " not found");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("message", "Plan with id " + id + " deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
}

/*
    Add Plan -> done 
    Get Plan -> done 
    Get All Plans -> done 
    Get Plans using pagination -> done
    Update plan -> done
    Delete plan -> done
    Batch update plan
    Batch Add plan 
 */