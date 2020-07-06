package app.fe;

import java.util.List;
import java.util.Scanner;

import app.dao.CustomerDao;
import app.model.Customert;

public class Capp {
	CustomerDao customerDao;
	Scanner scanner;
	private long CustomerNumber;
	
	Capp(){
		customerDao = new CustomerDao();
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
				addCustomer();
				break;
			case 2:
				viewCustomer();
				break;
			case 3:
				viewAllCustomers();
				break;
			case 4:
				updateCustomer();
				break;
			case 5:
				deleteCustomer();
				break;
			case 6:
				System.out.println("Bye...");
			default:
				break;
			}
			
		} while (choice!=6);
	}
	
	private void deleteCustomer() {
		System.out.println("Please enter your Customer number");
		long CustomerNumber = scanner.nextLong();
		Customert customer = customerDao.getCustomer(CustomerNumber);
		if(customer != null)
		{
			System.out.println(customer);//Please take a confirmation after this for deleting
			customerDao.deleteCustomer(CustomerNumber);
			System.out.println("Customer Deleted");
		}
		else
			System.out.println("No such account");
		scanner.nextLine();
		
	}

	private void updateCustomer() {		
		System.out.println("Please enter your Customer number");
		long CustomerNumber = scanner.nextLong();
		Customert customer = customerDao.getCustomer(CustomerNumber);//original version
		if(customer != null)
			{
				System.out.println(customer);
				scanner.nextLine();
				System.out.println("Please enter your Name");
				customer.setCustomerName(scanner.nextLine());
				System.out.println("Please enter your Age");
				customer.setAge(scanner.nextInt());
				scanner.nextLine();
				customerDao.updateCustomer(customer);
			}
		else
			System.out.println("No such customer");
		scanner.nextLine();
		
	}

	private void viewAllCustomers() {
		List customert = customerDao.getCustomers();
		for (Object customer : customert) {
			System.out.println(customer);
		}
		
	}

	private void viewCustomer() {
		System.out.println("Please enter your customer number");
		long CustomerNumber = scanner.nextLong();
		Customert customer = customerDao.getCustomer(CustomerNumber);
		if(customer != null)
			System.out.println(customer);
		else
			System.out.println("No such customer");
		scanner.nextLine();
	}

	private void addCustomer() {
		
		Customert customer = new Customert();
		System.out.println("Please enter your customer number");
		customer.setCustomerNumber(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Please enter your Name");
		customer.setCustomerName(scanner.nextLine());
		System.out.println("Please enter your Age");
		customer.setAge(scanner.nextInt());
		scanner.nextLine();
		customerDao.saveCustomer(customer);
		
	}

	public static void main(String[] args) {
	
		new Capp().showChoice();
	}

}