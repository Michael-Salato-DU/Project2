package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Reservation;
import model.Room;
import util.HibernateUtil;

public class RoomDAO implements IRoom{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public ArrayList<Room> getRooms() {
		Session session = sf.openSession();
		
		Criteria criteria = session.createCriteria(Room.class);
		
		List rooms = criteria.list();
		
		session.close();
		return new ArrayList<Room>(rooms);
	}

}
