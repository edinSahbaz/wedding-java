package Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String getDateInFormat(Date date, String dateFromat) {
        DateFormat formatter = new SimpleDateFormat(dateFromat);
        String dateOutput = formatter.format(date);

        return dateOutput;
    }
}
