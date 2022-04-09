package tools;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public static Date format (String dateS) throws ParseException {
        String formatDate = "";
        formatDate += dateS.substring(0,2);
        formatDate += "-";
        formatDate += dateS.substring(3,5);
        formatDate += "-";
        formatDate += dateS.substring(6);
        //sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.parse(formatDate);
    }

    public static String parseDate (Date date){
        return sdf.format(date);
    }
    public static Date parseDate (String date) {
        Date d = null;
        try{
             d = sdf.parse(date);
        }catch (ParseException pe){
            System.out.println(pe);
        }
        return d;
    }

    public static String roundValue(double value){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }
}
