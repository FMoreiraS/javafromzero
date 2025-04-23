package core.coverloadingdconstructors.domain;

public class Person {
    private String name;
    private int age;
    private String nationality;

    public void printAtributes() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.nationality);
    }

    public Person() {
        System.out.println("Construtor sem parâmetros.");
    }

    public Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String nationality) {
        this(name, age);
        this.nationality = nationality;
    }

    public void init (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void init (String name, int age, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public void setNationality(String sex) {
        this.nationality = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
