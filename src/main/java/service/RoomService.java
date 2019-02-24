package service;

import java.util.ArrayList;

import dao.RoomDAO;
import model.Room;

public class RoomService {
	
	private static RoomDAO rd = new RoomDAO();
	
	public static ArrayList<Room> getRooms() {
		ArrayList<Room> rooms = rd.getRooms();
		RoomDAO rd = new RoomDAO ();
		rooms = rd.getRooms();
		return rooms;
	}
}
