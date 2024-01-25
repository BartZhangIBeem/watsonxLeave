package com.ibmz.watsonxLeave.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalance {

    private Integer balanceID;
    private Integer employeeID;
    private Integer leaveTypeID;
    private Integer entitlement;
    private Integer usedDays;
    private Integer remainingDays;
    private Integer totalBookedForFuture;
    private Integer year;
}