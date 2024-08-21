package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class employeeservice {

    @Autowired
    private JdbcTemplate jt;

    public int insertEmployee(employeedata data) {
        String sql = "INSERT INTO employee(name, age, dob, department, year) VALUES (?, ?, ?, ?, ?)";
        return jt.update(sql, 
                                  data.getName(), 
                                  data.getAge(), 
                                  data.getDob(), 
                                  data.getDepartment(), 
                                  data.getYear());
    }
    public List<Map<String,Object>> select(employeedata e)
    {
    	String sql="select * from employee";
    	List<Map<String,Object>> h=jt.queryForList(sql);
    	return h;
    }
    public int update(employeedata e)
    {
    	String name=e.getName();
    	int age=e.getAge();
    	String sql="update employee set age=? where name=?";
    	int i=jt.update(sql,e.getName(),e.getAge());
    	return i;
    }
}
