package service;

import java.util.ArrayList;

import dao.ReservationDAO;
import model.Reservation;
import model.Room;

public class ReservationService {
	
	private static ReservationDAO rd = new ReservationDAO();
	
	public static boolean createReservation(Reservation r) {
		return rd.createReservation(r);
	}
	
	public static ArrayList<Reservation> GetAllReservations() {
		ArrayList<Reservation> reservations = rd.GetAllReservations();
		return reservations;
	}
	
	
	public static ArrayList<Reservation> getAllReservationsByCustomerId(int customer_id)
	{
		ArrayList<Reservation> listOfReservations = rd.getAllReservationsByCustomerId(customer_id);
		return listOfReservations;
	}
	
	public static boolean deleteReservation(int reservation_id) {
		return rd.deleteReservation(reservation_id);
	}
	

}
