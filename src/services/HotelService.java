package services;

import data.Hotel;
import models.HotelRoom;
import views.InitializeView;

import java.util.*;

public class HotelService {

    String title;
    private static int quantityOfRooms;
    private static double pricePerDay;


    public static void init (Scanner scanner){

        InitializeView.initHotel(scanner);
        quantityOfRooms = InitializeView.getQuantityOfRooms();
        pricePerDay = InitializeView.getPrice();
        Hotel.setNumberOfRooms(quantityOfRooms);

        Map<Integer, HotelRoom> hotel = new HashMap<>();
        for(int i = 1; i <= quantityOfRooms; i++){
            HotelRoom room = new HotelRoom(i, pricePerDay);
            hotel.put(i, room);
        }

        Hotel.setHotel(hotel);
    }

    public static double getPriceFoRoom (int number){
        return Hotel.getHotel().get(number).getPrice();
    }

}
