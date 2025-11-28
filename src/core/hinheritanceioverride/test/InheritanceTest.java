package core.hinheritanceioverride.test;

import core.hinheritanceioverride.domain.*;

public class InheritanceTest {
    public static void main(String[] args) {
        Person james = new Person("James");
        james.setCpf("123654789");
        Address address = new Address("Montblanc Street", "12345-66");
        james.setAddress(address);

        System.out.println("print() com objeto tipo Person");
        james.print();

        Employee peter = new Employee("Peter");
        peter.setCpf("123654789");
        peter.setAddress(address);
        peter.setSalary(8000);

        System.out.println("\nprint() com objeto tipo Employee");
        peter.print();
        System.out.println("\nResultados iguais".toUpperCase());

        System.out.println("Para incluir o atributo próprio de Employee (salary), sobrescrevemos print()");
        System.out.println("public void print() {\n\tsuper.print();\n\tSystem.out.println(this.salary);\n}");

        peter.print2();
    }
}
