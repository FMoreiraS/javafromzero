package core.bintromethods.domain;

/* Exercício: criar classe funcionário com atributos nome, idade, salário;
 * Três salários devem ser guardados, para o mesmo objeto. Criar dois métodos:
 * 1. para imprimir os dados;
 * 2. Para tirar a média dos salários e imprimir o resultado.
*/

public class Worker {   // Atributos alterados para private, após aprender set e get.
    public String name;
    public int age;
    public double[] salaries;
    public double mean;

    public void identifier() {
        System.out.println(this.name);
        System.out.println(this.age);
        // This agora não funciona, pois se trata de vários valores num array.
        if(salaries != null ) {            // If inicialmente não usado
            for(double salary : salaries) {
            System.out.print(salary + "; ");
            }
            salarialMeanCalculator();
        }
    }
    // Seria melhor criar este método em classe própria, mas aqui aceitamos.
    public void salarialMeanCalculator () {
        if(salaries != null) { // If inicialmente não usado
            for (double salary : salaries) {
                mean += salary;
            }
        
            mean /= salaries.length;
            System.out.println("\nSalarial media of " + mean);
        }
    }
    /* O prof. observa: esse calculador de média pode ser chamado pelo método anterior
     * que imprime, reduzindo o número de chamadas de método noutro programa.
     * Além disso, o código está aberto a ERROS: se não houver declaração de valores
     * no array salaries, teremos "NullPointerException", ou seja, alerta de que
     * tentou-se usar algo que não existe:
    
    Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "<local1>" is null
	at maratonajava.javacore.Bintroduçãométodos.domain.Worker.identifier(Worker.java:20)
	at maratonajava.javacore.Bintroduçãométodos.test.WorkerTest.main(WorkerTest.java:15)
    
     * A mensagem é chamada Stack Trace, e lemo-la de baixo para cima, porque assim condiz
     * com a ordem de execução do código.
     * Outro problema com este código: teremos também exceção se o valor do array salaries
     * for null, ou seja, se não receber inicializações. Isso exige que os métodos usem if
     * para suprir essa possibilidade.
     * Por fim, há outro problema: o método passou a ter um if grande, e depender totalmente
     * dele; a construção pode ser melhor. Podemos usar return para fazer apenas um breve if
     * de checagem, sem usar retorno nos métodos:
    */
    public void identify() {
        System.out.println(this.name);
        System.out.println(this.age);
        if(salaries == null ) {
            return;
        }
        for(double salary : salaries) {
            System.out.print(salary + "; ");
        }
        meanCalculator();
    }

    public void meanCalculator () {
        if(salaries == null) {
            return;
        }
        double media = 0;
        for (double salary : salaries) {
            media += salary;
        }
        
        media /= salaries.length;
        System.out.println("\nSalarial media of " + media);
    }
    /* Ainda que o método mediaCalculator fosse private, isto é, tivesse acesso limitado
     * aos métodos que o chamam, poderia ser chamado por outros métodos que não fazem
     * a verificação para impedir que um valor null passe: por isso vale usar o if como
     * está acima nos dois métodos.
     * 
     * MODIFICANDO O ACESSO e usando set e get:
     * Para não perder a utilidade dos valores públicos, crio novos.
    */
    private String name2;
    private int age2;
    private double[] salaries2;
    private double mean2;

    public void setName2(String name) {
        this.name = name;
    }
    public String getName2() {
        return name;
    }
    public void setAge2(int age) {
        this.age = age;
    }
    public int getAge2() {
        return age;
    }
    public void setSalaries2(double[] salaries) {
        this.salaries = salaries;
    }
    public double[] getSalaries2() {
        return salaries;
    }
    // Como double mean não deve ser alterada, usamos apenas get, não set.
    public double getMean2() {
        return this.mean;
    }
    /* Agora todos os métodos que usam diretamente os atributos são inúteis, pois os
     * atributos são privados e serão usados com valores padrão, zero e null.
     * Precisam ser refeitos.
     */
    public void identify2() {
        System.out.print("Name: " + getName2() + ", ");
        System.out.print("age: " + getAge2() + "\n");
        if(salaries == null ) {
            return;
        }
        for(double salary : salaries) {
            System.out.print(salary + "; ");
        }
        meanCalculator2();
    }

    public void meanCalculator2() {
        if(salaries == null) {
            return;
        }
        for (double salary : salaries) {
            mean += salary;
        }
        
        mean /= salaries.length;
        System.out.println("\nSalarial media of " + getMean2());
    }
}