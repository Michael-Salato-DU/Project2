package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customer_id;
	private String first_name;
	private String last_name;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	private String phone_number;
	private String address;
	
	@OneToMany
	private List<Reservation> reservations;
	
	public Customer(int customer_id, String first_name, String last_name, String username, String password,
			String email, String phone_number, String address) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}
	
	public Customer()
	{
		super();
		customer_id = -1;
		first_name = "first_name";
		last_name = "last_name";
		username = "USERNAMEUSERNAME";
		password = "password";
		email = "email@email.com";
		phone_number = "phone_number";
		address = "address";
	}

	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", phone_number=" + phone_number + ", address="
				+ address + "]";
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
