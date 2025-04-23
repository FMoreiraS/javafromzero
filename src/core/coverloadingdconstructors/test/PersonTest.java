package core.coverloadingdconstructors.test;

import core.coverloadingdconstructors.domain.Person;

public class PersonTest {
    public static void main(String[] args) {

    Person mark = new Person("Mark", 18);

    mark.printAtributes();

    Person giovanni = new Person("Giovanni", 25, "italian");

    giovanni.printAtributes();
    }
}
