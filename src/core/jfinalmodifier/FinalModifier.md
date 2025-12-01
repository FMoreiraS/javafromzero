# Final modifier
## Constantes
Em algum momento é preciso criar propriedades que não devem ser alteradas:
constantes. Para criar constantes em Java, usa-se o moficador `final`, em
qualquer posição antes do tipo da variável. A convenção de nomeação para
constantes é escrever tudo em upper case, separando com "_" partes de nomes
compostos.  
`private static final int AGE_OF_MAJORITY = 18;`  
Usando a palavra *final*, o compilador deixa de aceitar valores padrão para
o dado, ou seja, uma vez declarada a constante, é obrigatório atribuir valor,
na mesma linha da declaração, num bloco de inicialização ou num construtor
(neste último caso não pode ser estática).
Esse valor não poderá ser alterado senão pela reescrita, qualquer tentativa
por meio de métodos causa erro de compilação: o código sequer será executado.
## Constantes do tipo refers
Um objeto pode ter como atributo uma constante do tipo *refers*, ou seja, uma
*referência* a um objeto. Neste caso, sabemos que o atributo é imutável, pois
tem o modificador final; isso significa que o objeto não pode ser alterado?
Não, os valores do objeto referenciado podem ser alterados, apenas a
referência não pode ser alterada, ou seja, não se pode reatribuir, colocar
outro objeto no lugar do primeiro.
````
public class Test {
    public static void main(String[] args) {
    // Possível
        Carro carro = new Carro();
        carro.owner.setName("Thomas");
    // Impossível (erro de compilação garantido)
        carro.owner.setOwner(new Owner());
    }
}
````
Isso é muito útil quando precisamos de uma só instância de um objeto, como
uma conexão de banco de dados, que é única num aplicativo.
## Classes e métodos imutáveis
Se o modificador final for usado em classes e métodos, elas não poderão ser
estendidas (ou seja, a herança será proibida) e eles não poderão ser
sobrescritos. Isso é conveniente quando quer-se garantir a imutabilidade de
entes importantes num projeto, como a classe String é para a linguagem.