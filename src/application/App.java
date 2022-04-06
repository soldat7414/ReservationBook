package application;

import controllers.InitController;
import data.Hotel;
import models.HotelRoom;

import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        //InitController.init();
        InitController.restore();
        System.out.println("Отель " + Hotel.getTitle());
        Set<Map.Entry<Integer, HotelRoom>> rooms = Hotel.getHotel().entrySet();
        for(Map.Entry<Integer, HotelRoom> me : rooms){
            System.out.println(me.getValue().toString());
        }
        //InitController.save();

    }
}
