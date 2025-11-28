package core.hinheritanceioverride.test;

import core.hinheritanceioverride.domain.Employee;
import core.hinheritanceioverride.domain.Person;

public class OverrideTest {

    public static void main(String[] args) {
        
       // Teste da sobrescrita de métodos
        System.out.println("Impressão com toString de Object: " + new Person("Thomas"));
        System.out.println("Impressão com toString de Employee: " + new Employee("Maximus"));
    }
}
