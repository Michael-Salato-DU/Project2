package daotests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dao.CustomerDAO;
import model.Customer;
import model.Reservation;
import service.CustomerService;
import util.HibernateUtil;

public class CustomerDAOTesting {
 
	static String password = CustomerService.hashPassword("password");
	static Customer c = new Customer(0, "Laurence", "Roberts", "username", password, "email@email.com", "999-000-0000", "12 Address Way");
	
	static CustomerDAO cd = new CustomerDAO();
	

	@Test(priority = 0)
  public void testAddUser() 
  {
	 Assert.assertEquals(cd.addUser(c),true);
  }
  
  @Test(priority = 1)
  public void testGetCustomerExisitingUsername()
  {
	  String username = "username";
	  Customer customer = cd.getCustomer(username);
	  Assert.assertEquals(customer.toString(), c.toString());
  }
  
  @Test (priority = 1)
  public void testGetCustomerNonexistantUsername()
  {
	  String username = "NULL";
	  Assert.assertEquals(cd.getCustomer(username),null);
  }
  
  @Test (priority = 2)
  public void LoginWithValidCredentials()
  {
	  String username = "username";
	  String password = CustomerService.hashPassword("password");
	  Assert.assertTrue(cd.Login(username, password).getCustomer_id() >= 0);
  }
  
  @Test(priority = 2)
  public void LoginWithInvalidCredentials()
  {
	  String username = "NOT A USERNAME";
	  String password = CustomerService.hashPassword("password");
	  Assert.assertTrue(cd.Login(username, password).getCustomer_id() == -1);
  }
  
  @Test(priority = 3)
  public void testUpdateCustomer()
  {
	  Customer c1 = c;
	  c1.setAddress("13 Wanderer Way");
	  c1.setFirst_name("Wayne");
	  Assert.assertEquals(cd.UpdateUser(c1), true);
  }
  
  @AfterSuite
  public void deleteUser()
  {
	  try
	  {
		  SessionFactory sf = HibernateUtil.getSessionFactory();
		  Session session = sf.openSession();
		  Transaction transaction = session.beginTransaction();
		  String hql = "delete from Customer where username = 'username'";
		  Query query = session.createQuery(hql);
		  transaction.commit();
	  } catch(HibernateException e)
	  {
		  e.printStackTrace();
	  }
  }
  
}
