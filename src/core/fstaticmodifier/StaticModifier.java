package core.fstaticmodifier;

public class StaticModifier {
    /* O modificador static torna atributos INERENTES à classe, ou seja, não apenas
     * pertencente a uma instância, a um objeto, mas tudos que pertencem à classe.
     * Exemplo: Alguns fabricantes de carros acordaram em limitar a velocidade dos veículos
     * a 250 km/h. Representamos isso com uma classe Car com atributos privados name, maxSpeed
     * e limitSpeed, criamos setters e getters para acessá-los e construtores.
     
        private String name;
        private int maxSpeed;
        private int limitSpeed = 250;

        public void print() {
            System.out.println("================");
            System.out.println("Nome: " + this.name);
            System.out.println("Velocidade máxima: " + this.maxSpeed);
            System.out.println("Velocidade limite " + this.limitSpeed);
        }
     
     * Criando objetos e definindo name e maxSpeed, podemos ver num print que todos compartilham
     * a limitSpeed = 250; mas se um dos objetos usar setLimitSpeed, terá o valor alterado só
     * em si, o que seria desconforme ao acordo.
    
        Car car1 = new Car("R34", 280);
        Car car2 = new Car("Supra", 270);
        
        car1.print();
        car2.print();
        
        Car car3 = new Car("GT", 300);

        car3.setLimitSpeed(350);
        car3.print();
    
     * Remover o setLimitSpeed não é a melhor solução.
     * O modificador static pode tornar esse atributo essencial à classe Car, de modo que a
     * alteração dele ocorra em todos os objetos do tipo Car.
     * Inicialmente criamos o método print usando this para imprimir os atributos, mas se
     * limitSpeed for um atributo estático, this será inadequada, pois this REFERENCIA SEMPRE
     * O OBJETO.
     * O modificador static pode estar apenas antes ou depois do modificador public/private,
     * mas segundo as boas práticas, deve estar depois:
     
        public static int limitSpeed2 = 350;
    
     * Para acessar, incrementando o print:
     
        public void print() {
            System.out.println("================");
            System.out.println("Nome: " + this.name);
            System.out.println("Velocidade máxima: " + this.maxSpeed);
            System.out.println("Velocidade limite " + this.limitSpeed);
            System.out.println("Velocidade limite estática: " + Car.limitSpeed2);
        }

     * Agora qualquer alteração valerá para todo objeto, e o modo de alterar também é pela classe:
     
        Car.limitSpeed2 = 300;

     * Uma vez que o atributo é estático, pode ser acessado mesmo que não sejam criados objetos.
     * 
     * STATIC METHODS
     * Assim como atributos estáticos não são acessados mediante instâncias de uma classe,
     * métodos estáticos só podem acessar atributos estáticos, diretamente através da classe.
     * Continuando o exemplo trabalhado. É impossível usar um método set estático para definir
     * um atributo de instância, como private int limitSpeed. Então só resta usar um set estático
     * para definir limitSpeed2, mas, com um método estático, esse atributo poderia ser privado.
    
        public static void setLimitSpeed3(int limitSpeed3) {
            Car.limitSpeed3 = limitSpeed3;
        }
    
     * Como nos atributos, a convenção é usar static após o modificador de acesso.
     * Uma coisa exige atenção: temos em Car o método não estático print, e nele podemos usar
     * this para referenciar limitSpeed2; mas, tal como o IDE sugere, esse atributo estático
     * deve ser prefencialmente acessado mediante a classe, como foi feito, e só é possível
     * usar this porque o método não estático só poderia ser usado por um objeto, ou seja,
     * há uma garantia de que esse método acessaria o atributo de um objeto.
     * Portanto, métodos e atributos estáticos são anteriores a qualquer instância, por isso
     * podem ser usados mesmo quando não houver um objeto numa classe, e não podem acessar
     * atributos não estáticos porque existe a possibilidade de não existirem objetos.
     * QUANDO então usamos métodos estáticos? Quando os métodos não precisam acessar
     * atributos de instâncias da classe.
     * Agora é possível entender "public static void main(String[] args)": é um método
     * acessível a qualquer objeto, que acessa apenas atributos estáticos da clase onde está,
     * não possui retorno, chama-se main e recebe como argumento um arrays de strings chamado
     * args. Implica que se algum atributo for declarado antes dele, só será acessível se for static.
     *
     * BLOCO DE INICIALIZAÇÃO ESTÁTICO
     * Quando um objeto é criado e existe numa classe um bloco de inicialização, este é executado
     * sempre que um objeto é criado. Por isso, para diminuir a quantidade de informações a processar,
     * podemos usar blocos de inicialização estáticos quando há atributos estáticos para inicializar
     * em todos os objetos da classe, de modo que o bloco seja executado apenas uma vez.
     * A respeito da ordem de execução: antes de tudo são executados os elementos estáticos da classe,
     * inclusive os blocos de inicialização:
     * 1. Execução de tudo que é estático quando a JVM carrega a classe;
     * 2. Alocação de espaço em memória para objetos;
     * 3. Inicialização dos atributos com valores padrão ou determinados pelo autor;
     * 4. Execução do bloco de inicialização;
     * 5. Execução dos construtores.
     * Uma vez que há essa ordem no Java, explica-se porque não é possível acessar atributos de
     * instância em métodos estáticos: estes são executados antes mesmo de haver objetos.
     * Para tornar estático um bloco de inicialização basta usar o modificador antes das chaves.
     * É possível usar vários blocos de inicialização na mesma classe, e mesmo usar estáticos e
     * não estáticos. (Ver na classe StaticInitializationBlockTest a ordem de execução.)
    */
}
