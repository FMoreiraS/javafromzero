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
## Modificador protected (#)
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
> 
Um detalhe importante: todas as classes estendem (implicitamente) a classe
`Object`. Por isso, todas herdam métodos não explícitos nelas (basta usar
num IDE o "." como se fosse invocar um método, para constatar).
**Java não permite herança múltipla**, ou seja, uma mesma classe não pode
estender mais de uma classe, mas esses métodos podem ser herdados de Object
por ser possível definir hierarquias de heranças, de modo que uma subclasse
estenda outra e esta estenda Object, como no exemplo.
## Efeito na ordem de execução
Anteriormente tratou-se dos blocos de inicialização e do modificador
**static** e do como eles afetam a ordem de execução, que ficou assim:
1. Execução de tudo que é estático quando a JVM carrega a classe;
2. Alocação de espaço em memória para objetos;
3. Inicialização dos atributos com valores padrão ou determinados pelo autor;
4. Execução do bloco de inicialização;
5. Execução dos construtores.
O uso de herança aumenta a complexidade dessa ordem, já que existe uma
dependência entre classes. Pode-se observar o funcionamento da execução
usando alguns blocos de inicialização estáticos e não estáticos
nas classes de exemplo Vehicle e Ship.
````
// superclasse
public class Vehicle {

    protected String name;
    protected String type;
    protected int fuelCapacityInLiters;

    static{
        System.out.println("Bloco de inicialização estático de Vehicle");
    }
    {
        System.out.println("Bloco de inicialização não estático 1 de Vehicle");
    }
    {
        System.out.println("Bloco de inicialização não estático 2 de Vehicle");
    }

    public Vehicle() {
        System.out.println("Construtor de Vehicle");
    }
}
// subclasse
public class Ship extends Vehicle{
    
    static{
        System.out.println("Bloco de inicialização estático de Ship");      
    }
    {
        System.out.println("Bloco de inicialização não estático 1 de Ship");
    }
    {
        System.out.println("Bloco de inicialização não estático 2 de Ship");
    }
    
    public Ship() {
        System.out.println("Construtor de Ship");
    }
}
// Feito isso, a criação de um objeto do tipo Ship gera essas mensagens
// (cf. a classe de teste):
Bloco de inicialização estático de Vehicle
Bloco de inicialização estático de Ship
Bloco de inicialização não estático 1 de Vehicle
Bloco de inicialização não estático 2 de Vehicle
Construtor de Vehicle
Bloco de inicialização não estático 1 de Ship
Bloco de inicialização não estático 2 de Ship
Construtor de Ship
````
Em suma, a ordem de execução quando existem relações de herança fica assim:
1. blocos de inicialização estáticos, da superclasse e da subclasse;
2. blocos de inicialização não estáticos da superclasse, na ordem de escrita;
3. construtor da superclasse;
4. blocos de inicialização não estáticos da subclasse, na ordem de escrita;
5. construtor da subclasse.
Ou seja, tudo que é estático é carregado primeiro, da classe e da subclasse,
mas depois a superclasse ganha precedência.
## Sobrescrita e método toString
Notamos que a impressão de variáveis de referência (arrays, objetos)
tem sempre valores no formato "nomecompleto.hash". Uma vez que não são
strings, não têm um valor para imprimir, mas obtemos esses valores como
confirmação de que esses objetos não são nulos. Isso só é possível pela
existência do método `toString`, na classe Object.  
Em tópicos anteriores (como na introdução a métodos), criou-se métodos
para imprimir as informações dos objetos. Mas isso pode ser feito com
o método *toString*, por meio da **sobrescrita** do método. Para fazê-lo
explicitamente, usa-se a anotação `@Override`, e com ela, se o nome
do método na subclasse não for idêntico, o compilador avisa sobre o erro.