package controllers;

import views.ReservationView;

import java.util.Scanner;

public class ReservationController {

    public static void addReservation(Scanner scanner){
        ReservationView.addingReservation(scanner);
    }
    public static void deleteReservation(Scanner scanner){
        ReservationView.deleteReservation(scanner);
    }

}
