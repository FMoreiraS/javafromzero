package core.rdates.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String pattern = "hh:mm 'de' d 'de' MMMM 'de' yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        String formattedDate = dateFormat.format(new Date());
        System.out.println(formattedDate);
        try {
            System.out.println(dateFormat.parse(formattedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
