package com.infinte.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDaoImpl implements BankDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(accountNo) IS NULL THEN 1 "
				+ " else max(accountNo)+1 end accno from Bank";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		return accno;
	}
	
	public String CheckStatus(int accountNo) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select status from Bank where accountNo=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		String str = rs.getString("status");
		return str;
	}
	
	
	
	@Override
	public String createAccount(Bank bank) throws SQLException, ClassNotFoundException {
		int accountNo = generateAccountNo();
		bank.setAccountNo(accountNo);
		String cmd = "insert into Bank(AccountNo, FirstName, "
				+ "LastName, city,State,Amount, CheqFacil,"
				+ "AccountType) values(?,?,?,?,?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account Created...";
	}
	@Override
	public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Bank where accountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
		}
		return bank;
	}
	@Override
	public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update bank set status='inactive' where accountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.executeUpdate();
			return "Account Closed...";
		}
		return "Account No Not Found...";
	}
	@Override
	public String depositAccount(int accountNo, int depositAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		String status=CheckStatus(accountNo);
		
		
		if(status.equals("active")){
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank set Amount=Amount+? Where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.setInt(2, depositAmount);
			pst.setString(3, "C");
			pst.executeUpdate();
			return "Amount Credited...";			
		} else {
			return "Account No Not Found...";
		}
		}else{
			return "Account Inactive ";
				
		}
	}
	@Override
	public String withdrawAccount(int accountNo, int withdrawAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		String status=CheckStatus(accountNo);
		
		
		if(status.equals("active")){
		if (bank!=null) {
			int balanceAmount = bank.getAmount();
			if (balanceAmount-withdrawAmount >= 1000) {
				connection = ConnectionHelper.getConnection();
				String cmd = "Update Bank set Amount=Amount-? Where AccountNo=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setInt(2, withdrawAmount);
				pst.setString(3, "D");
				pst.executeUpdate();
				return "Amount Debited...";			
			} else {
				return "Insufficient Funds...";
			}
		}
		return "Account Not Found...";
	}else{
		return "Account Inactive";
	}
	
	}

}
