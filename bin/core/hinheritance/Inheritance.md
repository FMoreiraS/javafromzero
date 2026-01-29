### Herança
A herança possibilita que uma classe *receba propriedades* de outra, que pode ser chamada **superclasse** ou
"classe pai", mediante a palavra **extends** (estende), evitando, assim, a reescrita de características em
comum entre essas classes. A classe herdeira gera em memória objetos próprios com as características herdadas
e com as específicas. Segue um exemplo.
````
// Superclasse
public class Person {
    private String name;
    private String cpf;
    private Address address;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String cpf, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }
    
    public void print() {
        System.out.println("---------------------------------");
        System.out.println(this.getName());
        System.out.println(this.getCpf());
        System.out.println(this.address.getStreet() + " " + this.address.getCep());
        System.out.println("---------------------------------");
    }
}
// Subclasse
public class Employee extends Person{
    private double salary;
}
// Apenas com a indicação da extensão, os atributos e comportamentos da superclasse tornam-se parte da subclasse.
````
Quando usar herança?  
Usamos herança quando queremos estender as funcionalidades de uma classe, ou quando desejamos usar polimorfismo.
O uso de herança é perigoso, pois gera forte acoplamento entre as classes, ou seja, sempre que se quiser alterar
a superclasse, será preciso pensar em todas as classes herdeiras porque também serão afetadas. Isso exige um uso
cuidadoso desse poderoso recurso.
#### super
Outro conceito importante é a **sobrescrita**: ela implica que uma classe herdeira pode alterar, em si, as
propriedades da superclasse. A palavra reservada **super** serve para invocar propriedades da superclasse em uma
classe herdeira, permitindo, por exemplo, a sobrescrita de um método. No exemplo, podemos sobrescrever o método
print para passar a exibir também o salário do funcionário, usando a palavra super e *evitando a reescrita do
método*.
````
public class Employee extends Person{
    private double salary;
    
    public void print() {
        super.print();
        System.out.println(this.getSalary());
    }
}
// "super" imita o método print da superclasse Person usando os atributos (name, cpf...) da subclasse Employee.
````
#### Modificador protected
É um modificador de acesso que permite o acesso às propriedades de uma superclasse a todas as classes do pacote
e a todas as subclasses (em qualquer pacote). Se tentarmos usar um atributo como o name da classe Person em
um método da Employee, não conseguiremos, pois name é privado em Person. As únicas formas de acessá-lo sem o
tornar public é usando o método *get* (getName) ou mudando o modificador para *protected* (o que é mais breve).
````
public class Person {
    protected String name;
    protected String cpf;
    protected Address address;
    ...
````