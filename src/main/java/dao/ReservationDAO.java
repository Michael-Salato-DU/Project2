package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import model.Reservation;
import model.Room;
import util.HibernateUtil;

public class ReservationDAO implements IReservation{
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	/**
	 * creates a reservation in the DB
	 */
	public boolean createReservation(Reservation r) {
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			sess.persist(r);
			
			sess.getTransaction().commit();
			sess.close();
			
			return true;
			
		} catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * returns a list of all reservations from the DB
	 */
	public ArrayList<Reservation> GetAllReservations() {
		
		Session sess = sf.openSession();
		
		Criteria crit = sess.createCriteria(Reservation.class);
		
		List reservations = crit.list();
		
		sess.close();
		return new ArrayList<Reservation>(reservations);		
	}
	
	/**
	 * deletes a reservation from the DB
	 */
	public boolean deleteReservation(int reservation_id) {
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Reservation reservation = sess.get(Reservation.class, reservation_id);
			sess.delete(reservation);
			
			sess.getTransaction().commit();
			sess.close();
			
			return true;
		} catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}
	}

	/**
	 * returns a single reservation from the DB
	 */
	public Reservation getReservation(int reservation_id) {
		
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Reservation reservation = sess.get(Reservation.class, reservation_id);
		
		sess.getTransaction().commit();
		sess.close();
		
		return reservation;
	}

	public boolean MakeAReservation(Room r, Reservation rs) {
		
		return false;
	}

}
