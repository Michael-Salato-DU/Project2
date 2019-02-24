package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Reservation;
import model.Room;
import util.HibernateUtil;

public class RoomDAO implements IRoom{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public ArrayList<Room> getAvailableRooms(String start_date, String end_date) {
		Session session = sf.openSession();
		
		String sql = "SELECT room.room_id, number_of_beds " + 
				"FROM " + 
				"room " + 
				"INNER JOIN reservation_room " + 
				"ON room.room_id = reservation_room.room_id " + 
				"INNER JOIN reservation " + 
				"ON resevation.reservation_id = reservation_room.reservation_id " + 
				"WHERE (? NOT BETWEEN start_date AND end_date) " + 
				"AND (? NOT BETWEEN start_date AND end_date)";
		
		SQLQuery sq = session.createSQLQuery(sql);
		
		// convert dates as strings to Date data types
		java.sql.Date start = java.sql.Date.valueOf(start_date);
		java.sql.Date end = java.sql.Date.valueOf(end_date);
		
		// set start and end parameters
		sq.setParameter(0, start);
		sq.setParameter(1, end);
	
		List rooms = sq.list();
		
		session.close();
		return new ArrayList<Room>(rooms);
	}

}
