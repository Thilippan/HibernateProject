package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customert {
	
	@Column(name="Customer_number")
	@Id
	private long CustomerNumber;
	
	@Column(name="Customer_name")
	private String CustomerName;
	
	@Column
	private int age;
	
	
	@Override
	public String toString() {
		return "Customert [CustomerNumber=" + CustomerNumber + ", CustomerName=" + CustomerName + ", age=" + age + "]";
	}



	public Customert() {}
	
	
		public Customert(long CustomerNumber, String CustomerName, int age) {
		this.CustomerNumber = CustomerNumber;
		this.CustomerName = CustomerName;
		this.age = age;
	}

	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getCustomerNumber() {
		return CustomerNumber;
	}
	public void setCustomerNumber(long CustomerNumber) {
		this.CustomerNumber = CustomerNumber;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String CustomerName) {
		this.CustomerName = CustomerName;
	}


}