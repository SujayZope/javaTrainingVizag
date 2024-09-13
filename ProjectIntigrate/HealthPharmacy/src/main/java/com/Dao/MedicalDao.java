package com.Dao;

import java.util.Date;
import java.util.List;

import com.Medical_Entry.Medical;

public interface MedicalDao {
	
//	String addMedicinSale(Medical medical);
	List<Medical> serachBillByPID(String value);
	List<Medical> searchByMedicalId(String medicalId);
	List<Medical> searchByHospitalId(String hospitalId);
	List<Medical> showtBill();
//	String serachSaleRecordByPI(String patientId);
	String addMedicinSale(Medical medical, double price);

}
