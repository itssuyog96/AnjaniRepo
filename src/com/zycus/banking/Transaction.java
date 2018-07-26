package com.zycus.banking;
/**
 * 
 * @author anjanikumar.pandey
 *Transaction  represents all banking transaction related activities 
 */
public class Transaction {
	Branch branch;

	Transaction(Branch branch) {
		super();
		this.branch = branch;
	}
	
	/**
	 * Withdraw represents withdrawal of money from an account by the customer 
	 * @param accountNumber represents the unique Account Number from which the Amount is to be withdrawn 
	 * @param amount represents the Amount that is to be withdrawn 
	 * @return represents the Boolean return Value corresponding to whether withdraw was successfully done or not
	 */
	boolean withdraw(int accountNumber,double amount){
		Account withdrawal = branch.getAccount(accountNumber);//check for exception
		
		 
		
		if(withdrawal==null)
		 {
		 System.out.println("No Account Found for Debit");
		 return false;
		 }
		 else{
			 if(withdrawal.getStatus().equals("Closed"))
			 {
			 System.out.println("Account is Not Active ");
			 return false;
			 }
			 else{
		
		      double temp = withdrawal.getBalance()-amount;
		      if(temp<1000)
		        {
			     System.out.println("Balance cannot be lesser than 1000");
		            return false;
		         }else
		            {
			           withdrawal.setBalance(temp);
			            System.out.println("Debit Successful");
			            System.out.println("Current Balance:"+withdrawal.getBalance());
			             return true;
		             }
		      }
		 }
		
		
		
	}
	
	
	/**
	 * 
	 *Deposit represents the deposit transaction Activity
	 * @param accountNumber represents the account Number into which the Amount is to be Deposited
	 * @param amount represents the amount to be deposited
	 * @return represents boolean return representing the success of the deposit operation to a given account 
	 */
        boolean deposit(int accountNumber,double amount){
		Account deposits = branch.getAccount(accountNumber);//Check for Exception
		
		if(deposits==null)
		 {
		 System.out.println("No Account Found for Credit");
		 return false;
		 } else{
			 if(deposits.getStatus().equals("Closed"))
			 {
			 System.out.println("Account is Not Active ");
			 return false;
			 }
		      else{
		       double bal =deposits.getBalance()+amount; 
		       deposits.setBalance(bal);
		       System.out.println("Amount Deposited Successfully for"+deposits.getAccountHolder());
		       System.out.println("Current Balance:"+deposits.getBalance());
	            return true;
		     }
		 }
		
	}
	
	
	/**
	 * transfer represents the transfer operation of money from one account to other 
	 * @param srcAccountNumber represents the Source Account from which the Amount is to be Transferred to the destination account 
	 * @param desAccountNumber represents the Destination Account to which the Amount is to be Transferred from the source account 
	 * @param amount represents the Amount to be transferred
	 */
	 void transfer(int srcAccountNumber,int desAccountNumber,double amount){
		
		boolean draw_flag = withdraw(srcAccountNumber,amount);
	    if(draw_flag==true){
	    	System.out.println("initiating transfer");
	    	boolean deposit_flag = deposit(desAccountNumber,amount);
	    	
	    	if(deposit_flag==false)
	    	{
	    		deposit(srcAccountNumber,amount);
	    		System.out.println("Transaction reversed");
	    	}
	    }
	     
		

	}
	

}