package com.java.payroll;

import java.util.List;

public interface LeaveDao {

    public List<LeaveDetails> showEmployeeDao() ;
    public String addLeaveDao(LeaveDetails leave,Employee emp);
        
}

