package core.npolimorphism.domain;

public class Laptop extends Computer {
    String webcamResolution = "30 Mpx";
    
    public Laptop(String name, String manufacturingDate) {
        super(name, manufacturingDate);
    }

    @Override
    public void powerOn() {
        System.out.println("Ligando laptop " + this.getName());
    }

    public void openLid() {
        System.out.println("Abrindo a tampa do laptop...");
    }

    public String getWebcamResolution() {
        return webcamResolution;
    }
}
