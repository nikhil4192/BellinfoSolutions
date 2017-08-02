package com.bellinfo.spring.annotation.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {
	
	  
    public static final String INSERT_STUDENT_QUERY ="INSERT INTO STUDENT(name) VALUES (?)";
    public static final String FIND_STUDENT_QUERY ="SELECT * FROM STUDENT";
    
    @Autowired
    public JdbcTemplate jdbcTemplate;
     
    public void save(String name){
        jdbcTemplate.update(INSERT_STUDENT_QUERY,name);
         
    }

    public List<String> findAll(){
        
        List<Map<String, Object>>  rows= jdbcTemplate.queryForList(FIND_STUDENT_QUERY);
        ArrayList<String> list = new ArrayList<String>();
        for(Map row:rows){
            list.add((String)row.get("name"));
        }
         
        return list;
         
    }
}
