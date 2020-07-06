package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Column(name="account_number")
	@Id
	private long accountNumber;
	
	@Column(name="account_name")
	private String accountHolderName;
	
	@Column
	private double balance;
	
	
	public Account() {}
	
	
	
	public Account(long accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account Number "+accountNumber+" Name "+accountHolderName+" balance "+balance;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


}