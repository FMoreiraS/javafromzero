package core.aintroclasses;

public class IntroClasses {
    /* Classes são agrupamentos que representam coisas com características em comum
     * e dão origem aos objetos.
     * O conjunto de atributos e comportamentos (métodos) de uma classe é chamado template. Ex.:
     * public class Estudante {
     *    public String nome;
     *    public int idade;
     *    public char sexo;
     * }
     * OBSS.:
     * 1. O método main é o ponto de entrada para executar as
     * as classes, por isso classes sem ele não são
     * executáveis.
     *
     * 2. Domínio, domain ou model geralmente é um conjunto de classes que representa a
     * "lógica de negócio" e vai para o banco de dados.
     *
     * 3. Classes em pacotes diferentes que precisam ser usadas em códigos só podem ser
     * acessadas mediante um import, que torna o objeto reconhecível ao java: quando se digita
     * o nome da classe, o IDE pode oferecer a opção de colocar o import no inicio do
     * código. Para fazer o import, deve-se escrever o nome completo da classe, com todos os pacotes.
     *
     * Estando as classes importadas num código, necessário é criar obejtos que sejam
     * compreendidos nas classes:  para criar objetos, SEMPRE USA-SE "new".
     * Uma variável de referência direciona a um objeto com o template de uma classe.
     * A variável de referência pode ser de tipo diferente do da classe.
     * Alteramos os valores do objeto da classe por meio do nome da variável de referência,
     * ou seja, escrevemos "objeto.atributo" e atribuimos um valor.
     * Para acessar os dados gerados, é preciso indicá-los no comando, pois a variável de referência
     * indica somente o espaço em memória.
     * Um objeto poderia ser criado sem a declaração de uma variável de referência, mas seria inacessível.
     * Outra observação: se atributos de uma classe são incializados diretamente nela, o valor padrão
     * para tais atributos serão os mesmos para todos os objetos, por isso as inicalizações são
     * preferencialmente no ato e no local da criação dos objetos.
    
     * COESÃO:
     * Coesão é capacidade de códigos serem específicos, de modo que um código ou projeto
     * chamado coeso tenha classes atendendo ao menor número de propósitos, o que as deixa
     * facilmente alteráveis.
     * Assim, seria ruim criar uma classe Estudante, acrescentar atributos como nome, idade,
     * sexo, e criar nessa classe um objeto chamado professor, com atributos chamados
     * nomeProfessor, idadeProfessor...; o ideal é criar uma classe própria para caracterizar
     * esse objeto tipo professor, pois qualquer alteração na configuração de estudante exigiria
     * adaptações também em professor, e uma classe específica também evitaria que se nomeasse
     * cada atributo com nomes desnecessariamente longos.
     *
     * OBSERVAÇÃO: A variável de referência dá acesso a 1 objeto em memória; mas também um mesmo
     * objeto pode ser referênciado por duas variáveis diferentes, quando se iguala uma variável
     * a outra que referencia um objeto. Feito isso, qualquer objeto antes referenciado pela
     * variável alterada fica inacessíveis.
     * Ex.: Se faço:
     * Carro skylineR34 = new Carro();
     * Carro fordGT40 = new Carro();
     * e, depois de atribuir valores aos atributos da classe Carro, escrever 
     * Carro skylineR34 = Carro fordGT40,
     * o objeto antes referenciado por skylineR34 passa a ser o mesmo referenciado por fordGT40.
     */
}
