package com.ibmz.watsonxLeave.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ibmz.watsonxLeave.annotation.AuthVerify;
import com.ibmz.watsonxLeave.dto.LeaveBalanceInfo;
import com.ibmz.watsonxLeave.pojo.Employee;
import com.ibmz.watsonxLeave.pojo.LeaveBalance;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
@RequestMapping(value = "/balance/{id}", method = RequestMethod.GET)
public String queryUserBalance(@PathVariable("id") Integer id) throws SQLException, ClassNotFoundException {
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

    sql = "select * from LeaveType";
    resultSet = stmt.executeQuery(sql);
    HashMap<Integer, String> leaveTypeMap = new HashMap<>();
    while (resultSet.next()) {
        leaveTypeMap.put(resultSet.getInt("leavetypeId"), resultSet.getString("leavetypeName"));
    }
    sql = "select * from LeaveBalance where employeeID=  "+id;
    resultSet = stmt.executeQuery(sql);
    ArrayList<LeaveBalanceInfo> leaveBalanceInfos = new ArrayList<>();
    while (resultSet.next()) {
        LeaveBalanceInfo leaveBalanceInfo = new LeaveBalanceInfo();
        leaveBalanceInfo.setBalanceID(resultSet.getInt("balanceID"));
        leaveBalanceInfo.setEmployeeName(employee.getFirstname() + employee.getLastname());
        int leaveTypeID = resultSet.getInt("leaveTypeID");
        leaveBalanceInfo.setLeavetypeName(leaveTypeMap.get(leaveTypeID));
        leaveBalanceInfo.setEntitlement(resultSet.getInt("entitlement"));
        leaveBalanceInfo.setUsedDays(resultSet.getInt("usedDays"));
        leaveBalanceInfo.setRemainingDays(resultSet.getInt("remainingDays"));
        leaveBalanceInfo.setTotalBookedForFuture(resultSet.getInt("totalBookedForFuture"));
        leaveBalanceInfo.setYear(resultSet.getInt("year"));
        leaveBalanceInfos.add(leaveBalanceInfo);
    }
    String jsonString = JSON.toJSONString(leaveBalanceInfos);
    return jsonString;
}


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
@AuthVerify
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Employee queryUser(@RequestBody String param) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:db2://19af6446-6171-4641-8aba-9dcff8e1b6ff.c1ogj3sd0tgtu0lqde00.databases.appdomain.cloud:30699/bludb:user=vrn32906;password=o5Nwlh3rbavWaXVs;sslConnection=true;" );
        Statement stmt = conn.createStatement();

        JSONObject jsonObject = JSON.parseObject(param);

        int id = jsonObject.getIntValue("userid");


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