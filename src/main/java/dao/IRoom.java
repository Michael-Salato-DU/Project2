package dao;

import java.util.ArrayList;

import model.Room;

public interface IRoom {
	ArrayList<Room> getAvailableRooms(String start_date, String end_date);
}
