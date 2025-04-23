package core.bintromethods;

import core.bintromethods.domain.Student;
import core.bintromethods.domain.Calculator;

public class IntroMethods {
    /* Assim como nos atributos, a primeira parte dos métodos é um modificador de acesso
     * (public, p. ex.).
     * A segunda parte é o retorno, que é diferente de saída.
     * Geralmente, um método retorna algo ou não retorna nada; quando não retorna nada,
     * usamos o termo void, "vazio".
     * Depois do retorno, vem o nome do método, que segue a mesma convenção das variáveis:
     * primeira inicial minúscula e demais maiúsculas, se o nome for composto.
     * Depois do nome vem () e {}.
     * IMPORTANTE: MÉTODOS SÃO CRIADOS EM CLASSES E FUNCIONAM EM OBJETOS!
     * Para executar um método, basta escrever o nome do objeto criado, da classe onde
     * está o método, seguido de . e do nome do método, ou seja, da mesma forma como
     * se faz com atributos.
     * Métodos podem ter PARÂMETROS, isto é, variáveis locais com as quais serão realizadas
     * as tarefas dos métodos. Os parâmetros ficam entre os () após o nome do método,
     * e as variáveis parâmetros seguem as convenções; então, devemos enunciá-las antecedidas
     * pelo tipo, primtivo ou refers (inclusive arrays), e, se houver mais de um parâmetro
     * num mesmo método, usamos vírgula para separá-los. Ex.:
     */
    public void multiplication(int num1, int num2) {
        System.out.println(num1 * num2);
    }
    /* Os parâmetros usados num método são chamados ARGUMENTOS, e os valores a ser usados
     * devem ser postos entre parênteses após o nome do método. Ex.:
     * 
     * Calculator multiplicator = new Calculator();
     * multiplicator.multiplication(5, 6);
     *
     * Métodos podem ter mais de dois parâmetros, mas há um consenso de que métodos com
     * mais de 3 argumentos fazem muita coisa, e poderiam ser divididos em métodos menores.
     * COMO FUNCIONAM CLASSES E MÉTODOS:
     * Um método é criado numa classe, geralmente num arquivo diferente do que executa;
     * a classe onde está o método é importada para o código executante, e o Java, quando
     * chega na linha onde está a classe importada, vai ao arquivo da classe,
     * executando a partir deste tanto a classe quanto o método.
     *
     * RETURN:
     * Como dito acima, o retorno do método fica após o modificador de acesso e antes do
     * nome do método. O retorno é, praticamente, uma variável a qual será atribuído o
     * resultado da ação designada ao método, mesmo que não haja uma saída, como uma
     * impressão no console.
     * Para determinar o retorno, podemos utilizar qualquer tipo de variável, primtivo ou
     * de referência; isso implica que o valor retornado só poderá ser do tipo declarado
     * no método, a não ser que se faça um casting. Ex., método para dividir:
     */
    public double divideTwoNumbers(double num1, double num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1/num2;
    }
    /* Em divisões com dividendo = 0, temos resultado igual a infinito; usamos então
     * uma condicional com if, para evitar esse retorno.
     * Note-se que basta escrever o valor do retorno após "return", sem qualquer especialidade.
     * Se a condição for verdadeira, o return da condicional desconsidera instruções posteriores.
     * Para ter uma saída do valor do retorno, pode-se atribuir esse valor a uma variável ou
     * usá-lo diretamente no comando, como em qualquer outra situação.
     * OBSERVAÇÕES:
     * 1.POder-se-ia usar lógicas diferentes para chegar ao mesmo resultado
     * do método exemplo acima. Poderíamos usar else na condicional com
     * com if ou relacionar o divisor como != 0, por exemplo.
     * 2. Um método sem retorno, ou seja, com void, exige atenção na construção
     * lógica, pois não pode ter valor de return na estrutura. Seria necessário,
     * num caso como o do exemplo, usar else. Além disso, um método sem retorno
     * não pode ser posto no print, esse comando trabalha com o valor do
     * retorno.
     */
    public void divideTwoNumbers2 (double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero!");
        }
        System.out.println(num1 / num2);
    }
    /* Num método como esse, temos um problema: sem o return, o comando após a
     * condicional também será executado, por isso é necessário o else: do contrário
     * teremos a impressão da mensagem e do resultado da divisão por zero, "infinity".
     * Na estrutura if, não podemos usar break, pois break só funciona em loops.
     * Porém, podemos usar o termo return, sem atribuir valor, de modo
     * que return simplesmente faça o Java ignorar comandos seguintes, mas somente
     * dentro da estrutura condicional. Fica, então, assim:
     */
     public void divideTwoNumbers3 (double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero!");
            return;
        }
        System.out.println(num1 / num2);
    }
    /* PARÂMETROS DE TIPOS PRIMITIVOS:
     * Quando usamos variáveis de tipo primitivo como parâmetros para um método,
     * o Java não altera a referência das variáveis, ou seja, não substitui o valor
     * em memória referenciado com o nome que cria a variável; o que ocorre, na verdade,
     * é a alteração do valor de uma cópia usada especificamente no método naquele comando.
     * Ex.: Na classe fazemos isso:
     */
    public void changeTwoNumbers(int num1, int num2) {
        num1 = 7;
        num2 = 12;
        System.out.println ("num1 = " + num1);
        System.out.println ("num2 = " + num2);
    }
    /* E num código-teste fazemos isso:
     *
     * public static void main(String[] args) {
     *   Calculadora changer = new Calculadora();
     *   int num1 = 1;
     *   int num2 = 2;
     *   System.out.println("Dentro do alteraDoisNumeros");
     *   changer.alteraDoisNumeros(num1, num2);
     *   System.out.println("Fora do alteraDoisNumeros");
     *   System.out.println("num1 = " + num1 + " e num2 = " + num2);
     * }
     * 
     * Quando o compilador executa, o valor de num1 e num2 no último print é o
     * declarado no código, mesmo que essas variáveis tenham nomes iguais aos dos
     * parâmetros do método que altera e sejam usadas no método antes desse último
     * print, pois, como dito, o método alterou cópias dos valores das variáveis
     * declaradas e não elas mesmas.
     * Vale lembrar ainda que essas quatro variáveis, as do método dentro da classe
     * e as do código-teste, são objetos diferentes e de escopo local.
     *
     * PARÂMETROS DO TIPO DE REFERÊNCIA:
     * Antes, algumas notas:
     * 1. Exige-se cuidado ao realizar importações de classes,
     * em particular quando existem classes com nomes iguais
     * em locais diferentes;
     * 2. Se uma classe for usada noutro código, ela só precisa ser importada se
     * estiver noutro pacote: o Java reconhece classes no pacote em que ocorre a "chamada".
     *
     * Quando usamos uma variável de referência como parâmetro de métodos, o método usa
     * uma cópia da dela e acessa o objeto referido pela variável, enquanto dura o método:
     * assim que o método é executado o parâmetro deixa de acessar o objeto antes referido.
     * Se a variável de referência referencia objetos, estarão envolvidos vários valores,
     * normalmente. Então, trabalhar com comandos para cada valor pode deixar o código
     * sobrecarregado; aí é interessante lembrar da coesão e considerar usar uma classe
     * específica para realizar certas operações com vários atributos de objetos. Ex.:
     * Criamos uma classe para imprimir todos os dados de objetos da classe
     * Student:
     */
    //public class ImpressoraEstudante {
    public void printAtributes (Student estudante) {
        System.out.println("Dados do estudante:");
        System.out.println (estudante.nome);
        System.out.println (estudante.idade);
        System.out.println (estudante.sexo);
    }
    /* Depois usamos isso numa classe executora:
     *
     * public class StudentTest {
     *     public static void main (String[] args) {
     *         Student estudante01 = new Student();
     *         Student estudante02 = new Student();
     *         PrinterStudent printer = new PrinterStudent();
     *
     *         estudante01.nome = "João";
     *         estudante01.idade = 25;
     *         estudante01.sexo = 'M';
     *         estudante02.nome = "Maria";
     *         estudante02.idade = 30;
     *         estudante02.sexo = 'F';
     *
     *        printer.prints(estudante01);
     *        printer.prints(estudante02);
     *     }
     * }
     * 
     * Assim não precisamos printar isoladamente cada atributo dos objetos criados da classe.
     *
     * IMPORTANTE: É necessário muito cuidado aos usar variáveis de referência
     * como parâmetros para métodos, pois, assim como quando se usa variáveis de
     * tipo primitivo, métodos podem alterar valores declarados, mas com uma diferença:
     * MÉTODOS ALTERAM DIRETAMENTE OS OBJETOS, e não cópias destes.
     * Por isso, se um método altera algum atributo de objeto, quando o método for usado,
     * o valor do atributo em questão será o indicado no código do método, num momento que
     * depende de onde a alteração é colocada. Ex.:
     * Usando a classe PrinterStudent, podemos criar um método semelhante ao prints, citado
     * acima, mas adicionar um comando para que seja modificado o atributo nome, por exemplo:
     */
    public static void changeAndPrints (Student estudante) {
        estudante.nome = "Tiago";
        System.out.println("Dados do estudante:");
        System.out.println (estudante.nome);
        System.out.println (estudante.idade);
        System.out.println (estudante.sexo);
    }
    /* A mudança de nome ocorre antes da impressão dos atributos; isso faz com que o objeto
     * usado como parâmetro mediante a variável de referência tenha o seu valor de nome
     * alterado antes do método imprimir os valores dos atributos; se, porém, a mudança
     * de nome vier depois, o método realiza o comando, no caso imprimir, e depois altera.
     * Repetindo: o método usa a mesma referência do objeto ligado a ela e ALTERA O PRÓPRIO
     * OBJETO, e uma vez alterado, permanece assim em usos posteriores, mesmo que o método termine.
     *
     * Para evitar problemas com essas alterações, boas práticas de programação indicam:
     * caso seja necessário alterar algum valor em objetos, é preferível CRIAR UM RETORNO
     * DE NOVOS OBJETOS.
     *
     * REFERÊNCIA THIS:
     * Depois de tudo o que foi feito, podemos constatar que sempre recorremos ao método para
     * usar os objetos nos comandos. Mas poderíamos criar na própria classe de objetos trabalhados
     * métodos que acessem os atributos dos objetos gerados nela. Parece uma prática que reduz
     * a coesão do projeto, porque dá mais uma função à classe responsável por gerar os objetos,
     * mas é uma pratica boa! porque, num projeto com muitas classes, criar classes específicas
     * para identificar (imprimir) cada tipo de objeto aumentaria enormemente o número de classes.
     * (Será tratado melhor disso quando se falar sobre herança.)
     * Ao criar o método dentro da classe do objeto, não precisamos indicar o objeto como parâmetro,
     * porque o método passa a estar dentro do objeto, e já tem acesso aos atributos. Então,
     * basta que depois usemos a REFERÊNCIA THIS: ela referencia exatamente os
     * atributos da classe onde está, e por consequência do objeto.
     * 
     * public void printerStudent() {
     *    System.out.println("Dados do estudante:");
     *    System.out.println(this.nome);
     *    System.out.println(this.idade);
     *    System.out.println(this.sexo);
     * }
     * 
     * Mas, a não ser que haja outras variáveis locais, this é dispensável nesse uso.
     * 
     * VER CLASSES WORKER E WORKERTEST (exercício resolvido), nos pacotes domain e tests.
     *
     * ARRAYS E Var Args. 
     * Assim usamos arrays como parâmetros:
     */
    public void sumArray (int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }
    /* Não é possível declarar diretamente elementos de array entre chaves
    * na execução, mas é possível declarar por inteiro o array:
    */
    public static void main(String[] args) {

        Calculator adder2 = new Calculator();

        adder2.sumArray (new int[] {1, 2, 3, 4, 5});
    }
    /* Existe outra forma de representar arrays nas assinaturas, que é de
    * criação posterior a dos arrays: VAR ARGS. A sintaxe é pouco diferente:
    * Deve-se declarar o tipo da variável parâmetro seguida de reticências e
    * do nome:
    */
    public void sumVarArgs (int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }
    
    /* A diferença está na "chamada": a variável Var Args é tratada como um array,
     * é transformada em array, enquanto pode ser constituída de vários elementos.
     * Trata-se então de uma sintaxe que simplifica a operação, e permite o que não podemos
     * com arrays: declarar vários elementos como parâmetros de um método.
     * 
     * public static void main(String[] args) {
     * 
     *    Calculator somadoraArray = new Calculator();
     *
     *    int[] numeros = {1, 2, 3, 4, 5};
     *    somadoraArray.sumArray (numeros);
     *    Assim funcionaria, mas eis o diferencial:
     *    somadoraArray.somaArray (1, 2, 3, 4, 5);
     * }
     *
     * Há uma RESTRIÇÃO: se uma Var Args for usada como parâmetro com outros elementos,
     * deve estar em último, porque o JAVA NÃO SABE ONDE ONDE TERMINA A SEQUÊNCIA DE UMA VAR ARGS.
     * Fora isso, Var Args pode ser usada mesmo antecedida de tipos diferentes como String.
     * Além disso, sendo Var Args equivalente ao array, podemos também escrever
     * nosso método "...(String[] args)" como: "(String... args)".
     * 
     * ACOPLAMENTO
     * Acoplamento é o quanto uma classe está relacionada a outra.
     * Podemos usar, ao invés de public, um modificador de acesso que limite o quanto outras
     * classes podem acessar determinados métodos ou variáveis: o private.
     * Com ele, apenas a classe que contém esse elemento privado pode acessá-lo.
     * Se, por exemplo, quiséssemos criar uma classe Person com os atributos name e age,
     * poderíamos declará-los como privados e criar um método publico específico para modificar
     * os valores desses atributos.
     * Para isso, usamos no nome do método o prefixo "set" seguido do nome do atributo a ser
     * alterado. Essa é uma das convenções mais fortes do Java.
     * 
     * public class Person {
     *      private String name;
     *      private int age;
     * 
     *      public void setName(String name) {
     *      this.name = name;
     *      }
     *      public void setAge (int age) {
     *      this.age = age;
     *      }
     * }
     * Observação: O nome dos argumentos costuma ser igual ao dos atributos a mudar; por isso, 
     * this é necessária, porque há variável de escopo local com mesmo nome (a preferência
     * é a variável mais próxima).
     * Tudo isso baixa o acoplamento entre a classe de domínio e de teste: diferente da coesão,
     * o bom acoplamento é baixo.
     * Algo há a notar: o método com set não tem retorno: isso impede acessar o valor inicializado.
     * Para acessar, por exemplo, num print, usamos o prefixo get num método sem parâmetros,
     * pois o valor já foi guardado em memória:
     * 
     *      public String getName() {
     *      return this.name;
     *      }
     * 
     * Assim ficaria na classe-teste:
     * 
     *      Person mark = new Person;
     *      mark.setName("Mark");
     *      mark.setAge(25);
     * 
     *      System.out.println(mark.getName());
     *      System.out.println(mark.getAge());
     * 
     * Por motivos práticos, não faz sentido usar métodos get em métodos dentro da própria
     * classe que origina os objetos, já que os atributos são acessíveis por ela. Ex.:
     * 
     *      public void printAtributes() {
     *          System.out.println(this.name);
     *          System.out.println(this.age);
     *      }
     * 
     * Uma vez que é possível limitar o acesso ao template de uma classe, o comum é tornar
     * privado tudo o que não se quer que seja alterado por outras classes, usar disso
     * para gerenciar o que pode ser trabalhado por uma classe terceira e o que deve sê-lo
     * somente pela classe originária.
     * Com essa ideia podemos, por exemplo, retrabalhar a classe Worker para que o valor
     * da média de salários seja inalterável por outras classes, neste caso, WorkerTest,
     * para que a média só possa ser lida.
     */
}