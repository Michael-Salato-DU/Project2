package dao;

import java.util.ArrayList;

import model.Reservation;

public interface IReservation {
	boolean createReservation(Reservation r);
	ArrayList<Reservation> GetAllReservations();
	boolean deleteReservation(int reservation_id);
	Reservation getReservation(int reservation_id);
}
