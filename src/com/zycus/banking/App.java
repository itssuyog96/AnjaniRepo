package com.zycus.banking;

import java.util.*;


public class App {
	
	static Branch branch = new Branch();
	static Transaction transaction = new Transaction(branch);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(menu())
		{
			
		}
		
		
		
		/*branch.openNewAccount(accountType.Current,10000,"AK Pandey");
		branch.openNewAccount(accountType.Savings,10000,"PK Pandey");
		branch.openNewAccount(accountType.Savings,10000,"AK Pandey");
		branch.openNewAccount(accountType.Current,12000,"AMit Dubey");
		branch.openNewAccount(accountType.Current,10000,"RAjesh Mishra");
		branch.openNewAccount(accountType.Savings,10000,"Sita Thakur");
		branch.openNewAccount(accountType.Current,10000,"Dr.Mahesh");
		branch.openNewAccount(accountType.Current,15000,"Akash rai");
		branch.openNewAccount(accountType.Savings,14000,"Ganesh Khan");
		branch.openNewAccount(accountType.Current,150000,"ROhit SHarma");
		branch.openNewAccount(accountType.Savings,1000,"Arti Singh");
		branch.openNewAccount(accountType.Current,10000,"Saurav Shaikh");
		
		branch.getAll();
		
		
		

		Set<Account> set = new HashSet<>();	
	 set = branch.findByAccountHolder("AK Pandey");
	 if(set.isEmpty())
	 {
		 System.out.println("NO matching entry found");
	 }else{
		 
	 
	    for(Account a :set)
	   {
	 	 
		 System.out.println(a);
	   }
	 }
		 Transaction transaction = new Transaction(branch);
		transaction.withdraw(12324,7000);
		transaction.deposit(12327,5000);
		transaction.transfer(12323, 12325, 500);
		
		branch.closeAccount(12333);
		branch.closeAccount(12325);
		
		
		List<Account> list = branch.getAll();
		print(list);
		
		list.sort((x,y)->(int)x.getBalance()-(int)y.getBalance());
		System.out.println("SORTING OF ACCOUNT IN aSCENDING oRDER OF BALANCE");
		print(list);
		
		
		list.sort((a,b)->a.getAccountNo()-b.getAccountNo());
		
		System.out.println("SORTING WRT ACCOUNTNO");
		print(list);
		
		System.out.println("ACTIVE ACCOUNT TYPE");
		list.stream().filter((x)->x.getStatus().equals("Active")).forEach(App::printAccount);
		
		
		System.out.println("CLOSED ACCOUNT TYPE");
		list.stream().filter((x)->x.getStatus().equals("Closed")).forEach(App::printAccount);	
	
		System.out.println("Closed Account Type with Balance >5000");
		list.stream().filter((x)->x.getStatus().equals("Closed") && x.getBalance()>5000).forEach(App::printAccount);*/
		
	}

	private static  void print(List<Account> l ) {
		
		for(Account aa:l)
		{
			System.out.println(aa);
		}
		// TODO Auto-generated method stub
		
	}
	
	static void printAccount(Account acc)
	{
		System.out.println(acc);
	}
	
	

	private static boolean menu() {
		
		Scanner sc= new Scanner(System.in);
		
		String action = new String();
		Scanner scan = new Scanner(System.in);
		System.out.println("Select an operation : ");
		System.out.println("Enter 'A' to add new account");
		System.out.println("Enter 'F' to find account");
		System.out.println("Enter 'L' to list all account");
		System.out.println("Enter 'T' to perform Transaction Operation");
		System.out.println("Enter 'Q' to quite application");
		action = scan.next();
		
		if(action.equalsIgnoreCase("A")) {
			System.out.println("Enter Account Type(S-Saving /C-Current)");
			String actype = sc.next();
			
			System.out.println("Enter Opening Amount");
			double amount = sc.nextDouble();
			System.out.println("Enter Account Holder Name");
			sc.nextLine();
			String acholder = sc.nextLine();
			if(actype.equalsIgnoreCase("s") && amount >= 1000 && acholder!="" ){
				branch.openNewAccount(accountType.Savings, amount,acholder);
				System.out.println("ACcount of Type Savings Created Successfully");
			}else{
				if(actype.equalsIgnoreCase("C") && amount>=1000 && acholder!="" )
				{
					branch.openNewAccount(accountType.Current, amount,acholder);
					System.out.println("ACcount of Type Current Created Successfully");
				}
			     else{
				   System.out.println("Account Cannot be Created please enter the correct fields");
			         }
			    }
			
			
		}
		else if(action.equalsIgnoreCase("F")) {
			 System.out.println("Enter N -for finding account by Number/H- by  Account Holder  name   ");
			 String findoption = sc.next();
			 if(findoption.equalsIgnoreCase("N"))
			 {
				 System.out.println("Enter Account Number");
				 int Accno= sc.nextInt();
				 printAccount(branch.getAccount(Accno));
				 return false;
			 }else
			  {
				 if(findoption.equalsIgnoreCase("H")){
				 System.out.println("Enter Account Holder Name");
				 String name = sc.nextLine();
				 Set<Account> set = new HashSet<>();	
				 set = branch.findByAccountHolder(name);
				 if(set.isEmpty())
				 {
					 System.out.println("NO matching entry found");
				 }else{			 
				         for(Account a :set)
				          {
				    	  System.out.println(a);
			    	      }
				      }
			
			  }
	     }
		return false;	 
		}
		else if(action.equalsIgnoreCase("L")) {
			List<Account> list = branch.getAll();
			print(list);
			return false;
		}
		else if(action.equalsIgnoreCase("T")) {
			System.out.println("Enter W-for Witdrawal/D-Deposit/F-Transfer");
			if(action.equalsIgnoreCase("w"))
			  {
				System.out.println("Enter the Account No");
				int no = sc.nextInt();
				System.out.println("Enter the Amount ");
				double amt = sc.nextDouble();
				transaction.withdraw(no,amt);
				return false;
		      }
			else
				if(action.equalsIgnoreCase("D"))
				  {
					System.out.println("Enter the Account No");
					int No = sc.nextInt();
					System.out.println("Enter the Amount ");
					double Amt = sc.nextDouble();
					transaction.deposit(No,Amt);
					return false;
			      }
				else
					if(action.equalsIgnoreCase("F"))
					  {
						System.out.println("Enter the Source Account No");
						int sNo = sc.nextInt();
						System.out.println("Enter the Destination Account No");
						int dNo = sc.nextInt();
						System.out.println("Enter the Amount ");
						double tAmt = sc.nextDouble();
						transaction.transfer(sNo,dNo,tAmt);
						return false;
				      }
					else
					{
						System.out.println("Invalid INput  ");
						return false;
					}
		}
		else {
			if(action.equalsIgnoreCase("Q")) {
			System.out.println("Are you sure to quit?(y/n)");
			action = scan.next();
			
		     	if(action.equalsIgnoreCase("y"))
			  {
		  		return false;
		      }
			}
			else
			{
				System.out.println("INvalid INput ,PLease Select from the Menu Only");
			}
		}
		
		
		return true;
	 }
	

}
