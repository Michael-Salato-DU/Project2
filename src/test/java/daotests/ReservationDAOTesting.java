package daotests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.ReservationDAO;
import model.Reservation;

public class ReservationDAOTesting {
  
	static ArrayList al = new ArrayList();
	static Reservation reservation = new Reservation(-1, -1, 111111, 222222, al);
	static ReservationDAO rd = new ReservationDAO();
	
	
	@Test(priority = 0)
	public void testCreateReservation() 
	{
		Assert.assertEquals(rd.createReservation(reservation), true);
	}
	
	@Test(priority = 1)
	public void testGetAllReservations()
	{
		ArrayList<Reservation> testList= new ArrayList<Reservation>();
		testList.add(reservation);
		Assert.assertTrue(rd.GetAllReservations().size() >= 1);
	}
	
	@Test(priority = 2)
	public void testGetAllReservationsByCustomerId()
	{
		ArrayList<Reservation> testList = new ArrayList<Reservation>();
		testList.add(reservation);
		Assert.assertTrue(rd.getAllReservationsByCustomerId(-1).size() == 1);
	}	
	
	@Test(priority = 3)
	public void testDelete()
	{
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		int reservation_id = -1;
		reservations = rd.getAllReservationsByCustomerId(-1);
		Reservation reservation = reservations.get(0);
		reservation_id = reservation.getReservation_id();
		Assert.assertTrue(rd.deleteReservation(reservation_id));
	}
}