package models;

import java.util.ArrayList;
import java.util.List;

public class HotelRoom {

    private int number;
    private int price;
    List<Reservation> reserved = new ArrayList<>();
}
