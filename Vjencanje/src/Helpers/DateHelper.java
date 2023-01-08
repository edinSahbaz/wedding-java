package Helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String getDateInFormat(Date date, String dateFromat) {
        DateFormat formatter = new SimpleDateFormat(dateFromat);
        String dateOutput = formatter.format(date);

        return dateOutput;
    }

    public static Date getDateFromString(String dateString) {
        try {
            Date output = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            return output;
        } catch(ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
