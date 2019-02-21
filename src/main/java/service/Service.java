package service;

import java.util.ArrayList;

import model.Customer;
import model.Reservation;
import model.Room;

public class Service {
	
	public boolean Register(Customer c)
	{
		return false;
	}
	
	public boolean MakeAReservation(Room r, Reservation rs)
	{
		return false;
	}
	
	public ArrayList<Reservation> GetAllReservations()
	{
		ArrayList<Reservation> al = new ArrayList();
		return al;
	}
	
	public boolean Login(String username, String password)
	{
		return false;
	}
	
	public ArrayList<Room> getRooms()
	{
		ArrayList<Room> al = new ArrayList();
		return al;
	}
	
	public String HashPassword(String password)
	{
		return null;
	}
	
}

