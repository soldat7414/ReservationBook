package controllers;

import services.HotelService;
import services.ReservationBookService;

import java.util.Scanner;

public class InitController {

    public static void init(){
        Scanner scanner = new Scanner(System.in);
        HotelService.init(scanner);
        ReservationBookService.init();
    }
}
