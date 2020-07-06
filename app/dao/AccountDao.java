package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.model.Account;
import app.util.HibernateUtil;

public class AccountDao {

	//CRUD
	//Add an Account - done
	//Get All account- done
	//Get One Account - done
	//Update Account - done
	//Delete Account - done
	
	public void saveAccount(Account account) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an account");
			transaction.rollback();
		}
	}
	public List<Account> getAccounts(){
		Transaction transaction = null;
		List<Account> accounts =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			accounts = session.createQuery("from Account").list();//HQL-Hibernate Query Language
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Account tabe fetch n ot possible");
			System.out.println(e.getMessage());
			e.printStackTrace();
			transaction.rollback();
		}
		return accounts;
	}
	public Account getAccount(long givenId){
		Transaction transaction = null;
		Account account =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			account = session.get(Account.class, givenId);//Will generate the select query with where clause
			transaction.commit();
		} catch (Exception e) {
			System.out.println("No such account to get");
			e.printStackTrace();
			transaction.rollback();
		}
		return account;
	}
	public void updateAccounts(Account updatedAccount){
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(updatedAccount);//Will write an Update Query with where clause on primary key
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an account");
			e.printStackTrace();
			transaction.rollback();
		}
	}
	public Account deleteAccounts( long givenId){
		Transaction transaction = null;
		Account account =null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			account = session.get(Account.class, givenId);//Will generate the select query with where clause
			session.delete(account);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Could not create an account");
			e.printStackTrace();
			transaction.rollback();
		}
		return account;
	}
	
	
	
}		
	
