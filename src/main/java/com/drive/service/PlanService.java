package com.drive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drive.dao.PlanDao;
import com.drive.model.Plan;

@Service
public class PlanService {
    private PlanDao planDao; 
    
    @Autowired 
    public PlanService(PlanDao planDao){
        this.planDao = planDao; 
    }

    public List<Plan> getPlans(int size, int page){
        return planDao.getPlans(size, page);
    }

    public Plan getPlanById(Long id){
        return planDao.getPlanById(id);
    }

    @Transactional
    public Plan addPlan(Plan plan){
        Long planId = planDao.addPlan(plan); 
        Plan newPlan = planDao.getPlanById(planId); 
        return newPlan;
    }

    public Plan updatePlan(Plan plan){
        int numRows = planDao.updatePlan(plan);
        if(numRows == 0){
            return null;
        } else {
            return planDao.getPlanById(plan.getId());
        }
    }

    public int deletePlan(Long id){
        return planDao.deletePlan(id);
    }

}

