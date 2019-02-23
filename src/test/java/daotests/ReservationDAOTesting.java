package daotests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.ReservationDAO;
import model.Reservation;

public class ReservationDAOTesting {
  
	static ArrayList al = new ArrayList();
	static Reservation reservation = new Reservation(-1, -1, 111111, 222222, al);
	static ReservationDAO rd = new ReservationDAO();
	
	
	@Test
	public void testCreateReservation() 
	{
		Assert.assertEquals(rd.createReservation(reservation), true);
	}
	
	@Test
	public void testGetAllReservations()
	{
		ArrayList<Reservation> testList= new ArrayList<Reservation>();
		testList.add(reservation);
		Assert.assertTrue(rd.GetAllReservations().size() >= 1);
	}
	
	@Test
	public void testGetAllReservationsByCustomerId()
	{
		ArrayList<Reservation> testList = new ArrayList<Reservation>();
		testList.add(reservation);
		Assert.assertTrue(rd.getAllReservationsByCustomerId(-1).size() == 1);
	}	
}
