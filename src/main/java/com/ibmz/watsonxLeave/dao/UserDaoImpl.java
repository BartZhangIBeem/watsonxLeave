//package com.ibmz.watsonxLeave.dao;
//
//import com.ibmz.watsonxLeave.dto.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    @Transactional
//    public Employee getEmployee(int id) {
//        String sql="select * from employee where employeeid =(?)";
//        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
//        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
//
//    }
//}
