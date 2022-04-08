package controllers;

import views.ReservationView;

import java.util.Scanner;

public class ReservationController {
    static Scanner scanner = new Scanner(System.in);
    public static void addReservation(){
        //Scanner scanner = new Scanner(System.in);
        ReservationView.addingReservation(scanner);
//        scanner.close();
    }
    public static void deleteReservation(){
//        Scanner scanner = new Scanner(System.in);
        ReservationView.deleteReservation(scanner);
//        scanner.close();
    }

}
