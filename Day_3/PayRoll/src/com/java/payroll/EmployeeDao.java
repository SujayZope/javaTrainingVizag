package com.java.payroll;

import java.util.List;

public interface EmployeeDao {
    List<Employee> showEmployeeDao();
    String addEmployeeDao(Employee employee);
    Employee searchEmployDao(int empno);
    
}

