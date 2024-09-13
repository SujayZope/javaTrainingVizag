package com.jsf.hib;
import java.util.List;

public interface WalletDAO {

	List<Wallet> showCustomerWalletDao(int custId);
}
