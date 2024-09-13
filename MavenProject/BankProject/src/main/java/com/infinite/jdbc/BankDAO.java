package com.infinite.jdbc;

import java.sql.SQLException;

public interface BankDAO {

	String createAccount(Bank bank) throws SQLException, ClassNotFoundException;
	Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String closeAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String depositAccount(int accountNo, int depositAmount) throws ClassNotFoundException, SQLException;
	String withdrawAccount(int accountNo, int withdrawAmount) throws ClassNotFoundException, SQLException;
	
}
