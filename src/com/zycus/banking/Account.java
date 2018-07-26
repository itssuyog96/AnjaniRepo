package com.zycus.banking;


/**
 * 
 * @author anjanikumar.pandey
 *Account represents various Accounts in the bank
 *
 */
public class Account {
	
 private int AccountNo;
 private String AccountHolder,status,AccountType;
 private double balance;

 /**Account Constructor initializes a new Account instantiation
  * 
  * @param accountNo represents a unique account number of the customer
  * @param accountHolder represents the name of the Account Holder
  * @param stat represents the Status of the Account whether Active/Closed 
  * @param accountType represents the Type of the Account whether Saving/Current
  * @param balance represents the Current Balance in the Account of the Customer
  */
 Account(int accountNo, String accountHolder, status stat, accountType accountType, double balance) {
		super();
		AccountNo = accountNo;
		AccountHolder = accountHolder;
		this.status = stat.toString();
		AccountType = accountType.toString();
		this.balance = balance;
 }
 
 /**
  * toString Method is Overridden here to return the String of your choice for the object of given Class(In this Case ,Account)
  * 
  */
 @Override
public String toString() {
	// TODO Auto-generated method stub
	return "Acount no: "+AccountNo+"\t AccountName: "+AccountHolder+"\t Account Type: "+AccountType+"\t Account Status: "+status+"\t Balance"+balance;
}


void setAccountNo(int accountNo) {
	AccountNo = accountNo;
}




void setAccountHolder(String accountHolder) {
	AccountHolder = accountHolder;
}


void setStatus(String status) {
	this.status = status;
}


void setAccountType(String accountType) {
	AccountType = accountType;
}


void setBalance(double balance) {
	this.balance = balance;
}


public int getAccountNo() {
	return AccountNo;
}





public String getAccountHolder() {
	return AccountHolder;
}


public String getStatus() {
	return status;
}


public String getAccountType() {
	return AccountType;
}


public double getBalance() {
	return balance;
}



 
 




}
