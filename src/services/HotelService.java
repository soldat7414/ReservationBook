package services;

import data.Hotel;
import models.HotelRoom;
import models.Reservation;
import tools.Format;
import views.InitializeView;
import java.util.*;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class HotelService {


    public static void init (Scanner scanner) {

        InitializeView.initHotel(scanner);
        int quantityOfRooms = InitializeView.getQuantityOfRooms();
        double pricePerDay = InitializeView.getPrice();
        Hotel.setNumberOfRooms(quantityOfRooms);

        Map<Integer, HotelRoom> hotel = new HashMap<>();
        for(int i = 1; i <= quantityOfRooms; i++){
            HotelRoom room = new HotelRoom(i, pricePerDay);
            hotel.put(i, room);
        }
        Hotel.setHotel(hotel);
    }

    public static double getPriceFoRoom (int number){
        return Hotel.getHotel().get(number).getPrice();
    }

    public static String getInfo () {
        Set<Map.Entry<Integer, HotelRoom>> hotel = Hotel.getHotel().entrySet();
        String info = "";
        info += "Отель \"" + Hotel.getTitle() + "\"\n";
        info += "В нем размещено " + Hotel.getHotel().size() + " комнат:\n\n";
        for (Map.Entry<Integer, HotelRoom> me : hotel){
            info += "Комната №" + me.getKey() + ", стоимость за сутки - " + me.getValue().getPrice() + " грн. \n";
            if(me.getValue().getReserved().isEmpty()) {
                info += "В этом номере еще нет записей о резервации.\n";
            }else{
                info += "Сейчас зарезервировано:\n";
                int count = 1;
                for(Reservation res : me.getValue().getReserved()){
                    double costOfReservation = res.duration() * me.getValue().getPrice();
                    info += count + ". с " + Format.parseDate(res.getFrom()) + " до " + Format.parseDate(res.getTo()) +
                            ". Стоимость проживания - " + Format.roundValue(costOfReservation) + " грн.;\n";
                    count++;
                }
            }
            info += "---------------------------------------------\n";
        }
        return info;
    }
}
