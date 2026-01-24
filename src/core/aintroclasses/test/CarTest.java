package core.aintroclasses.test;

import core.aintroclasses.domain.Car;

// Exercício:
// Criar uma classe carro com os atributos: nome, modelo, ano;
// em seguida, criar dois objetos distintos e imprimir seus valores.

public class CarTest {
    public static void main(String[] args) {
        Car skylineR34 = new Car();
        Car fordGT40 = new Car();

        skylineR34.nome = "Nissan Skyline";
        skylineR34.modelo = "R-34";
        skylineR34.ano = 1998;

        fordGT40.nome = "Ford GT";
        fordGT40.modelo = "Mk I";
        fordGT40.ano = 1964;
        // Segundo o mestre, essa forma é mais organizada.

        System.out.println("Nome: "+skylineR34.nome);
        System.out.println("Modelo: " +skylineR34.modelo+ ", ano: "+skylineR34.ano + ".");
        System.out.println("Nome: "+fordGT40.nome);
        System.out.println("Modelo: " +fordGT40.modelo+ ", ano: "+fordGT40.ano + ".");
    }
}