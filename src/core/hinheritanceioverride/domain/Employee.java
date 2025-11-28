package core.hinheritanceioverride.domain;

public class Employee extends Person{
    private double salary;

    public Employee(String name) {
        super(name);
    }

    public void print2() {
        super.print();
        System.out.println(this.salary);
    }

    @Override
    public String toString() {
        return "Employee: " + name +
                "; salary = " + salary +
                ";\nCPF = " + cpf + ";\naddress: " + address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
