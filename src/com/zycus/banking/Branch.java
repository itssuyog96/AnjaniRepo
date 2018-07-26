package com.zycus.banking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Branch represents All branch related Activity 
 * @author anjanikumar.pandey
 *
 */
public class Branch {
	
	Map<Integer,Account> allAccounts = new HashMap<>();
	private static int ACC_NO_GENERATOR=12323;
   
	
	/**openNewAccount performs generation of unique ACCount number and making entry of details along with 
	 * the newly generated account number to store user account 
	 * 
	 * @param actype represents the Account type of the Customer whether Saving /Current
	 * @param balance represents the Opening BAlance of the Customer
	 * @param AccHolder represents the NAme of the Customer opening the Account 
	 */
	void openNewAccount(accountType actype,double balance,String AccHolder)
	{
		int AccountNo = ACC_NO_GENERATOR;
		ACC_NO_GENERATOR += 1; 
		allAccounts.put(AccountNo, new Account(AccountNo, AccHolder,status.Active,actype, balance));
		
	}
	
	
	/**
	 * getAccount represents the operation of getting the account from the map 
	 * @param accountNumber represents the unique Account number against which the Account is accessed 
	 * @return represents the Account Type return to the matching account number
	 */
	Account getAccount(int accountNumber){
		
		return allAccounts.get(accountNumber);
		
	}
	
	
	
	
	/**
	 * closeAccount performs closing of account 
	 * @param AccountNo represents the unique id of which the account is to be closed
	 */
    void closeAccount(int AccountNo)
	{
		
	String current_stat= allAccounts.get(AccountNo).getStatus();
	if(current_stat.trim()=="Closed")
	{
		System.out.println("Account Already inactive and closed");
		
	}else
		
	  {
		current_stat=status.Closed.toString();
		allAccounts.get(AccountNo).setStatus(current_stat);
	   }
		
	}
	
	
    /**
     * getAll gets all the records of account in the bank
     * @return returns list of records in the bank
     */
    
	 List<Account> getAll()
	{
		List<Account> listall =new LinkedList<>(allAccounts.values());
		//for(Account a:listall)
		//{
			//System.out.println(a);
	
		//ListIterator<Account> it =  listall.listIterator();
		//while(it.hasNext()){
		//	System.out.println("ACCount No"+it.next().getAccountNo()+"Account Holder"+it.next().getAccountHolder()+"Account Type"+it.next().getAccountType()+"Status"+it.next().getStatus());
		//}
	
		return listall;
	}
	
	 
	 /**
	  * findByaccountHolder performs finding of Account set for a given user name 
	  * @param name represents the account holder name
	  * @return represents set of Accounts found on a given name
	  */
	 Set<Account> findByAccountHolder(String name){
		
		return allAccounts.values().stream().filter((x)->x.getAccountHolder().equalsIgnoreCase(name)).collect(Collectors.toSet());
		
	  }
	
	
}
