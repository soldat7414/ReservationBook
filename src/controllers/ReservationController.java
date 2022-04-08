package controllers;

import views.ReservationView;

import java.util.Scanner;

public class ReservationController {
    public static void addReservation(){
        Scanner scanner = new Scanner(System.in);
        ReservationView.addingReservation(scanner);
        scanner.close();
    }

}
