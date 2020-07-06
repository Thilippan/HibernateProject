package app.fe;

import java.util.List;
import java.util.Scanner;

import app.dao.AccountDao;
import app.model.Account;

public class App {
	AccountDao accountDao;
	Scanner scanner;
	
	App(){
		accountDao = new AccountDao();
	}

	void printMenu() {
		System.out.println("Main menu");
		System.out.println("1. Create an account");
		System.out.println("2. View an account");
		System.out.println("3. View all accounts");
		System.out.println("4. Update an account");
		System.out.println("5. Delete an account");
		System.out.println("6. Exit");
	}
	
	void showChoice() {
		int choice = 0;
		scanner= new Scanner(System.in);
		do {
			printMenu();
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addAccount();
				break;
			case 2:
				viewAccount();
				break;
			case 3:
				viewAllAccounts();
				break;
			case 4:
				updateAccount();
				break;
			case 5:
				deleteAccount();
				break;
			case 6:
				System.out.println("Bye...");
			default:
				break;
			}
			
		} while (choice!=6);
	}
	
	private void deleteAccount() {
		System.out.println("Please enter your account number");
		long accountNumber = scanner.nextLong();
		Account account = accountDao.getAccount(accountNumber );
		if(account != null)
		{
			System.out.println(account);//Please take a confirmation after this for deleting
			accountDao.deleteAccounts(accountNumber);
			System.out.println("Account Deleted");
		}
		else
			System.out.println("No such account");
		scanner.nextLine();
		
	}

	private void updateAccount() {
		
		System.out.println("Please enter your account number");
		long accountNumber = scanner.nextLong();
		Account account = accountDao.getAccount(accountNumber);//original version
		if(account != null)
			{
				System.out.println(account);
				//System.out.println("Please enter the account number for updation");
				//account.setAccountNumber(account.getAccountNumber());
				//scanner.nextLine();
				//account = new Account();//new version
				scanner.nextLine();
				System.out.println("Please enter your Name");
				account.setAccountHolderName(scanner.nextLine());
				System.out.println("Please enter your Balance");
				account.setBalance(scanner.nextDouble());
				scanner.nextLine();
				accountDao.updateAccounts(account);
			}
		else
			System.out.println("No such account");
		scanner.nextLine();
		
	}

	private void viewAllAccounts() {
		List accounts = accountDao.getAccounts();
		for (Object account : accounts) {
			System.out.println(account);
		}
		
	}

	private void viewAccount() {
		System.out.println("Please enter your account number");
		long accountNumber = scanner.nextLong();
		Account account = accountDao.getAccount(accountNumber);
		if(account != null)
			System.out.println(account);
		else
			System.out.println("No such account");
		scanner.nextLine();
	}

	private void addAccount() {
		
		Account account = new Account();
		System.out.println("Please enter your account number");
		account.setAccountNumber(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Please enter your Name");
		account.setAccountHolderName(scanner.nextLine());
		System.out.println("Please enter your Balance");
		account.setBalance(scanner.nextDouble());
		scanner.nextLine();
		accountDao.saveAccount(account);
		
	}

	public static void main(String[] args) {
	
		new App().showChoice();
	}

}