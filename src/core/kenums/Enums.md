# Enums
## Conceito
Enum, "enumeração", é uma estrutura de dados especial, dedicada a guardar
valores, é como uma classe, com **campos públicos, estáticos e constantes**.  
Enums podem ter qualquer modificador de acesso e ser criadas também dentro de
outras classes.
> [!NOTE]
> Existe um modificador de acesso (ainda não mencionado), o de package, que
> é usado como padrão, quando não se informa o acesso para classes e métodos.
> Ele concede acesso a todas as classes do pacote, e pode ser usado também
> com enums.

Os atributos de uma enum representam-na, tem o tipo dela, ou seja, se
a enum StatesOfBrazil (tendo os estados como atributos) é usada
para cadastrar um cliente, a constante SAO_PAULO pode ser dita
do tipo StatesOfBrazil.
## Exemplo de aplicação
Suponha que um sistema precisa cadastrar clientes e, entre as informações
armazenadas, está uma string para a unidade federativa onde o cliente reside.
Para criar um objeto Cliente, precisaríamos sempre atribuir um valor para
esse campo, mas, numa equipe de desenvolvedores, naturalmente ocorreriam
variações no valores para uma mesma UF, causando problemas de inconsistência
de dados.  
Seria possível obrigar todos que fossem instanciar a classe Cliente a usar
sempre valores determinados ("SAO PAULO" ao invés de "São Paulo", por exemplo),
inserindo uma condicional no construtor ou lançando uma exceção. Mas isso
seria mais custoso e inconveniente para implementar e instanciar.
````
public class Customer {

    private String name;
    // Sem Enum: muitos valores para definir um campo
    private static final String STATE_SP = "São Paulo";
    private static final String STATE_RJ = "Rio de Janeiro";
    private String fedUnit;
    
    // Construtor restritivo
    public Customer(String name, String fedUnit) {
        if(
            !fedUnit.equals(STATE_RJ) &&
            !fedUnit.equals(STATE_SP)
            // Imagina colocar todos os estados brasileiros aqui
        ) {
            return; // Ou seja, objeto não é criado.
        }
        this.name = name;
        this.fedUnit = fedUnit;
    }
}
````
Aí entram as enums. Elas podem reunir várias constantes, de modo que um objeto
que tenha um campo do tipo de uma enum só poderá ter valor igual a uma das
constantes definidas.
````
public enum StatesOfBrazil {

    PARA,
    SAO_PAULO,
    RIO_DE_JANEIRO,
    ESPIRITO_SANTO;

}
````
## Construtores e atributos
As enumerações podem ter atributos e necessariamente têm construtores, como
qualquer classe. Para dar atributos à enumeração, é obrigatório declará-los
**depois dos valores da enumeração** (o contrário causa erro). O modo de usar
esses atributos é colocá-los entre parênteses após cada valor, e depois como
argumentos do construtor (para garantir a atribuição).
````
public enum StatesOfBrazil {

    PARA("Pará"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    ESPIRITO_SANTO("Espírito Santo");

    public final String FORMATTED_NAME;

    private StatesOfBrazil(String name) {
        this.FORMATTED_NAME = name;
    }
}
````
Importa notar que os atributos podem ter qualquer visibilidade, mas os
**construtores de enums só podem ser privados**.
> [!TIP]
> Como mostrado acima, os atributos podem ser constantes e até estáticos,
> mas este último não convém, pois obriga inicialização (cf. o tópico F),
> ou seja, exige um valor que precisará ser alterado. Também não é
> interessante usar private no atributo porque exige um get e, se os
> atributos de enums também devem ser constantes, não serão alterados.

A possibilidade de usar atributos pode servir, por exemplo, para encurtar
o valor da enumeração (prática comum para salvar num banco dados menores).
## Sobrescrita de métodos
Cada valor da enumeração comporta-se como uma subclasse, podendo ter dentro
de um bloco métodos que sobrescrevem os métodos próprios da enumeração.
````
public enum FormOfPayment {

    CREDIT {
        @Override
        public double calcDiscount(double value) {
            double discountPercentage = 0.05;
            return value * discountPercentage;
        }
    },
    DEBT {
        @Override
        public double calcDiscount(double value) {
            double discountPercentage = 0.1;
            return value * discountPercentage;
        }
        // Isso evita, por exemplo, o uso condicionais (if), noutras classes
    };

    public double calcDiscount(double value) {return 0;}
}
````
Não se tratou ainda da abstração (um dos pilares da POO), mas vale mencionar
que numa situação como esta, onde o método não tem comportamento padrão, é
melhor criar um *método abstrato*, pois ele não pode ter corpo, serve apenas
para ser sobrescrito, causando erro se não o for por cada subclasse (ou, aqui,
por cada valor da enumeração).
## Busca por atributos
É possível obter o valor de uma enum usando um atributo, e com isso obter,
por exemplo, o valor de outros atributos que existam. Existe um método capaz
de retornar em string o tipo do valor parâmetro:
````
    // valueOf() só consegue retornar um valor da enumeração se receber o
    // nome real, não o formatado.
    StatesOfBrazil stateSP = StatesOfBrazil.valueOf("SAO_PAULO");
    System.out.println(stateSP.FORMATTED_NAME);
````
Para obter o valor da enum, podemos criar um método no arquivo dela.
````
    public static StatesOfBrazil getStateFromFormattedName(String formattedName) {
        for(StatesOfBrazil state : values()) {
            // values() retorna um array com os valores da enumeração.
            if(state.FORMATTED_NAME.equals(formattedName)) {
                return state;
            }
        }
        return null;
    }
````