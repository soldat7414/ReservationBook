package controllers;

import views.ReservationView;

import java.util.Scanner;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class ReservationController {

    public static void addReservation(Scanner scanner){

        ReservationView.addingReservation(scanner);
    }

    public static void deleteReservation(Scanner scanner){
        ReservationView.deleteReservation(scanner);
    }

    public static void getInfo() {
        ReservationView.getInfo();
    }

}
