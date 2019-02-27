package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {

	private static CustomerDAO cd = new CustomerDAO();

	public static boolean addUser(Customer c) {
		return cd.addUser(c);
	}

	public static boolean Login(String username, String password) {
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
	 * 
	 * @param password
	 * @return
	 */

	//Code 'borrowed' from Howtodoinjava.com//
	
	public static String hashPassword(String password)
	{
		String hashedPassword = null;
		
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(password.getBytes());
			//Get the hash's bytes
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			hashedPassword = sb.toString();
			return hashedPassword;
    }
    catch (NoSuchAlgorithmException e)
    {
        e.printStackTrace();
        return hashedPassword;
    }
    }
}


