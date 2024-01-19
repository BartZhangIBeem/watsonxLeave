package com.ibmz.watsonxLeave.controller;

import com.ibm.db2.jcc.DB2ConnectionPoolDataSource;
import com.ibmz.watsonxLeave.dto.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.PooledConnection;
import java.sql.*;

@RestController

@RequestMapping("/query")

public class queryCtrl {
//    @Autowired
//    UserDao userDao;
//    @RequestMapping(value = "/user/{id}",method= RequestMethod.GET)
//    public Employee queryUserBalance(@PathVariable ("id") int id){
//        Employee employee = userDao.getEmployee(id);
//        return employee;
//        }
//
//    }



    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Employee queryUser(@PathVariable("id") Integer id) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:db2://19af6446-6171-4641-8aba-9dcff8e1b6ff.c1ogj3sd0tgtu0lqde00.databases.appdomain.cloud:30699/bludb:user=vrn32906;password=o5Nwlh3rbavWaXVs;sslConnection=true;" );
        Statement stmt = conn.createStatement();
        String sql = "select * from EMPLOYEE where EMPLOYEEID= "+id;
        ResultSet resultSet = stmt.executeQuery(sql);
        Employee employee = new Employee();
        if (resultSet.next()) {
            employee.setFirstname(resultSet.getString("firstname"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setPosition(resultSet.getString("position"));
            employee.setLastname(resultSet.getString("lastname"));
            employee.setHiredate(resultSet.getDate("hiredate"));
        }
        employee.setEmpId(id);
        return employee;
    }
//    @Autowired
//    private EmployeeRepository repository;

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public Employee queryUserBalance(@PathVariable("id") int id) {
//        Optional<Employee> employee = repository.findById(id);
//        return employee.get();
//    }
}