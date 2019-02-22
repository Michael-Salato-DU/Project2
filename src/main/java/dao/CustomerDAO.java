package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import model.Customer;
import util.HibernateUtil;

public class CustomerDAO implements ICustomer{

	public static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public boolean addUser(Customer c) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.persist(c);
		sess.getTransaction().commit();
		sess.close();
		return true;
	}

	public boolean Login(String username, String password) {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Customer.class);
		Criterion selectUsername = Restrictions.eq("username", username);
		Criterion selectPassword = Restrictions.eq("password", password);
		crit.add(selectUsername);
		crit.add(selectPassword);
		List results = (List) crit.list();
		return true;
	}

	public boolean UpdateUser(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	public Customer getCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
