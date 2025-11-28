package core.hinheritanceioverride.domain;

public class Vehicle {

    protected String name;
    protected String type;
    protected int fuelCapacityInLiters;

    static{
        System.out.println("Bloco de inicialização estático de Vehicle");
    }
    {
        System.out.println("Bloco de inicialização não estático 1 de Vehicle");
    }
    {
        System.out.println("Bloco de inicialização não estático 2 de Vehicle");
    }

    public Vehicle() {
        System.out.println("Construtor de Vehicle");
    }
}
