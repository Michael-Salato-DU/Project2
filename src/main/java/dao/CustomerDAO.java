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
	
	public boolean addUser(Customer c) {
		
		try
		{
			Session sess = sf.openSession();
			sess.beginTransaction();
			sess.persist(c);
			sess.getTransaction().commit();
			sess.close();
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Login(String username, String password) {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Customer.class);
		Criterion selectUsername = Restrictions.eq("username", username);
		Criterion selectPassword = Restrictions.eq("password", password);
		Criterion condition = Restrictions.and(selectUsername, selectPassword);
		crit.add(condition);
		List results = crit.list();
		if (results.size() == 1)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}

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

	public Customer getCustomer(String username) {
		
		try 
		{
			Session sess = sf.openSession();
			Criteria crit = sess.createCriteria(Customer.class);
			Criterion customerUsername = Restrictions.eq("username", username);
			crit.add(customerUsername);
			Customer c = (Customer)crit.uniqueResult();
			return c;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
