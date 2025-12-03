package core.labstractclasses.test;

import core.labstractclasses.domain.Developer;

public class EmployeeTest {
    public static void main(String[] args) {
        Developer dev = new Developer("Max", 8000);
        // O salário já aparece com o bônus aplicado
        System.out.println(dev);
    }
}
