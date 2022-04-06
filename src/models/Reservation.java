package models;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class Reservation implements Serializable {
    String name;
    HotelRoom room;
    Data from;
    Data to;
}
