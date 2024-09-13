package com.java.cms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ComplaintDao {

	List<Complaint> showAllComplaint();

	String AddcomplaintDao(Complaint complaint);

	String searchcomplaintDao(String complaintID);

	String addResolve(Complaint complaint, Resolve resolve);

	List<Resolve> showAllResolveComplaint();

	int calculatedays(Date ComplaintDate, Date ResolveDate);

}
