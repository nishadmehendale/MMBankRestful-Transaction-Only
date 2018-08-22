package com.mmbank.rest.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.mmbank.rest.framework.account.pojo.BankAccount;
import com.mmbank.rest.framework.account.pojo.Customer;
import com.mmbank.rest.framework.account.pojo.PaymentGateway;
import com.mmbank.rest.framework.service.Service;
import com.mmbank.rest.model.account.pojo.MMCurrentAccount;
import com.mmbank.rest.model.account.pojo.MMCustomer;
import com.mmbank.rest.model.account.pojo.MMSavingsAccount;
import com.mmbank.rest.model.dao.DAOImpl;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	DAOImpl dao;
	
	
	public ServiceImpl(){
		Customer c1 = new MMCustomer("Cus1" , 12345, "28/02/2000", "a@b.com");
		BankAccount acc1 = new MMSavingsAccount(c1, 80000, false);
		
		Customer c2 = new MMCustomer("Cus2" , 122345, "28/02/1996", "a@d.com");
		BankAccount acc2 = new MMCurrentAccount(c2, 80000, 10000);
		Customer c3 = new MMCustomer("Cus3" , 12345, "28/02/1900", "c@b.com");
		BankAccount acc3 = new MMSavingsAccount(c3, 80000, true);
		Customer c4 = new MMCustomer("Cus4" , 12345, "28/02/12", "c@a.com");
		BankAccount acc4 = new MMCurrentAccount(c4, 79999, 10000);
		addBankAccount(acc1);
		addBankAccount(acc2);
		addBankAccount(acc3);
		addBankAccount(acc4);
		System.out.println(acc1.toString());
		System.out.println(acc2.toString());
		System.out.println(acc3.toString());
		System.out.println(acc4.toString());
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#addBankAccount(com.moneymoney.framework.account.pojo.BankAccount)
	 */
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		System.out.println(bankAccount);
		dao.addBankAccount(bankAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#viewAll()
	 */
	@Override
	public ArrayList<BankAccount> viewAllAccounts(){
		return dao.viewAllAccounts();
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#FundTransfer(com.moneymoney.framework.account.pojo.BankAccount, com.moneymoney.framework.account.pojo.BankAccount, double)
	 */
	@Override
	public boolean FundTransfer(BankAccount sender,BankAccount reciever,double amount) {
		return PaymentGateway.transfer(sender, reciever, amount);
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
	
	@Override
	public ArrayList<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return dao.viewAllCustomers();
	}

	@Override
	public BankAccount searchAccountById(int num) {
		// TODO Auto-generated method stub
		return dao.searchAccountById(num);
	}
	
	public String withdraw(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.withdraw(amount);		
	}
	public void deposit(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		account.deposit(amount);		
	}
}
