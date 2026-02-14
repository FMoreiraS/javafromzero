package core.rdates.test;

import java.util.Calendar;
import java.util.Date;

public class DateAndCalendarTest {
    public static void main(String[] args) {
        Date date = new Date();
        date.setTime(1_000_000_000_000L);
        
        System.out.println(date);

        Calendar c = Calendar.getInstance();
        date = c.getTime();
        System.out.println("Data atual: " + date);
        
        c.add(Calendar.DAY_OF_MONTH, 2);
        c.add(Calendar.HOUR, 2);
        date = c.getTime();
        System.out.println("Data atual + 2 dias e 2 horas: " + date);
    }
}
