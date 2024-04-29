package com.assignment;

public class UserAccount {
	
	private int accountNumber;
	private String accountHoldersName;
	private double initialBalance;
	
	public UserAccount(int accountNumber, String accountHoldersName, double initialBalance) {
		
		this.accountNumber = accountNumber;
		this.accountHoldersName = accountHoldersName;
		this.initialBalance = initialBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHoldersName() {
		return accountHoldersName;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void deposit(double amount) {
		System.out.println("Amount deposited Rs."+amount);
		System.out.println("Amount deposited Successfully");
		initialBalance=initialBalance +amount;
	}
	
	public boolean withdraw(double amount) {
		if(amount <= initialBalance) {	
			System.out.println("Amount withdraw Rs."+amount);
			System.out.println("Amount withdraw Successfully");
			initialBalance = initialBalance-amount;
			return true;
		}else {
			System.out.println("Insufficient funds");
	    	System.out.println("Please check your balance once!!!");
	    	return false;
		}
		
	}
	public void transfer(UserAccount recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            System.out.println(amount + " transferred successfully to " + recipient.getAccountHoldersName() + ".");
        } else {
            System.out.println("Transfer failed due to insufficient balance.");
        }
    }
	 public String toString() {
	        return "Account Number: " + accountNumber + "\nAccount Holder Name: " + accountHoldersName + "\nBalance: Rs." + initialBalance;
	    }
	

}
