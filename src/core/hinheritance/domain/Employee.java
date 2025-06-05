package core.hinheritance.domain;

public class Employee extends Person{
    private double salary;

    public Employee(String name) {
        super(name);
    }

    public void print2() {
        super.print();
        System.out.println(this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
