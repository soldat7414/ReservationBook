package models;

import tools.Format;

import java.util.Date;

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
        return "c" + Format.parseDate(from) + " до " + Format.parseDate(to) +"\n";
    }
}
