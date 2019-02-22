package service;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
	
	private static CustomerDAO cd = new CustomerDAO();
	
	public static boolean addUser(Customer c) {
		return cd.addUser(c);
	}
	
	public static boolean Login (String username, String password) {
		return cd.Login(username, password);
	}
	
	public static boolean UpdateUser(Customer c) {
		return cd.UpdateUser(c);
	}
	
	public static Customer getCustomer(String username) {
		return cd.getCustomer(username);
	}
	
	/**
	 * needs to be finished
	 * @param password
	 * @return
	 */
	public static String HashPassword(String password)
	{
		return null;
	}
}
