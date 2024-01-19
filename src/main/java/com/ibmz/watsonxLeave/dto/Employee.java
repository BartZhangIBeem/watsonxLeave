package com.ibmz.watsonxLeave.dto;

//import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor

//@Table(name = "EMPLOYEE", schema = "vrn32906")
public class Employee {
    private Integer empId;
    private String firstname;
    private String lastname;
    private String department;
    private String position;
    private Date hiredate;
}
