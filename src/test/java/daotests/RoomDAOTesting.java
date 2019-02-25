package daotests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dao.ReservationDAO;
import dao.RoomDAO;
import model.Reservation;
import model.Room;

public class RoomDAOTesting {
	
	static ReservationDAO rd = new ReservationDAO();
	static RoomDAO rmd = new RoomDAO();
	
//  @BeforeSuite
//  public void setup() {
//	  Reservation reservation = new Reservation(-2, -2, java.sql.Date.valueOf("2011-11-15"), java.sql.Date.valueOf("2011-11-25"));
//	  List<Room> reservedrooms = new ArrayList<Room>();
//	  reservedrooms.add(new Room(0, (byte) 1));
//	  reservedrooms.add(new Room(2, (byte) 1));
////	  reservation.setRooms(reservedrooms);
//	  
//	  rd.createReservation(reservation);
//  }
	
	@Test
  public void testGetAll21Rooms()
  {
	  Assert.assertTrue(rmd.getAvailableRooms("2010-11-15", "2010-11-25").size() == 21);
  }
	
  @Test
  public void testGet19Rooms()
  {
	  Assert.assertTrue(rmd.getAvailableRooms("2011-11-15", "2011-11-25").size() == 19);
  }
}
