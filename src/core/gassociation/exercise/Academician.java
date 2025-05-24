package core.gassociation.exercise;


public class Academician {
    private String name;
    private int age;
    private Seminary seminary;

    public Academician(String name) {
        this.name = name;
    }

    public Academician(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("--------------------------------");
        System.out.println("Estudante " + this.getName() + ", idade: " + this.getAge());
        if(this.seminary != null) {
            System.out.println("Seminário escolhido:\n" + getSeminaryName());
        }
        System.out.println("--------------------------------");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSeminaryName() {
        return seminary.getTitle();
    }

    public void setSeminary(Seminary seminary) {
        this.seminary = seminary;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
