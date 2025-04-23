package core.fstaticmodifier.domain;

public class Car {
    private String name;
    private int maxSpeed;
    private int limitSpeed = 250;
    public static int limitSpeed2 = 350;
    private static int limitSpeed3 = 400;

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("================");
        System.out.println("Nome: " + this.name);
        System.out.println("Velocidade máxima: " + this.maxSpeed);
        System.out.println("Velocidade limite " + this.limitSpeed);
    }

    public void print2() {
        System.out.println("================");
        System.out.println("Nome: " + this.name);
        System.out.println("Velocidade máxima: " + this.maxSpeed);
        System.out.println("Velocidade limite " + this.limitSpeed);
        System.out.println("Velocidade limite estática: " + Car.limitSpeed2);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setLimitSpeed(int limitSpeed) {
        this.limitSpeed = limitSpeed;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getLimitSpeed() {
        return limitSpeed;
    }

    public static void setLimitSpeed3(int limitSpeed3) {
        Car.limitSpeed3 = limitSpeed3;
    }

    public static int getLimitSpeed3() {
        return Car.limitSpeed3;
    }
}