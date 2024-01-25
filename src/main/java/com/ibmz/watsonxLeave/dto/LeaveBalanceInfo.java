package com.ibmz.watsonxLeave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalanceInfo {

    private Integer balanceID;
    private String employeeName;
    private String leavetypeName;
    private Integer entitlement;
    private Integer usedDays;
    private Integer remainingDays;
    private Integer totalBookedForFuture;
    private Integer year;
}