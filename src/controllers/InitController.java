package controllers;

import data.Hotel;
import models.HotelRoom;
import services.HotelService;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class InitController {
    private static final String FILE_HOTEL_NAME = "hotel.dat";
    private static final String FILE_TITLE_NAME = "title.dat";

    public static void init(Scanner scanner){
        if(isThereSaved()){
            restore();
        } else {
            HotelService.init(scanner);
        }
    }

    public static void save (){
        boolean hotel = false;
        boolean title = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_HOTEL_NAME)))
        {
            oos.writeObject(Hotel.getHotel());
            hotel = true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_TITLE_NAME)))
        {
            oos.writeObject(Hotel.getTitle());
            title = true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        if(hotel &&  title) System.out.println("Сохранено.");
    }

    public static void restore (){
        boolean hotel = false;
        boolean title = false;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_HOTEL_NAME)))
        {
            Hotel.setHotel((Map<Integer, HotelRoom>)ois.readObject());
            hotel = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_TITLE_NAME)))
        {
            Hotel.setTitle((String)ois.readObject());
            title = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        if(hotel && title) System.out.println("Загружен отель \"");
    }

    public static void deleteSaves () {
        new File(FILE_HOTEL_NAME).delete();
        new File(FILE_TITLE_NAME).delete();
        System.out.println("Сохраненные данные об отеле удалены.");
    }

    public static boolean isThereSaved (){
        if(new File(FILE_HOTEL_NAME).exists() && new File(FILE_TITLE_NAME).exists()) return true;
        return false;
    }
}
