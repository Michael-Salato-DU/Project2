package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Customer;
import util.HibernateUtil;

public class CustomerDAO implements ICustomer{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	/*
	 * (non-Javadoc)
	 * @see dao.ICustomer#addUser(model.Customer)
	 * adds a new user to the database, should return false when the 
	 * user exists or does not meet password requirements
	 * 
	 */
	public boolean addUser(Customer c) {
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			sess.persist(c);
			
			sess.getTransaction().commit();
			sess.close();
			return true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see dao.ICustomer#getCustomer(java.lang.String)
	 * returns a customers details based on username 
	 * should return null if the customer doesn't exist
	 */
	public Customer getCustomer(String username) {
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Customer customer = sess.get(Customer.class, username);
			sess.getTransaction().commit();
			
			return customer;
		}catch(HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see dao.ICustomer#UpdateUser(model.Customer)
	 * updates a customers details with a new customer
	 */
	public boolean UpdateUser(Customer c) {
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			sess.saveOrUpdate(c);
			
			sess.getTransaction().commit();
			sess.close();
			return true;
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	//get the password from user, hash it check if hashed value is in the db and is the same id as the username
	
	public boolean Login(String username, String password) {
		return false;
	}

}
