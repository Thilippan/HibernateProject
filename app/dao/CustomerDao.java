package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.model.Customert;
import app.util.HibernateUtil;

public class CustomerDao {

	
	public void saveCustomer(Customert customer) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an Customer");
			transaction.rollback();
		}
	}
	public List<Customert> getCustomers(){
		Transaction transaction = null;
		List<Customert> customers =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			customers = session.createQuery("from Customert").list();//HQL-Hibernate Query Language
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Customer tabe fetch not possible");
			System.out.println(e.getMessage());
			e.printStackTrace();
			transaction.rollback();
		}
		return customers;
	}
	public Customert getCustomer(long givenId){
		Transaction transaction = null;		
		Customert customer =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			customer = session.get(Customert.class, givenId);//Will generate the select query with where clause
			transaction.commit();
		} catch (Exception e) {
			System.out.println("No such customer Available");
			e.printStackTrace();
			transaction.rollback();
		}
		return customer;
	}
	public void updateCustomer(Customert updatedCustomer){
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(updatedCustomer);//Will write an Update Query with where clause on primary key
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an Customer");
			e.printStackTrace();
			transaction.rollback();
		}
	}
	public Customert deleteCustomer( long givenId){
		Transaction transaction = null;
		Customert customer =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			customer = session.get(Customert.class, givenId);//Will generate the select query with where clause
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an customer");
			e.printStackTrace();
			transaction.rollback();
		}
		return customer;
	}
	
	
	
}		
	
