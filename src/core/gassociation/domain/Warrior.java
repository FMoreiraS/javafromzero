package core.gassociation.domain;

public class Warrior {
    private String name;
    private Army army;

    public Warrior(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name + " do " + this.army.getName());
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public String getName() {
        return this.name;
    }
}
