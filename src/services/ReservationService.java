package services;

import data.Hotel;
import data.ReservationBook;
import models.FromTo;
import models.HotelRoom;
import models.Reservation;
import tools.Format;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    private static String title = Hotel.getTitle();

    public static void addReservation(Scanner scanner){

        Reservation reservation = new Reservation();

        String message = "У нас в отеле \"" + title + "\"" + " " + Hotel.getQuantityOfRooms();
        System.out.println(message);
        message = "Выберите один из них дял бронирования!";
        System.out.println(message);



    }

    public static List<FromTo> availablePeriods (int number){
        HotelRoom room = Hotel.getHotel().get(number);
        Date now = new Date();
        Date andOfYear = Format.parseDate("31-12-2022");
        List<FromTo> available = new ArrayList<>();
        List<Reservation> reserv = room.getReserved();
        if(reserv.isEmpty()) {
            available.add(new FromTo(now, andOfYear));
            return available;
        }else if(reserv.size() == 1){
            available.add(new FromTo(now, reserv.get(0).getFrom()));
            available.add(new FromTo(reserv.get(0).getTo(), andOfYear));
            return available;
        }
        if(now.getTime() < reserv.get(0).getFrom().getTime())available.add(new FromTo(now, reserv.get(0).getFrom()));
        for (int i = 0; i < reserv.size()-1; i++){
            Date from = reserv.get(i).getTo();
            Date to;
            if(i <= reserv.size()-2) {
                to = andOfYear;
            }else{
                to = reserv.get(i+1).getFrom();
            }
            available.add(new FromTo(from, to));
        }
        return available;
    }

    public static String availableForReserve(int number){
       List<FromTo> list = availablePeriods(number);
       String available = "";
       for (FromTo ft : list){
           available += ft.toString();
       }
       return available;

    }

    public static void save (Reservation reservation){
        int room = reservation.getRoom().getNumber();
        ReservationBook.getReservationBook().get(room).add(reservation);
        Hotel.getHotel().get(room).getReserved().add(reservation);
    }

    public static void delete (Reservation reservation){
        int room = reservation.getRoom().getNumber();
        ReservationBook.getReservationBook().get(room).remove(reservation);
        Hotel.getHotel().get(room).getReserved().remove(reservation);
    }
}
