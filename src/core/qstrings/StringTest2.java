package core.qstrings;

public class StringTest2 {
    public static void main(String[] args) {
        String name1 = "Aoiama";

        System.out.println(name1.length());
        System.out.println(name1.charAt(2));
        System.out.println(name1.replace("i", "y"));
        System.out.println(name1.substring(2, 6));
        System.out.println(name1.toLowerCase());
        System.out.println(name1.toUpperCase());

        String inputWithTypo = " Franciscus";
        System.out.println(inputWithTypo.trim());
    }

}
