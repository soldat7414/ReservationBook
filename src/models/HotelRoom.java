package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class HotelRoom implements Serializable {

    private int number;
    private double price;
    private List<Reservation> reserved = new ArrayList<>();

    public HotelRoom (int number, double price){
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Комната №" + number +"\nцена за сутки, грн.: " + price;
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
