package views;

import data.Hotel;
import models.FromTo;
import models.Reservation;
import services.HotelService;
import services.InputService;
import services.ReservationService;
import tools.Format;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ReservationView {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void addingReservation(Scanner scanner){
        String message;
        message = "Введите, пожалуйста Ваше имя: ";
        String name = InputService.txt(scanner, message);
        int quantityOfRooms = Hotel.getHotel().size();
        message = "У нас в отеле \"" + Hotel.getTitle() + "\"" + " " + quantityOfRooms + " номеров,";
        System.out.println(message);
        message = "Выберите один из них для бронирования!";
        System.out.println(message);
        message = "Введите число от 1 до " + quantityOfRooms;
        int number = InputService.getNumberOfRoom(scanner, message);
        message = "Вы выбрали номер " + number + " с ценой за сутки: " + HotelService.getPriceFoRoom(number) + " грн.";
        System.out.println(message);
        message = "Этот номер доступен для бронирования в следующие периоды в этом году:";
        System.out.println(message);
        message = ReservationService.availableForReserve(number);
        System.out.println(message);
        message = "Выберите дату въезда в доступном промежутке: ";
        //System.out.print(message);
        FromTo fromRange = InputService.getArriveDate(scanner, message, Hotel.getHotel().get(number).getReserved());
        message = "Выберите дату выезда до " + Format.parseDate(fromRange.getTo());
        FromTo fromTo = InputService.getOutDate(scanner,message, fromRange);

        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setRoom(Hotel.getHotel().get(number));
        reservation.setFrom(fromTo.getFrom());
        reservation.setTo(fromTo.getTo());

        message = "Проверьте, пожалуйста, данные резерва:";
        System.out.println(message);
        System.out.println(reservation.toString());
        System.out.println("Стоимость прибывания составит: " + reservation.getRoom().getPrice()*reservation.duration());
        message = "Чтоб сохранить резерв введите букву s: ";
        System.out.print(message);
        if(InputService.txt(scanner, message).equals("s")) ReservationService.save(reservation);



    }




}
