package dao;

import java.util.ArrayList;

import model.Reservation;
import model.Room;

public interface IReservation {
	boolean createReservation(Reservation r);
	ArrayList<Reservation> GetAllReservations();
	boolean deleteReservation(int reservation_id);
}
