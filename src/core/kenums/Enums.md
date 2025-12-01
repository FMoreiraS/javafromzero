# Enums
## Conceito
Enum, "enumeração", é uma estrutura de dados especial, dedicada a guardar
valores, é como uma classe, com **campos públicos, estáticos e constantes**.  
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
public enum UF {

    PARA ("Pará"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    ESPIRITO_SANTO("Espírito Santo");

}
````
##