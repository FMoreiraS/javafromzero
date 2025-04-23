package core.bintromethods.test;

import core.bintromethods.domain.Worker;

public class WorkerTest {
    public static void main (String[] args) {
        
        Worker engineer = new Worker();

        engineer.name = "John";
        engineer.age = 30;
        engineer.salaries = new double[] {1800, 250, 850};
        engineer.identify();
        
        // Tudo acima fica inválido quando tornamos os atributos privados.
        // Usando métodos set e get:
        System.out.println("\nWorker com valores privados:");
        engineer.setName2("Paul");
        engineer.setAge2(30);
        engineer.setSalaries2(new double[] {2000, 850, 1352.50});

        engineer.identify2();
    }
}