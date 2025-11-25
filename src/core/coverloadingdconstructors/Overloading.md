# Sobrecargas e construtores
## METHOD OVERLOADING
É definir um método com tipos ou números de parâmetros diferentes, ou usar o
mesmo nome em métodos que aceitam parâmetros diferentes.
Ex.: em `coverloadingmethods.domain.Person`, existem os atributos name, age
e nationality, com seus respectivos sets e gets; ao invés de usar sempre set
para atribuir valores, podemos usar um outro método que atualize
todos os atributos:
````
    public void init (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void init (String name, int age, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
```` 
Com isso podemos usar o método init() com 2 ou com 3 parâmetros: só haveria
erro se tentássemos usar 3 parâmetros num método definido apenas com 2.

## CONSTRUCTORS:
Criar objetos é **CONSTRUIR** objetos. O Java sempre cria construtores nos
arquivos .class, durante a execução das classes, se o próprio autor não o
faz, porque só é possível criar objetos com construtores.
Os construtores simplesmente **NÃO PODEM TER RETORNO**: o termo void é
condiderado um "retorno vazio" e seu uso cria exclusivamente métodos.
Se houver qualquer indicação de retorno (void, int etc.), não é um
construtor. Eis a sintaxe:  
    `public ClassName() {...}`  
Um construtor pode determinar regras para a criação de objetos, de modo
que, sempre que um objeto for criado, deverá estar conforme o específicado.
Ex.: Usando ainda Person, se for criado um construtor na classe e o
parâmetro "name" for usado entre os (), todo objeto tipo Person deverá
obrigatoriamente ser construído com um valor para name:
````     
    public Person(String name) {
        this.name = name;
    }
// Agora a criação duma instância precisará ter um "name":
    public static void main(String[] args) {
        Person mark = new Person("Mark");
    }
````
Reforçando: uma vez criado um construtor numa classe, o compilador não
criará um no momento da execução, e a classe seguirá as regras definidas
pelo construtor em toda criação de objetos.

### CONSTRUCTORS OVERLOADING
Se quisermos permitir que novos objetos sejam criados com ou sem
inicializações de atributos, podemos também *sobrecarregar os construrores*.
Vale notar que construtores podem conter instruções como qualquer bloco de código.
Para sobrecarregar construtores, é necessário chamar outros: e só é possível
chamar construtores, em uma classe que define objetos, dentro de outros
construtores.  
A classe Person tem "name", "age" e "nationality". Um construtor determina
a inicialização da string "name", mas está sobrecarregado: há outro construtor sem parâmetros e com um comando print (um "identificador"). Há também outro
construtor que determina a inicialização de todos os atributos, mas chamando
o construtor que inicializa name, e este por sua vez chama o construtor
sem parâmetros:
````
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
````
Existem DUAS regras importantes para a chamada de construtores:
1. Chamamos construtores com "this()" e indicamos pelo nome os parâmetros do construtor que desejamos chamar.
2. A chamada só funciona se estiver na **PRIMEIRA LINHA VÁLIDA** do bloco do construtor que chama.
````
Na classe de teste:
    
    Person mark = new Person("Mark", 18);

    mark.printAtributes();

    Person giovanni = new Person("Giovanni", 25, "italian");

    giovanni.printAtributes();
````
Para entender o que está acontecendo, dividamos as ações na classe de teste em dois eventos:
1. A criação do objeto "mark" usa apenas o segundo construtor;
2. A criação do objeto "giovanni" usa o terceiro construtor (pois recebe 3 parâmetros),
   e este delega a responsabilidade de inicializar os atributos name e age ao segundo
   construtor, que por sua vez chama o primeiro (sem parâmetros).
Como resultado, temos a impressão da mensagem do primeiro construtor seguida da impressão
dos atributos, nos dois eventos.