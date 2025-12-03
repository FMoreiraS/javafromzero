package core.labstractclasses.domain;

public abstract class Employee {

    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    protected abstract void calculateSalaryBonus();

}