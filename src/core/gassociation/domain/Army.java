package core.gassociation.domain;

public class Army {
    private String name;
    private Warrior[] warriors;

    public Army(String name) {
        this.name = name;
    }
    public Army(String name, Warrior[] warriors) {
        this.name = name;
        this.warriors = warriors;
    }

    public void print() {
        System.out.println(this.name);
        if(warriors == null) return;
        for(Warrior warrior : warriors) {
            System.out.println(warrior.getName());
        }
    }

    public void setWarriors(Warrior... warriors) {
        this.warriors = warriors;
    }

    public String getName() {
        return this.name;
    }
}