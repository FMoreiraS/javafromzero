package core.oexceptions.test;

public class StackOverflowErrorTest {
    public static void main(String[] args) {
        recursiveMethod();
    }

    private static void recursiveMethod() {
        recursiveMethod();
    }
    /* O método recursivo faria infinitas chamadas a si mesmo, mas a memória
     * do servidor é limitada. Então, ocorre um "inchaço" da stack, a pilha
     * de execução, até o esgotamento da memória, que é alocada dinamicamente
     * conforme as necessidades da pilha.
     */
}
