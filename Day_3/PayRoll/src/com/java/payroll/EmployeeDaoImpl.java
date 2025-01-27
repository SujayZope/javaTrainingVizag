package com.java.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDao {
	
	static List<Employee> employeeList;
    static  Scanner sc;

    static {
        employeeList = new ArrayList<Employee>();
        sc=new Scanner(System.in);
    }

    public int generateEmpNO(){
        int count=employeeList.size();
        if(count==0){
            return 1;
        }
        int empNo =employeeList.get(employeeList.size()-1).getEmpNo();
        empNo++;
        return empNo;
    }


    @Override
    public List<Employee> showEmployeeDao() {
        return  employeeList;
    }


    @Override
    public String addEmployeeDao(Employee employee) {
        int empNo=generateEmpNO();
        employee.setEmpNo(empNo);
        employee.setHra(employee.getSalary() * 0.03);
        employee.setDa(employee.getSalary() * 0.012);
        employee.setTa(employee.getSalary() * 0.01);
        employee.setTax(employee.getSalary() * 0.21);
        employee.setPf(employee.getSalary() * 0.23);
        employee.setGross(employee.getSalary() + employee.getHra() + employee.getDa() + employee.getTa());
        employee.setTakeHome(employee.getGross()-employee.getTax()-employee.getPf());
        employeeList.add(employee);
        return "Employ Record Added Successfully...";

    }


    public Employee searchEmployDao(int empno){
        Employee employFound=null;
        for(Employee employee:employeeList){
            if(employee.getEmpNo()==empno){
                employFound=employee;
                break;
            }
        }
        return employFound;
    }

}


