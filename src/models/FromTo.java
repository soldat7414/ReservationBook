package models;

import tools.Format;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Soldatenko Ihor
 * @version 1.0.0
 */

public class FromTo {
    Date from;
    Date to;
    public FromTo(Date from, Date to){
        this.from = from;
        this.to = to;
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

    @Override
    public String toString() {
        return "c " + Format.parseDate(from) + " до " + Format.parseDate(to) +"\n";
    }
    public long duration() {
        long diff = to.getTime() - from.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
