package data;

import models.HotelRoom;
import java.util.HashMap;
import java.util.Map;


public class Hotel {
    private static String title;
    static Map<Integer, HotelRoom> hotel = null;

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Hotel.title = title;
    }

    public static Map<Integer, HotelRoom> getHotel() {
        return hotel;
    }

    public static void setHotel(Map<Integer, HotelRoom> hotel) {
        Hotel.hotel = hotel;
    }
}
