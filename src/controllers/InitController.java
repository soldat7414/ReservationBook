package controllers;

import data.Hotel;
import data.ReservationBook;
import models.HotelRoom;
import models.Reservation;
import services.HotelService;
import services.ReservationBookService;
import views.ReservationView;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InitController {
    private static final String FILE_HOTEL_NAME = "hotel.dat";
    private static final String FILE_BOOK_NAME = "reservationBook.dat";
    private static final String FILE_TITLE_NAME = "title.dat";

    public static void init(Scanner scanner){
        if(isThereSaved()){
            restore();
        } else {
            HotelService.init(scanner);
            ReservationBookService.init();
        }
    }

    public static void save (){
        boolean hotel = false;
        boolean book = false;
        boolean title = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_HOTEL_NAME)))
        {
            oos.writeObject(Hotel.getHotel());
            //System.out.println("File has been written");
            hotel = true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_BOOK_NAME)))
        {
            oos.writeObject(ReservationBook.getReservationBook());
            //System.out.println("File has been written");
            book = true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_TITLE_NAME)))
        {
            oos.writeObject(Hotel.getTitle());
            title = true;
            //System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        if(hotel && book && title) System.out.println("Сохранено.");
    }

    public static void restore (){
        boolean hotel = false;
        boolean book = false;
        boolean title = false;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_HOTEL_NAME)))
        {
            Hotel.setHotel((Map<Integer, HotelRoom>)ois.readObject());
            //System.out.println("Hotel download");
            hotel = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_BOOK_NAME)))
        {
            ReservationBook.setReservationBook((Map<Integer, List<Reservation>>)ois.readObject());
            book = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_TITLE_NAME)))
        {
            Hotel.setTitle((String)ois.readObject());
           // System.out.println("Hotel title download");
            title = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        if(hotel && book && title) System.out.println("Загружен отель \"");
    }

    public static void deleteSaves () {
        new File(FILE_HOTEL_NAME).delete();
        new File(FILE_BOOK_NAME).delete();
        new File(FILE_TITLE_NAME).delete();
        System.out.println("Сохраненные данные об отеле удалены.");
    }

    public static boolean isThereSaved (){
        boolean isHere = false;
        if(new File(FILE_HOTEL_NAME).exists() && new File(FILE_BOOK_NAME).exists() && new File(FILE_TITLE_NAME).exists()) return true;
        return false;
    }



}
