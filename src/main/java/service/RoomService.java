package service;

import java.util.ArrayList;

import dao.RoomDAO;
import model.Room;

public class RoomService {
	
	private static RoomDAO rd = new RoomDAO();
	
	public static ArrayList<Room> getAvailableRooms(String start_date, String end_date) {
		ArrayList<Room> rooms = rd.getAvailableRooms(start_date, end_date);
		return rooms;
	}
}
