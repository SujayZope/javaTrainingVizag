package com.infinite.LeaveManagSys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeaveBAL {
	
	static LeaveDAO dao;
	static Date today;
	static Date yesterday;
	LeaveDetails e;
	static StringBuilder sb;
	
	
	static{
		dao =new LeaveDaoImpl();
		today=new Date();
		sb=new StringBuilder();
	}
	
	public boolean doValidation(LeaveDetails e){
		boolean isValid=true;
		
		if((e.getLeaveStartDate().before(today))){
			sb.append("leave start date cannot be yeterday");
			isValid=false;
		}
		if(e.getLeaveEndDate().before(today)){
			sb.append("leave end date cannont be before today");
			isValid=false;
		}
		if(e.getLeaveEndDate().before(e.getLeaveStartDate())){
			sb.append("leave start date cannot be greater than leave end date ");
			isValid=false;
		}
		if(e.getLeaveStartDate().after(e.getLeaveEndDate())){
			
			isValid=false;
		}
		return isValid;	
	}
	
	
	public String addLeaveBal(LeaveDetails e) throws EmployeeException, ParseException{
		
		if(!doValidation(e)){
			
			throw new EmployeeException(sb.toString());
			
		}
		int temp=getNoofDays(e);
		e.setLeaveAppliedOn(new Date());
		e.setNoOfDays(temp);
		return dao.addLeaveDao(e);
	
	}
	
	
	public String updateLeaveBal(LeaveDetails e) throws EmployeeException, ParseException{
		
		if(!doValidation(e)){
			throw new EmployeeException(sb.toString());
		}
		int temp=getNoofDays(e);
		e.setLeaveAppliedOn(new Date());
		e.setNoOfDays(temp);
		return dao.updateLeaveDao(e);
			
	}
	
	

	public int getNoofDays(LeaveDetails  ld) throws ParseException{
		int holidays=0;
		long off=count(ld.getLeaveStartDate(),ld.getLeaveEndDate());
		return (int)off+1;
		
		}


	public long count(Date start, Date end) {
		 Calendar c1 = Calendar.getInstance();
		    c1.setTime(start);
		    int w1 = c1.get(Calendar.DAY_OF_WEEK);
		    c1.add(Calendar.DAY_OF_WEEK, -w1);

		    Calendar c2 = Calendar.getInstance();
		    c2.setTime(end);
		    int w2 = c2.get(Calendar.DAY_OF_WEEK);
		    c2.add(Calendar.DAY_OF_WEEK, -w2);

		    long days = (c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*60*60*24);
		    long daysWithoutWeekendDays = days-(days*2/7);

		    if (w1 == Calendar.SUNDAY && w2 != Calendar.SATURDAY) {
		        w1 = Calendar.MONDAY;
		    } else if (w1 == Calendar.SATURDAY && w2 != Calendar.SUNDAY) {
		        w1 = Calendar.FRIDAY;
		    } 

		    if (w2 == Calendar.SUNDAY) {
		        w2 = Calendar.MONDAY;
		    } else if (w2 == Calendar.SATURDAY) {
		        w2 = Calendar.FRIDAY;
		    }

		    return daysWithoutWeekendDays-w1+w2;

	}
	
	
	
	public List<LeaveDetails> showLeaveBal(){
		return dao.showLeaveDao();
	}
	
	
	public LeaveDetails searchEmpBal(int empno){
		return dao.searchEmpDao(empno);
	}
	
	public String deletLeaveBal(int empno){
		return dao.deletLeaveDao(empno);
	}
}
