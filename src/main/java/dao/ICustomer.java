package dao;

import model.Customer;

public interface ICustomer
{
	boolean addUser(Customer c);
	Customer Login (String username, String password);
	boolean UpdateUser(Customer c);
	Customer getCustomer(String username);
}
