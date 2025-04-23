package core.fstaticmodifier.test;

import core.fstaticmodifier.domain.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 280);
        Car car2 = new Car("Mercedes", 270);

        System.out.println("Início com limitSpeed predefinida:");
        car1.print();
        car2.print();
        
        Car car3 = new Car("Audi", 300);

        car3.setLimitSpeed(350);

        System.out.println("\ncar3 depois de alterar limitSpeed:");
        car3.print();

        System.out.println("\nValor inicial de limitSpeed2: " + Car.limitSpeed2);

        Car.limitSpeed2 = 300;

        System.out.println("limitSpeed2 depois de Car.limitSpeed2 = 300");
        car1.print2();
        car2.print2();
        car3.print2();

        Car.setLimitSpeed3(280);

        System.out.println("Velocidade limite 3: " + Car.getLimitSpeed3());
    }
}
