package models;

import data.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRoom {

    private int number;
    private double price;
    List<Reservation> reserved = new ArrayList<>();

    public HotelRoom (int number, double price){
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Reservation> getReserved() {
        return reserved;
    }

    public void setReserved(List<Reservation> reserved) {
        this.reserved = reserved;
    }
}
