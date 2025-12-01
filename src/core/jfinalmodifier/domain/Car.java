package core.jfinalmodifier.domain;

public class Car {

    private String name;
    private final Owner owner = new Owner("");
    
    public Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    // É impossivel criar o setter do campo constante
    // public void setOwner(Owner owner) {
    //     this.owner = owner;
    // }

}
