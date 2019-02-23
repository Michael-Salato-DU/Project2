package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
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
			
			sess.save(r);
			
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

	/*This method returns an ArrayList of all reservations held by a single customer*/
	public ArrayList<Reservation> getAllReservationsByCustomerId(int customer_id)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		Criterion byUsername = Restrictions.eq("customer_id", customer_id);
		criteria.add(byUsername);
		List reservations = criteria.list();
		ArrayList<Reservation> arrayListOfReservations= new ArrayList<Reservation>(reservations);
		return arrayListOfReservations;
	}
	public boolean MakeAReservation(Room r, Reservation rs) {
		
		return false;
	}

}
