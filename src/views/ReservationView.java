package views;

import data.Hotel;
import models.FromTo;
import services.HotelService;
import services.InputService;
import services.ReservationService;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservationView {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void addingReservation(Scanner scanner){
        String message = "У нас в отеле \"" + Hotel.getTitle() + "\"" + " " + Hotel.getQuantityOfRooms() + " номеров,";
        System.out.println(message);
        message = "Выберите один из них для бронирования!";
        System.out.println(message);
        message = "Введите число от 1 до " + Hotel.getQuantityOfRooms();
        int number = InputService.getNumberOfRoom(scanner, message);
        message = "Вы выбрали номер " + number + " с ценой за сутки: " + HotelService.getPriceFoRoom(number) + " грн.";
        System.out.println(message);
        message = "Этот номкр доступен для бронирования в следующие периоды в этом году:";
        System.out.println(message);
        message = ReservationService.AvailableForReserve(number);
        System.out.println(message);
        message = "Выберите дату въезда в доступном промежутке: ";
        System.out.print(message);
        FromTo from = InputService.getArriveDate(scanner, message, Hotel.getHotel().get(number).getReserved());


    }




}
