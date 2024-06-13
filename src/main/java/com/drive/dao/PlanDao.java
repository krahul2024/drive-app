package com.drive.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drive.model.Plan;
import com.drive.utils.SQLUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDao {
    
    private JdbcTemplate jdbcTemplate; 
    private SimpleJdbcInsert insertIntoPlan; 

    @Autowired
    public PlanDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate; 
        this.insertIntoPlan = new SimpleJdbcInsert(jdbcTemplate).withTableName("plans").usingGeneratedKeyColumns("id");
    }   

    public List<Plan> getPlans(int size, int page){
        String stmt = "Select * From plans limit " + size +  " offset " + page * size; 
        return jdbcTemplate.query(stmt, (rs, rowNum) -> mapRowToPlan(rs, rowNum));
    }

    public Plan getPlanById(Long id){
        String stmt = "Select * From plans where id = ?"; 
        stmt = SQLUtils.preparedStatement(stmt,id);
        try {
            return jdbcTemplate.queryForObject(stmt,(rs, rowNum) -> mapRowToPlan(rs, rowNum));
        } catch(EmptyResultDataAccessException e) {
            return null; 
        }
        // we can also use the multiple query part and then check for empty list of plans and handle accordingly
    }   

    public Long addPlan(Plan plan){
        final Map<String, Object> params = new HashMap<>(); 
        params.put("name", plan.getName());
        params.put("storageQuota", plan.getStorageQuota());
        params.put("price", plan.getPrice());
        params.put("maxFileSize", plan.getMaxFileSize());
        params.put("numUsers", plan.getNumUsers());
        return insertIntoPlan.executeAndReturnKey(params).longValue();
    }

    public int updatePlan(Plan plan){
        String stmt = "Update plans set name=?, storageQuota=?, price=?, maxFileSize=?, numUsers=? where id=?";
        stmt = SQLUtils.preparedStatement(stmt, plan.getName(), plan.getStorageQuota(), plan.getPrice(), plan.getMaxFileSize(), plan.getNumUsers(), plan.getId());
        return jdbcTemplate.update(stmt); 
    }

    public int deletePlan(Long id){
        String stmt = "Delete From plans where id = ?";
        stmt = SQLUtils.preparedStatement(stmt, id);
        return jdbcTemplate.update(stmt);
    }






    public Plan mapRowToPlan(ResultSet rs, int index) throws SQLException {
        Plan plan = new Plan(); 
        plan.setId(rs.getLong("id"));
        plan.setName(rs.getString("name"));
        plan.setPrice(rs.getInt("price"));
        plan.setStorageQuota(rs.getInt("storageQuota"));
        plan.setMaxFileSize(rs.getInt("maxFileSize"));
        plan.setNumUsers(rs.getInt("numUsers"));
        return plan; 
    }


}