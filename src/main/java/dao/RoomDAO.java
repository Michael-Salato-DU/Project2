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
		
		String sql = "SELECT room_id, number_of_beds\r\n" + 
					"FROM room\r\n" + 
					"WHERE room_id NOT IN (\r\n" + 
					"    SELECT UNIQUE room.room_id\r\n" + 
					"    FROM room\r\n" + 
					"    INNER JOIN reservation_room\r\n" + 
					"    ON room.room_id = reservation_room.rooms_room_id\r\n" + 
					"    INNER JOIN reservation\r\n" + 
					"    ON reservation.reservation_id = reservation_room.reservations_reservation_id\r\n" + 
					"    WHERE (? BETWEEN start_date AND end_date)\r\n" + 
					"    OR (? BETWEEN start_date AND end_date)\r\n" + 
					"    OR (start_Date BETWEEN ? AND ?)\r\n" + 
					"    OR (end_date BETWEEN ? AND ?)\r\n" + 
					")\r\n" + 
					"ORDER BY room_id";
		
		SQLQuery sq = session.createSQLQuery(sql);
		
		// convert dates as strings to Date data types
		java.sql.Date start = java.sql.Date.valueOf(start_date);
		java.sql.Date end = java.sql.Date.valueOf(end_date);
		
		// set start and end parameters
		sq.setParameter(0, start);
		sq.setParameter(1, end);
		sq.setParameter(2, start);
		sq.setParameter(3, end);
		sq.setParameter(4, start);
		sq.setParameter(5, end);
	
		List rooms = sq.list();
		
		
		session.close();
		return new ArrayList<Room>(rooms);
	}

}
