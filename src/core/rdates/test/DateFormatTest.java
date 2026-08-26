package core.rdates.test;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTest {

    public static void main(String[] args) {
        DateFormat[] formatters = new DateFormat[7];
        
        formatters[0] = DateFormat.getInstance();
        formatters[1] = DateFormat.getDateInstance();
        formatters[2] = DateFormat.getDateTimeInstance();
        
        formatters[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        formatters[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formatters[5] = DateFormat.getDateInstance(DateFormat.LONG);
        formatters[6] = DateFormat.getDateInstance(DateFormat.FULL);

        for (DateFormat df : formatters) {
            System.out.println(df.format(Calendar.getInstance().getTime()));
        }
    }

}
