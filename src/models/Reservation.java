package models;

import tools.Format;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class Reservation implements Serializable {
    String name;
    HotelRoom room;
    Date from;
    Date to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelRoom getRoom() {
        return room;
    }

    public void setRoom(HotelRoom room) {
        this.room = room;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public long duration() {
        long diff = to.getTime() - from.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return  "имя: " + name + "\n" +
                "номер: " + room + "\n" +
                "дата заезда: " + Format.parseDate(from) + "\n" +
                "дата выезда: " + Format.parseDate(to) + "\n" +
                "время прибывания в отеле: " + duration() + " дней";
    }
}
