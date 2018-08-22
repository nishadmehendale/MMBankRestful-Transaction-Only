package com.mmbank.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmbank.rest.model.service.ServiceImpl;

@RestController
public class TransactionController {
	
	@Autowired
	ServiceImpl service;
	
	@RequestMapping(value="/deposit",method=RequestMethod.POST)
	public void deposit(@RequestBody int accNo, double amount) {
		service.deposit(accNo, amount);
	}
	
	@RequestMapping(value="/withdraw",method=RequestMethod.POST)
	public void withdraw(@RequestBody int accNo, double amount) {
		service.withdraw(accNo, amount);
	}
	
	@RequestMapping(value="/fundtransfer",method=RequestMethod.POST)
	public void fundTransfer(@RequestBody int sender, int receiver, double amount) {
		service.FundTransfer(service.searchAccountById(sender), service.searchAccountById(receiver), amount);
	}
	
}
