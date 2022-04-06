package services;

import data.Hotel;
import exceptions.EmptyInputException;
import models.HotelRoom;
import models.Reservation;
import views.InitializeView;

import java.util.*;

public class HotelService {

    String title;
    private static int numberOfRooms;
    private static double pricePerDay;

    public static void init (Scanner scanner){

        InitializeView.initHotel(scanner);
        numberOfRooms = InitializeView.getNumberOfRooms();
        pricePerDay = InitializeView.getPrice();

        Map<Integer, HotelRoom> hotel = new HashMap<>();
        for(int i = 1; i <= numberOfRooms; i++){
            HotelRoom room = new HotelRoom(i, pricePerDay);
        }
        Hotel.setHotel(hotel);
    }





}
