package data;

import models.HotelRoom;
import models.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReservationBook {

    private static Map<Integer, List<Reservation>> reservationBook;

    public static Map<Integer, List<Reservation>> getReservationBook() {
        return reservationBook;
    }

    public static void setReservationBook(Map<Integer, List<Reservation>> reservationBook) {
        ReservationBook.reservationBook = reservationBook;
    }
}
