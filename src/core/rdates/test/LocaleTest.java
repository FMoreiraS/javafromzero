package core.rdates.test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {
        // Locale com datas
        Locale localeItaly = Locale.of("it", "IT");
        Locale localeJapan = Locale.of("ja", "JP");
        Locale localeBrazil = Locale.of("pt", "BR");
        Calendar calendar = Calendar.getInstance();

        DateFormat format1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat format2 = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);
        DateFormat format3 = DateFormat.getDateInstance(DateFormat.FULL, localeBrazil);
        
        System.out.println(format1.format(calendar.getTime()));
        System.out.println(format2.format(calendar.getTime()));
        System.out.println(format3.format(calendar.getTime()));

        // Formatação de números
        NumberFormat nf1 = NumberFormat.getInstance(localeItaly);
        NumberFormat nf2 = NumberFormat.getInstance(localeJapan);
        NumberFormat nf3 = NumberFormat.getInstance(Locale.US);
        double bigD = 1_000_000.9973;
        
        System.out.println(nf1.format(bigD));
        System.out.println(nf2.format(bigD));
        System.out.println(nf3.format(bigD));
        
        // Formatação de moedas
        NumberFormat currencyFormat1 = NumberFormat.getCurrencyInstance(localeItaly);
        NumberFormat currencyFormat2 = NumberFormat.getCurrencyInstance(localeJapan);
        NumberFormat currencyFormat3 = NumberFormat.getCurrencyInstance(Locale.US);
        
        System.out.println(currencyFormat1.format(bigD));
        System.out.println(currencyFormat2.format(bigD));
        System.out.println(currencyFormat3.format(bigD));
        try {
            System.out.println(currencyFormat1.parse("10000000.9773"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
