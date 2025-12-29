package core.npolimorphism.domain;

public abstract class Computer {
    protected String name;
    protected String manufacturingDate;

    protected Computer(String name, String manufacturingDate) {
        this.name = name;
        this.manufacturingDate = manufacturingDate;
    }
    
    abstract void powerOn();

    public static void showInfo(Computer c) {
        System.out.println("--- Informações do computador ---");
        System.out.println("Nome: " + c.getName());
        System.out.println("Data de fabricação: " + c.getManufacturingDate());
        if(c instanceof Laptop) {
            // Podemos fazer o cast do objeto...
            // Laptop laptop = (Laptop) c;
            // Ou acessar logo a propriedade, que ainda poderia estar no println()
            String webcamResolution = ((Laptop) c).getWebcamResolution();
            System.out.println("Resolução da webcam: " + webcamResolution);
        }
        System.out.println("---------------------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
}
