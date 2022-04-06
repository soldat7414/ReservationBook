package controllers;

import data.Hotel;
import data.ReservationBook;
import models.HotelRoom;
import models.Reservation;
import services.HotelService;
import services.ReservationBookService;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InitController {
    private static final String FILE_HOTEL_NAME = "hotel.dat";
    private static final String FILE_BOOK_NAME = "reservationBook.dat";
    private static final String FILE_TITLE_NAME = "title.dat";

    public static void init(){
        if(isThereSaved()){
            restore();
        } else {
            Scanner scanner = new Scanner(System.in);
            HotelService.init(scanner);
            ReservationBookService.init();
        }
    }

    public static void save (){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_HOTEL_NAME)))
        {
            oos.writeObject(Hotel.getHotel());
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_BOOK_NAME)))
        {
            oos.writeObject(ReservationBook.getReservationBook());
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_TITLE_NAME)))
        {
            oos.writeObject(Hotel.getTitle());
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void restore (){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_HOTEL_NAME)))
        {
            Hotel.setHotel((Map<Integer, HotelRoom>)ois.readObject());
            System.out.println("Hotel download");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_BOOK_NAME)))
        {
            ReservationBook.setReservationBook((Map<Integer, List<Reservation>>)ois.readObject());
            System.out.println("Reservation book download");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_TITLE_NAME)))
        {
            Hotel.setTitle((String)ois.readObject());
            System.out.println("Hotel title download");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteSaves () {
        new File(FILE_HOTEL_NAME).delete();
        new File(FILE_BOOK_NAME).delete();
        new File(FILE_TITLE_NAME).delete();
        System.out.println("Сохраненные данные об отеле удалены.");
    }

    private static boolean isThereSaved (){
        boolean isHere = false;
        if(new File(FILE_HOTEL_NAME).exists() && new File(FILE_BOOK_NAME).exists() && new File(FILE_TITLE_NAME).exists()) return true;
        return false;
    }

}
