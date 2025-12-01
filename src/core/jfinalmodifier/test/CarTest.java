package core.jfinalmodifier.test;

import core.jfinalmodifier.domain.Car;
import core.jfinalmodifier.domain.Owner;

public class CarTest {

    public static void main(String[] args) {
        Car gt40 = new Car("Ford GT40");
        gt40.getOwner().setName("Henry");

        System.out.println(gt40.getOwner().getName());

        Owner otherPeople = new Owner("Heinnrich");
        // IMPOSSÍVEL: gt40.setOwner(otherPeople);
    }

}
