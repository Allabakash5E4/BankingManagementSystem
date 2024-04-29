package com.assignment;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	private static Map<Integer, UserAccount> accounts = new HashMap<>();
    private static int accountNumberGenerator = 20241000;
    
    public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		 boolean exit = false;
		 
		 while(!exit) {
			 System.out.println("\n Bank System:  \n1.Create an account  \n2.Deposit Amount  \n3.Withdraw Amount \n4.Transfer Amount  \n5.Check balance  \n6.display account details  /n7.Exit");
			 System.out.println("Enter your Choice: ");
			 
			 int choice = sc.nextInt();
			 
			 switch(choice) {
			 case 1: 
				 createAccount();
			     break;
			 case 2:
				 depositAmount();
				 break;
			 case 3:
				 withdrawAmount();
				 break;
			 case 4:
				 transferAmount();
				 break;
			 case 5:
				 checkBalance();
				 break;
			 case 6:
				 displayAccounts();
				 break;
			 case 7:
				 exit = true;
				 System.out.println("Thank you");
				 break;
			 default:
                 System.out.println("Invalid choice. Please try again....");
			 
			 
			 }
		 }
	}
    
    public static void createAccount() {
    	Scanner sc  = new Scanner(System.in);
    	System.out.println("Enter the account holder's name: ");
    	String name = sc.next();
    	System.out.println("Enter initial balance: ");
    	double balance = sc.nextDouble();
    	
    	int accountNumber = ++accountNumberGenerator;
    	UserAccount ac = new UserAccount(accountNumber, name, balance);
    	accounts.put(accountNumber,ac);
    	
    	System.out.println("Account created Successfully");
        System.out.println(ac);
    }
    
    public static void depositAmount() {
    	Scanner sc  = new Scanner(System.in);
    	System.out.println("Enter Account Number: ");
    	int accountNum = sc.nextInt();
    	
    	UserAccount ac = accounts.get(accountNum);
    	if(ac != null) {
    		System.out.println("Enter the amount:");
    		double amount = sc.nextDouble();
    		ac.deposit(amount);
    	}else {
    		System.out.println("Account is not found");
    	}
    }
    
    public static void withdrawAmount() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter account number: ");
    	int accountNum = sc.nextInt();
    	
    	UserAccount ac = accounts.get(accountNum);
    	if(ac != null) {
    		System.out.println("Enter withdraw amount:");
    		double amount = sc.nextDouble();
    		ac.withdraw(amount);
    	}else {
    		System.out.println("Account is not found");
    	}
    	
    }
    
    public static void transferAmount() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter account number: ");
    	int accountNum = sc.nextInt();
    	
    	System.out.println("Enter recipient account number: ");
    	int recAccountNum = sc.nextInt();
    	
    	UserAccount senderAcc = accounts.get(accountNum);
    	UserAccount recipientAcc = accounts.get(recAccountNum);
    	
    	if(senderAcc !=null && recipientAcc != null) {
    		System.out.println("Enter amount to transfer: ");
    		double amount = sc.nextDouble();
    		senderAcc.transfer(recipientAcc, amount);	
    	}else {
    		System.out.println("Account is not found");
    	}
    }
    
    public static void checkBalance() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNum = scanner.nextInt();

        UserAccount account = accounts.get(accountNum);
        if (account != null) {
            System.out.println("Balance: Rs." + account.getInitialBalance());
        } else {
            System.out.println("Account is not found.");
        }
    }
    
    public static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        
        System.out.println("\nAll Account Details:");
        for (UserAccount account : accounts.values()) {
            System.out.println("------------------------------");
            System.out.println(account);
        }
        System.out.println("------------------------------");
    }

}
