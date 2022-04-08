package application;

import controllers.InitController;
import data.Hotel;
import models.HotelRoom;
import models.Reservation;
import views.ReservationView;

import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        //InitController.deleteSaves();
        InitController.init();
        if(!InitController.isThereSaved()){
        InitController.save();}
        InitController.addReservation();

        System.out.println("Отель " + "\""+ Hotel.getTitle()+"\"");
        Set<Map.Entry<Integer, HotelRoom>> rooms = Hotel.getHotel().entrySet();
        for(Map.Entry<Integer, HotelRoom> me : rooms){
            System.out.println(me.getValue().toString());
            for(Reservation reservation : me.getValue().getReserved()){
                System.out.println(reservation);
            }
        }
        InitController.deleteSaves();
        InitController.save();


    }
}
