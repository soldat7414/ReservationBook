package data;

import models.HotelRoom;
import models.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReservationBook {

    private static Map<Integer, List<Reservation>> reservationBook = new HashMap<>();


    public static void initial (){

        Set<Map.Entry<Integer, HotelRoom>> rooms = Hotel.getHotel().entrySet();
        for(Map.Entry<Integer, HotelRoom> me : rooms){
            reservationBook.put(me.getKey(), me.getValue().getReserved());
        }
    }


}
