package core.npolimorphism.domain;

public class Desktop extends Computer {

    public Desktop(String name, String manufacturingDate) {
        super(name, manufacturingDate);
    }
    
    @Override
    public void powerOn() {
        System.out.println("Ligando desktop " + this.getName());
    }
}
