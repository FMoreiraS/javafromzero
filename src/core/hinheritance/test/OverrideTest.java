package core.hinheritance.test;

import core.hinheritance.domain.Employee;
import core.hinheritance.domain.Person;

public class OverrideTest {

    public static void main(String[] args) {
        
       // Teste da sobrescrita de métodos
        System.out.println("Impressão com toString de Object: " + new Person("Thomas"));
        System.out.println("Impressão com toString de Employee: " + new Employee("Maximus"));
    }
}
