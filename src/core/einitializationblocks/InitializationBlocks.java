package core.einitializationblocks;

public class InitializationBlocks {
    /* INSTANCE INITIALIZATION BLOCKS:
     * Caso se queira inicializar atributos de objetos logo quando são criados, pode-se
     * fazer a inicialização diretamente num construtor (o que fará igual inicialização
     * para todo objeto que usar esse construtor). Mas isso torna essa inicialização
     * dependente desse construtor ou obrigará que se tenha ela em todos os construtores
     * da classe.
     * Os blocos de inicialização de instância (ou não estáticos) são um recurso próprio
     * para inicializar atributos de objetos de modo independente, ou seja, são executados
     * independentemente de qual construtor for usado na criação de um objeto. Os blocos
     * podem ser criados em qualquer lugar da classe, porque são sempre executados antes
     * dos construtores.
     * Temos então no Java esta ordem:
     * 1. Alocação de espaço em memória para o objeto;
     * 2. Inicialização dos atributos com valores padrão ou determinados pelo autor;
     * 3. Execução do bloco de inicialização;
     * 4. Execução dos construtores.
     * Para criar um bloco de inicialização de instância, basta usar chaves e colocar a
     * instrução entre elas.
     * Exemplo: A classe Book possui os atributos String name e int[] chapters.
    
    public Book(String name) {
        this.name = name;
        System.out.println("Construtor que inicializa name: " + getName() + ", chapters: " + chapters);
    }

    public Book() {
        System.out.println("Construtor sem parâmetros e com inicialização.");
        chapters = new int[50];
        for(int i = 0; i < chapters.length; i++) {
            chapters[i] = i + 1;
        }
        for(int chapter : chapters) {
            System.out.print(chapter + " ");
        }
    }
     
     * Com isso o vetor chapters é inicializado no contrutor sem parâmetros: se um objeto for criado
     * com o que inicializa name, chapters será impresso como endereço de memória. Então essas iterações
     * devem ir ao bloco, para realizar inicialização e impressão sempre e em todo objeto:
     
    {
        System.out.println("No bloco de inicialização.");
    
        for(int i = 0; i < chapters.length; i++) {
            chapters[i] = i + 1;
        }
        for(int chapter : chapters) {
            System.out.print(chapter + " ");
        }
    }

     * A confirmação de que o bloco é executado e inicialização é a impressão duplicada dos valores
     * em chapters: uma vez pelo bloco, outra pelo construtor.
    */
}