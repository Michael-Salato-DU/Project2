package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.Customer;
import model.Reservation;
import model.Room;
import util.HibernateUtil;
import util.JDBCConnection;

public class RoomDAO implements IRoom{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	/*
	 * public ArrayList<Room> getAvailableRooms(String start_date, String end_date)
	 * { Session session = sf.openSession();
	 * 
	 * String sql = "SELECT room_id, number_of_beds\r\n" + "FROM room\r\n" +
	 * "WHERE room_id NOT IN (\r\n" + "    SELECT UNIQUE room.room_id\r\n" +
	 * "    FROM room\r\n" + "    INNER JOIN reservation_room\r\n" +
	 * "    ON room.room_id = reservation_room.rooms_room_id\r\n" +
	 * "    INNER JOIN reservation\r\n" +
	 * "    ON reservation.reservation_id = reservation_room.reservations_reservation_id\r\n"
	 * + "    WHERE (? BETWEEN start_date AND end_date)\r\n" +
	 * "    OR (? BETWEEN start_date AND end_date)\r\n" +
	 * "    OR (start_Date BETWEEN ? AND ?)\r\n" +
	 * "    OR (end_date BETWEEN ? AND ?)\r\n" + ")\r\n" + "ORDER BY room_id";
	 * 
	 * SQLQuery sq = session.createSQLQuery(sql);
	 * 
	 * // convert dates as strings to Date data types java.sql.Date start =
	 * java.sql.Date.valueOf(start_date); java.sql.Date end =
	 * java.sql.Date.valueOf(end_date);
	 * 
	 * // set start and end parameters sq.setParameter(0, start); sq.setParameter(1,
	 * end); sq.setParameter(2, start); sq.setParameter(3, end); sq.setParameter(4,
	 * start); sq.setParameter(5, end);
	 * 
	 * List rooms = sq.list();
	 * 
	 * 
	 * session.close(); return new ArrayList<Room>(rooms); }
	 */
	
public ArrayList<Room> getAvailableRooms(String start_date, String end_date) {
		
		ArrayList<Room> availableRooms = new ArrayList<Room>();
        try {
        	// prepare an SQL statement
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
        	
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// convert dates as strings to Date data types
			java.sql.Date start = java.sql.Date.valueOf(start_date);
			java.sql.Date end = java.sql.Date.valueOf(end_date);
			
			ps.setDate(1, start);
			ps.setDate(2, end);
			ps.setDate(3, start);
			ps.setDate(4, end);
			ps.setDate(5, start);
			ps.setDate(6, end);
			
			// get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make a pizza object
            	// then add the pizza to the pizzas list
            	availableRooms.add(new Room(
        			rs.getInt("room_id"),
					rs.getByte("number_of_beds")
				));
			}
            
            return availableRooms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}


	
	public Room getRoom(int room_id)
	{
		Room room = new Room();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Room.class);
			Criterion selectRoom = Restrictions.eq("room_id", room_id);
			criteria.add(selectRoom);
			room = (Room)criteria.uniqueResult();
			session.close();
			return room;
		}catch(HibernateException e) {
			e.printStackTrace();
			return room;
		}
	}

}
