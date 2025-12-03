package core.labstractclasses.domain;

public class Developer extends Employee{

    public Developer(String name, double salary) {
        super(name, salary);
        calculateSalaryBonus();
    }

    @Override
    protected void calculateSalaryBonus() {
        double bonusRateForDev = 0.05D; // 5%
        this.salary = this.salary * bonusRateForDev;
    }

    @Override
    public String toString() {
        return "Developer []";
    }

}