package com.ibmz.watsonxLeave.dao;

import com.ibmz.watsonxLeave.dto.Employee;

public interface UserDao {
    Employee getEmployee(int id);
}
