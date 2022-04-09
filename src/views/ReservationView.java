package views;

import data.Hotel;
import models.FromTo;
import models.Reservation;
import services.HotelService;
import services.InputService;
import services.ReservationService;
import tools.Format;

import java.text.SimpleDateFormat;
import java.util.List;
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
        //System.out.print(message);
        message = "Чтоб сохранить запись введите s: ";
        //System.out.print(message);
        String s = InputService.txt(scanner, message);
        if(s.equals("s")) ReservationService.save(reservation);
    }

    public static void deleteReservation(Scanner scanner){
        String message;
        message = "Выберите номер комнаты, где Вы хотели бы удалить запись о резервации: ";
        int number = InputService.getNumberOfRoom(scanner, message);
        message = "В комнате №" + number+ " следующие записи о резервации:";
        System.out.println(message);
        List<Reservation> reservations = Hotel.getHotel().get(number).getReserved();
        if(reservations.size() == 0) {
            System.out.println("В данном номере нет ни одний записи о резервации.");
            return;
        }
        int count = 1;
        for (Reservation reserv : reservations){
            System.out.println(count + " " + reserv);
            count++;
        }
        message = "Выберите номер записи о резервации, который хотите удалить: ";
        int delNum = InputService.inputIntInRange(scanner, message, reservations.size());
        message = "Вы собираетесь удалить запись:";
        System.out.println(message);
        System.out.println(reservations.get(delNum-1));
        message = "Чтоб удалить запись введите d: ";
        String s = InputService.txt(scanner, message);
        if(s.equals("d")) ReservationService.delete(reservations.get(delNum-1));

    }

    public static void getInfo () {
        System.out.println(HotelService.getInfo());
    }






}
