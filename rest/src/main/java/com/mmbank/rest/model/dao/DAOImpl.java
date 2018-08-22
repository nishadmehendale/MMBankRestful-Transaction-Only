package com.mmbank.rest.model.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mmbank.rest.framework.account.dao.DAO;
import com.mmbank.rest.framework.account.pojo.BankAccount;
import com.mmbank.rest.framework.account.pojo.Customer;

/**
 * @author Satyen Singh
 * @author Nishad Mehendale
 *
 *This is class for maintaining the list of all unique account objects.
 *
 *This was created from the warm heart. The Developers are From capgemini.
 */

@Repository
public class DAOImpl implements DAO {
	private static ArrayList<BankAccount> bankAccountSet;
	private static ArrayList<Customer> customerList;
	static {
		bankAccountSet = new ArrayList<>();
		customerList = new ArrayList<>();
		
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.account.dao.DAO#addBankAccount(com.moneymoney.framework.account.pojo.BankAccount)
	 */
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountSet.add(bankAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.account.dao.DAO#viewAll()
	 */
	@Override
	public ArrayList<BankAccount> viewAllAccounts(){
		return bankAccountSet;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer+"cusosdkn");
		customerList.add(customer);
	}


	@Override
	public ArrayList<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return customerList;
	}

	@Override
	public BankAccount searchAccountById(int num) {
		BankAccount account = null;
		for(BankAccount a : bankAccountSet ) {
			if(a.getAccountNumber() == num) {
				account = a;
			}
		}
		return account;
	}
}
