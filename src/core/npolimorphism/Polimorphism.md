# Polimorfismo
## Definição
**Polimorfismo** é um dos *4 pilares da programação orientada a objetos*, é a
propriedade de poderem os objetos serem *referenciados por um tipo diferente*,
ou seja, o polimorfismo permite que um objeto de um tipo tenha uma variável de
referência de outro tipo, desde que este tipo seja estendido por aquele.
## Exemplo com widening cast
Podemos usar o seguinte exemplo: temos a classe `Computer`, que é estendida
pelas classes `Laptop` e `Desktop`.
````
public abstract class Computer {
    protected String name;
    protected String manufacturingDate;

    abstract void powerOn();
    // Getters...
}
...
public class Laptop extends Computer {
    @Override
    public void powerOn() {...}

    public void openLid() {...}
}
...
public class Desktop extends Computer {
    @Override
    public void powerOn() {...}
}
````
Ao criar um objeto Laptop ou Desktop, podemos usar o tipo Computer na variável
de referência, assim:  
`Computer desktop = new Desktop("PC9710", "01/2029");`  
Usando o tipo da superclasse na variável de referência, é possível **acessar
tudo o que a subclasse herda, mas não o que lhe é próprio**. Mas se existe
essa limitação, por que o polimorfismo seria útil? Para favorecer a criação de
métodos mais genéricos, *desacoplados*, independentes de subclasses. Suponhamos
que desejamos um método para exibir informações gerais dos laptops e desktops
(como o *fetch* de SOs linux) mas não existe nenhuma informação que exija um
método específico para cada subclasse. Então, bastaria adicionar em Computer
um método chamado `showInfo(Computer c)`, pois usaria apenas informações
presentes em Computer, e não precisaríamos de vários métodos fazendo a mesma
coisa com tipos diferentes, multiplicando enormemente a quantidade de código.
````
protected void showInfo(Computer c) {
    System.out.println("--- Informações do computador ---");
    System.out.println("Nome: " + c.getName());
    System.out.println("Data de fabricação: " + c.getManufacturingDate());
}
````
> [!Note]
> Para fazer uso dessa utilidade do polimorfismo (chamada *widening cast*),
> não é necessário criar os objetos com variável de referência genérica.

## **instanceof**
É possível fazer o contrário do que acaba de ser feito, ou seja, usar um tipo
genérico como um tipo mais específico, o chamado "narrowing cast". Mantendo o
exemplo, se tivéssemos uma propriedade específica numa das subclasses,
poderíamos fazer o cast da superclasse para o tipo de uma das subclasses.  
Digamos que os laptops agora devem ter webcam, então será bom ter informação
sobre a resolução dela, mas os desktops não têm. Podemos acrescentar essa
especificidade no showInfo():
````
protected void showInfo(Computer c) {
    System.out.println("--- Informações do computador ---");
    System.out.println("Nome: " + c.getName());
    System.out.println("Data de fabricação: " + c.getManufacturingDate());
    // O cast, com o tipo e os parênteses
    Laptop laptop = (laptop) c;
    System.out.println("Resolução da webcam: " + laptop.getWebcamResolution());
}
````
> [!Note]
> Relembrando: para fazer casting de variáveis, usamos "()" contendo o tipo
> para o qual desejamos converter um valor. E para usar métodos diretamente,
> basta acrescentar um par de parênteses para conter o primeiro cast e o objeto.
> ```` 
> int integer = 12;
> double intTurnedDouble = (double) integer;
> double
> ````

Se fazemos atentamente essa adição, notamos um problema: o compilador não
rejeita um cast, mas teremos exceção se o método for usado com um desktop
como parâmetro. Para resolver, temos uma palavra reservada dedicada a
averiguar o tipo de uma variável: **instanceof**. Ela *funciona como um
operador relacional ou lógico*: dependendo de ser ou não a variável
uma instância do tipo que segue, a expressão **adquire valor true ou false**. 
Podemos então corrigir:
````
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
````
## Interface oriented programming
Uma vez que é possível criar objetos usando uma variável de referência
genérica (com o *widening cast*) e dar múltiplas implementações para
métodos de interfaces, podemos desenvolver seguindo o conceito de
**programação orientada a interfaces**. Ou seja, podemos usar preferencialmente
métodos de interfaces e criar com tipos genéricos objetos que as implementem, porque **o desacoplamento facilitará a manutenção**.  
Quando for necessário mudar o comportamento do método, bastará substituir o
tipo do objeto (após "= new") e, assim, a implementação do método. Isso é
feito, por exemplo, nas *collections* (certas estruturas de dados da
linguagem), que possuem várias implementações para os mesmos métodos
(cf. java.util.List.add(), java.util.ArrayList.add() e
java.util.LinkedList.add()).