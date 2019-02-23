package daotests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.RoomDAO;

public class RoomDAOTesting {
  
	static RoomDAO rd = new RoomDAO();
	
	@Test
  public void testGetAllRooms()
  {
	  Assert.assertTrue(rd.getRooms().size() >= 1);
  }
}
