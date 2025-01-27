package com.java.payroll;

public class Employee {

    private int empNo;
    private String firstName;
    private String lastName;
    private double salary;
    private  int leaveAvail;
    private double   hra;
    private double da;
    private double ta;
    private double tax;
    private double pf;
    private double gross;
    private double takeHome;
    private LeaveDetails leave;

    
    public LeaveDetails getLeave() {
        return leave;
    }

    
    public void setLeave(LeaveDetails leave) {
        this.leave = leave;
    }

    
    public Employee() {

    }

    public Employee(int empNo, String firstName, String lastName, double salary, int leaveAvail, double hra, double da, double ta, double tax, double pf, double gross, double takeHome) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.leaveAvail = leaveAvail;
        this.hra = hra;
        this.da = da;
        this.ta = ta;
        this.tax = tax;
        this.pf = pf;
        this.gross = gross;
        this.takeHome = takeHome;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLeaveAvail() {
        return leaveAvail;
    }

    public void setLeaveAvail(int leaveAvail) {
        this.leaveAvail = leaveAvail;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getTa() {
        return ta;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getTakeHome() {
        return takeHome;
    }

    public void setTakeHome(double takeHome) {
        this.takeHome = takeHome;
    }


    @Override
    public String toString() {
        return "\nPay Slip\n" +"------------------------"+
                "Employee No=" + empNo +"------------------------"+
                "\n First Name  =  " + firstName + 
                "\n Last  Name  =  " + lastName  
                +"\n---------------------------------------------------------------\n\t\t  "+ 
                "Salary\t=\t" + salary +
                "\n\t\t  Leave Avail\t=\t" + leaveAvail +
                "\n\t\t  HRA\t\t=\t" + hra +
                "\n\t\t  DA\t\t=\t" + da +
                "\n\t\t  TA\t\t=\t" + ta +
                "\n\t\t  Tax\t\t=\t" + tax +
                "\n\t\t  PF\t\t=\t" + pf +
                "\n\t\t  Gross\t\t=\t" + gross +
                "\n\t\t  Take Home\t=\t" + takeHome+"\n\t\t  Loss of Pay\t=\t"
                +leave.getLossOfPay()+"\n\t\t  Leave Taken\t=\t"
                +leave.getLeaveTaken()
                +"\n----------------------------------------------------------------" ;
    }
}

