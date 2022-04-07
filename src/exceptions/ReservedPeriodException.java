package exceptions;

import models.FromTo;

public class ReservedPeriodException extends Exception {
    FromTo reservedPeriod;
    public ReservedPeriodException (String message, FromTo reservedPeriod){
        super(message);
        this.reservedPeriod = reservedPeriod;
    }

    public FromTo getReservedPeriod() {
        return reservedPeriod;
    }
}
