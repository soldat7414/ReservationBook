package services;

import data.Hotel;
import data.ReservationBook;
import models.HotelRoom;
import models.Reservation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReservationBookService {

    public static void init (){
        Map<Integer, List<Reservation>> reservationBook = new HashMap<>();
        Set<Map.Entry<Integer, HotelRoom>> rooms = Hotel.getHotel().entrySet();
        for(Map.Entry<Integer, HotelRoom> me : rooms){
            reservationBook.put(me.getKey(), me.getValue().getReserved());
        }
        ReservationBook.setReservationBook(reservationBook);
    }
}
