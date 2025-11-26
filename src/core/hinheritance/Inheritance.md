# Herança
A herança possibilita que uma classe *receba propriedades* de outra, que
pode ser chamada **superclasse** ou "classe pai", mediante a palavra
**extends** (estende), evitando, assim, a reescrita de características em
comum entre essas classes. A classe herdeira gera em memória objetos próprios
com as características herdadas e com as específicas. Exemplo:
````
// Superclasse
public class Person {
    private String name;
    private String cpf;
    private Address address;

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
// Apenas com a indicação da extensão, os atributos e comportamentos da
superclasse tornam-se parte da subclasse.
````
## Quando usar herança?  
Usamos herança quando queremos estender as funcionalidades de uma classe, ou
quando desejamos usar polimorfismo.
Mas uso de herança é perigoso, pois gera forte acoplamento entre as classes,
ou seja, sempre que se quiser alterar a superclasse, será preciso pensar em
todas as classes herdeiras porque também serão afetadas. Isso exige um uso
cuidadoso desse poderoso recurso.
## super
Outro conceito importante é o da **sobrescrita**: ela implica que uma classe
herdeira pode alterar, em si, as propriedades da superclasse. A palavra
reservada **super** serve para invocar propriedades da superclasse em uma
classe herdeira, permitindo, por exemplo, a sobrescrita de um método.
No exemplo, podemos sobrescrever o método print para também exibir o salário
do funcionário, usando a palavra super e *evitando a reescrita do método*.
````
public class Employee extends Person{
    private double salary;
    
    public void print() {
        super.print();
        System.out.println(this.getSalary());
    }
}
// "super" invoca o método print da superclasse Person usando os atributos (name, cpf...) da subclasse Employee.
````
## Modificador protected
É um modificador de acesso que permite o acesso às propriedades de uma
superclasse a todas as classes do pacote e às subclasses (em qualquer pacote).
Se tentarmos usar um atributo como o *name* da classe Person em um método da
Employee, não conseguiremos, pois name é privado em Person. As únicas formas
de acessá-lo sem usar "public" são usar o método *get* (getName) ou usar o modificador **protected**. Isso pode ser mais prático, mas evitável se as
classes do mesmo pacote não puderem acessar as propriedades.
````
public class Person {
    protected String name;
    protected String cpf;
    protected Address address;
    ...
}
````
## Construtores
Se uma classe é estendida, os construtores criados nela regulam também a criação
de objetos das classes extensoras. Por isso, se, por exemplo, a classe
`Employee` estende `Person`, e esta tem construtores que obrigam a criação
de objetos com pelo menos o parâmetro `String name`, Employee só poderá originar
objetos se usar valores para esse atributo:  
`public Person(String name)` ➡️ `public Employee(String name)`  
> [!Note]
> Se a superclasse não tem construtores sem parâmetros, toda subclasse causa
> *erro de compilação*, até possuir um construtor com os parâmetros mínimos
> impostos pela superclasse.

Sabemos ser possível chamar construtores em outros construtores. Acrescente-se
que as subclasses podem chamar dentro dos seus construtores os construtores da
superclasse, mas usando **super** ao invés de **this**, assim:
````
public class Employee extends Person{
    
    public Employee(String name) {
        super(name);
    }
    // e também:
    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }
}
````
> [!Warning]
> Tanto *super()* quanto *this()* podem ser usados para chamar construtores e
> exigem ser colocados na primeira linha válida do bloco do construtor
> onde são usados, logo não se pode usá-los juntos.
Um detalhe importante: todas as classes estendem (implicitamente) a classe
`Object`. Por isso, todas herdam métodos não explícitos nelas (basta usar
"." como se fosse invocar um método, para constatar).
**Java não permite herança múltipla**, ou seja, uma mesma classe não pode
estender mais de uma classe, mas esses métodos podem ser herdados de Object
por ser possível definir hierarquias de heranças, de modo que uma subclasse
estenda outra e esta estenda Object, como no exemplo.