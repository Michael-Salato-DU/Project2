package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.Customer;
import util.HibernateUtil;

public class CustomerDAO implements ICustomer{
  
  public static SessionFactory sf = HibernateUtil.getSessionFactory();

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
  
	public boolean Login(String username, String password) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Customer.class);
		Criterion selectUsername = Restrictions.like("username", "%"+username+"%");
		Criterion selectPassword = Restrictions.like("password", "%"+password+"%");
		Criterion condition = Restrictions.and(selectUsername, selectPassword);
		crit.add(condition);
		List results = crit.list();
		sess.close();
		if (results.size() == 1)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
  
	/*
	 * (non-Javadoc)
	 * @see dao.ICustomer#UpdateUser(model.Customer)
	 * updates a customers details with a new customer
	 */
	public boolean UpdateUser(Customer c) {		
		try
		{
			Session sess = sf.openSession();
			sess.beginTransaction();
			sess.saveOrUpdate(c);
			sess.getTransaction().commit();
			sess.close();
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
}
