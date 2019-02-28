package model;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Reservation {
	@Id
	@GeneratedValue
	private int reservation_id;
	private int customer_id;
	@Basic
	private java.sql.Date start_date;
	@Basic
	private java.sql.Date end_date;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Room> rooms = new ArrayList<Room>();

	/**
	 * @param reservation_id
	 * @param customer_id
	 * @param start_date
	 * @param end_date
	 * @param rooms
	 */
	public Reservation(int reservation_id, int customer_id, java.sql.Date start_date, java.sql.Date end_date) {
		super();
		this.reservation_id = reservation_id;
		this.customer_id = customer_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public Reservation()
	{
		super();
		customer_id = -1;
		start_date = java.sql.Date.valueOf("2017-11-15");
		end_date = java.sql.Date.valueOf("2017-11-15");		
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public java.sql.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.sql.Date start_date) {
		this.start_date = start_date;
	}

	public java.sql.Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(java.sql.Date end_date) {
		this.end_date = end_date;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}
