package services;

import exceptions.EmptyInputException;
import models.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelService {

    String title;
    private int numberOfRooms;
    private double pricePerDay;

    public static void init (Scanner scanner){

    }

    private static Scanner isEmpty (Scanner scanner) throws EmptyInputException{
       if(!scanner.hasNext()) throw new EmptyInputException("Вы не ввели значение!");
       return scanner;
    }



}
