package core.hinheritance.domain;

public class Ship extends Vehicle{
    
    static{
        System.out.println("Bloco de inicialização estático de Ship");      
    }
    {
        System.out.println("Bloco de inicialização não estático 1 de Ship");
    }
    {
        System.out.println("Bloco de inicialização não estático 2 de Ship");
    }
    
    public Ship() {
        System.out.println("Construtor de Ship");
    }
}