package daotests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.RoomDAO;

public class RoomDAOTesting {
  
	static RoomDAO rd = new RoomDAO();
	
	@Test
  public void testGetAllRooms()
  {
	  Assert.assertTrue(rd.getAvailableRooms("2018-11-15", "2018-11-15").size() >= 1);
  }
	
  @Test
  public void testGetAllRoomsFalse()
  {
	  Assert.assertFalse(rd.getAvailableRooms("2017-11-15", "2017-11-25").size() >= 1);
  }
}
