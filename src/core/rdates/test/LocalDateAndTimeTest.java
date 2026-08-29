package core.rdates.test;

import java.time.LocalDate;

public class LocalDateAndTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(33, 4, 1);
        LocalDate now = LocalDate.now();

        System.out.println(date);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());
        System.out.println(now);
        System.out.println(now.plusDays(50));
        
    }

}
