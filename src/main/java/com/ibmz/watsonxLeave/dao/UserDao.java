package com.ibmz.watsonxLeave.dao;

import com.ibmz.watsonxLeave.pojo.Employee;

public interface UserDao {
    Employee getEmployee(int id);
}
