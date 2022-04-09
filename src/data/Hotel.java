package data;

import models.HotelRoom;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */


public class Hotel implements Serializable {
    private static String title;
    private static int quantityOfRooms;
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

    public static int getQuantityOfRooms() {
        return quantityOfRooms;
    }

    public static void setNumberOfRooms(int numberOfRooms) {
        Hotel.quantityOfRooms = numberOfRooms;
    }
}
