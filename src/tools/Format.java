package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    public static Date format (String dateS) throws ParseException {
        String formatDate = "";
        formatDate += dateS.substring(0,2);
        formatDate += "/";
        formatDate += dateS.substring(3,5);
        formatDate += "/";
        formatDate += dateS.substring(6);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(formatDate);
    }
}
