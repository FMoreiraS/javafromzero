package intro;

public class Loops {
    public static void main (String[] args){
        /* Estruturas de repetição (loops, "laços") envolvem iterações de ações pelo programa.
         * Existem 3 tipos de laços de repetição: "while", "do while" e "for".
         *
         * WHILE:
         * int variavel = 0;
         * while (variavel <= n) {
         *  System.out.println (msg);
         * }
         * while apresenta essa sintaxe, e só é executado caso o valor entre parenteses seja booleano
         * VERDADEIRO. Se a var. não for alterada, o programa repete while até haja alteração
         * (no exemplo, 0 é impresso infinitamente).
        */
        int counter = 0;
        while (counter < 5) {
            System.out.println (++counter);
        // ou: counter += 1;
        }
        System.out.println("-------------"); // Separador
        // OBS.: Alterar a var. fora do bloco não funciona.
        /*
         * DO–WHILE:
         * do while não exige que a relação seja verdadeira, para executar pelo menos uma vez o
         * comando; se a condição for verdadeira, ocorrerá a repetição. Também repete-se
         * infinitamente se a var. não for alterada.
        */
        int counter2 = 0;
        do {
            System.out.println ("Contando: "+ counter2);
            counter2++;
        } while (counter2 < 5);
        System.out.println("-------------"); // Separador
        /* Se não houver declaração de var. antes do do-while, não há iteração, o valor utilizado
         * é o anteriormente declarado (ou sua atualização).
         * OBS.: Em estruturas de repetição e condicionais com apenas uma instrução, as chaves podem ser
         * omitidas sem perdas na execução.
         *
         * FOR:
         * For usa uma var., inicializada na estrutura, para funcionar, comumente chamada i (de
         * incrementer ou iteration), e a próxima  j, quando há mais de uma. A instrução vem no bloco.
         * O for conta para o Java como uma única linha de execução, podendo ser usado dentro de um if
         * desacompanhado de chaves.
        */
        for (int i = 0; i < 5; i++) {
            System.out.println ("i igual a "+ i);
        }
        System.out.println("-------------"); // Separador
        // EXERCÍCIO com for: imprimir todos os números pares de 0 a 100.
        for (int e = 0;e <= 100; e += 2) {
            System.out.println (e+" é par.");
        }
        System.out.println("-------------"); // Separador
        /* Resolução imperfeita, pois se "e" for igual a um ímpar, perde-se o código. O prof. usou:
         *   for (int e = 0;e <= 100; e++) {
         *     if (e % 2 == 0) {
         *     System.out.println (e+" é par.");
         *     }
         *   }
         *
         * Pode-se parar a iteração de um laço com break, como num switch. Ex.: imprimir os primeiros 25
         * números dentre 50.
        */
        int valorMax = 50;
        for (int j = 0; j <= valorMax; j++) {
            if (j > 25) {
                break;
            }
            System.out.println ("j = " + j);
        }
        System.out.println("-------------"); // Separador
        /* OBS.: Poder-se-ia por o print no if, ordenando a impressão da var de acordo com o desejado,
         * if (j <= 25) System.out.println ("j = " + j), desprezando o break, mas a ITERAÇÃO CONTINUARIA,
         * influenciando demais instruções que estariam no for.
         *
         * EXERCÍCIO com break:
         * Descobrir quantas vezes um carro
         * pode ser parcelado, custando 50
         * mil; a parcela deve ser >= 1000.
         *
         * Minha tentativa:
        */
        float carValue = 50000;
        for (int installmentNumbers = 1; installmentNumbers <= 50; installmentNumbers++) {
            float installmentValue = carValue / installmentNumbers;
            if (carValue % installmentNumbers != 0) {
                continue;
            }
            System.out.println ("O carro pode ser pago em "+installmentNumbers+"x de "+installmentValue);
        }
        System.out.println("-------------"); // Separador
        /* Não consegui resolver como esperado: isso não é escalável.
         * Segue a resolução do professor.
        */
        double valorTotal = 30000;
        for (int parcela = 1; parcela <= valorTotal; parcela++) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000) {
                break;
            }
            System.out.println ("Parcela "+parcela+" R$ "+valorParcela);
        }
        /* Essa construção é boa! pois economiza palavras, uma vez que poder-se-ia usar if com
         * valorParcela > 1000 e else com break; mas interferiria no resto do for, como se disse.
         *
         * CONTINUE:
         * Continue funciona de modo inverso ao break: continua a iteração. Usando a situação anterior como
         * exemplo:
        */
        System.out.println("-------------"); // Separador
        for (int parcela = (int) valorTotal; parcela >= 1; parcela--) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000) {
                continue;
            }
            System.out.println ("Parcela "+parcela+" R$ "+valorParcela);
        }
        /* Com continue, o Java desprezou o decréscimo de parcela até que valorParcela fosse >= 1000,
         * ou seja, a impressão começa quando parcela assume o valor 30 e termina quando assume 1.
        */
    }
}