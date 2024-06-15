package com.drive.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.drive.model.User;
import com.drive.utils.SQLUtils;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertUser; 

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate; 
        this.insertUser = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }


    public User getUserByEmail(String email){
        String stmt = "Select * From users where email = ?"; 
        stmt = SQLUtils.preparedStatement(stmt, email);
        List<User> users = jdbcTemplate.query(stmt, (rs, rowNum) -> mapRowToUser(rs, rowNum));
        if(users.size() == 0){
            return null;
        }
        return users.get(0); 
    }

    public int addUser(User user){
        String stmt = "Insert into users (name, email, password) values (?, ?, ?)";
        stmt = SQLUtils.preparedStatement(stmt, user.getName(), user.getEmail(), user.getPassword());
        return jdbcTemplate.update(stmt);
    }

    public int updateUser(User user){
        String stmt = "Update users set name=?, email=?, password=?, imageUrl=?, joinedAt=?, updatedAt=?, lastSeen=?, usedStorage=?, planId=? where id=?";
        stmt = SQLUtils.preparedStatement(stmt, user.getName(), user.getEmail(), user.getPassword(), user.getImageUrl(), user.getJoinedAt(), user.getUpdatedAt(), user.getLastSeen(), user.getUsedStorage(), user.getPlanId(), user.getId());
        return jdbcTemplate.update(stmt);
    }

    public int deleteUser(Long id){
        String stmt = "Delete From users where id = " + id + ";"; 
        return jdbcTemplate.update(stmt); 
    }

    public User mapRowToUser(ResultSet rs, int rowNum) throws SQLException{
        User user = new User(); 
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setImageUrl(rs.getString("imageUrl"));
        user.setJoinedAt(rs.getTimestamp("joinedAt"));
        user.setUpdatedAt(rs.getTimestamp("updatedAt"));
        user.setLastSeen(rs.getTimestamp("lastSeen"));
        user.setUsedStorage(rs.getDouble("usedStorage"));
        user.setPlanId(rs.getLong("planId"));
        return user; 
    }
}
