package intro;

public class Arrays {
    public static void main (String[] args) {
        /* Vetor ou array, "variedade, ordem de coisas", é um OBJETO em memória, não diz
         * respeito a um valor específico, mas REFERENCIA variáveis que
         * compreende em conjunto. Cria-se um array escrevendo [] após o tipo
         * das vars. (funciona se colocado depois do nome, mas após tipo é melhor);
         * em seguida o nome do array, comumente no plural, pois compreende vários
         * objetos; atribui-se então "new tipo da var." e a quantidade de espaço
         * que deve ser reservado em memória. Eis a sintaxe:
        */
        int[] idades = new int[2];
        /* Arrays, como as Strings, são vars. do tipo refers, e podem ser
        inicializados com null.
         * Ao imprimir uma posição no array sem vars. declaradas, haverá uma resposta
         * padrão conforme o tipo das variáveis.
         * Os objetos do array são indexados, ou seja, possuem índices, posições
         * que precisam ser referenciadas para usar as variáveis no código. A primeira
         * posição de um array é sempre 0.
        */
        idades [0] = 18;
        idades [1] = 7;
        /* Posições que excedem o número declarado para os arrays não podem ser acessadas:
         * tentar resulta em exceção, "out of bounds", "fora dos limites".
         * 
         * Existem valores padrão para os tipos de vars. não inicializadas, quando são usadas
         * fora do escopo local ou num array:
         * byte, short, int, double, e float recebem 0;
         * char recebe em unicode = '' (ou seja, '\u0000');
         * boolean recebe false;
         * refers (string, array) recebem null.
         * 
         * Uma forma de acessar os valores de um array é usar o for tendo o índice como var.,
         * mas, ao invés declarar numericamente a última posição do array, pode-se dizer
         * ao IDE nomedoarray.length, ou seja, indicar a propriedade comprimento.
        */
        for (int i = 0; i < idades.length; i++) {
            System.out.println (idades [i]);
        }
        /* Os arrays não podem ter o tamanho aumentado dinamicamente, isto é,
         * precisamos reescrever e recompilar sempre que o tamanho do array for
         * alterado, por isso é de muita utilidade referenciar ao IDE a propriedade length.
         * Como se faz com vars., o tamanho do array também pode ser alterado em outra linha.
        */
        idades = new int [3];
        System.out.println (idades [2]);

        /* Existem outras duas formas de inicializar os arrays, economizando linhas:
         * 1. colocando elementos entre chaves após "new tipo", sem declarar tamanho do array
         * (porque o java calculará):
        */
        int[] numeros = new int []{1, 2, 3, 4, 5};
        // 2. colocando elementos do array entre chaves,sem escrever new "tipo":
        int[] lista = {15, 14, 13, 12, 11};
        // Existe também um outro for, simplificado, com o qual podemos designar um array
        // sem declarar índices para os elementos, usando apenas uma var. local, chamado FOR EACH.
        for (int var : lista) {    // Pode-se entender: int var percorrendo lista.
            System.out.println(var);
        }
        /* Variáveis não podem ser repetidas no código, como se viu; mas isso apenas dentro
         * de um mesmo escopo, ou seja, vars. de escopo local só funcionam dentro de seu escopo,
         * de modo que se possa nomear variáveis diferentes com o mesmo nome, em escopos diferentes.
         * Assim uso agora o nome de uma var. utilizada antes, em novo escopo:
        */
        for (int var : numeros) {
            System.out.println(var);
        }
        /* Obs.: É bom certificar sempre se a var. do for é de tipo igual aos dos objetos do array.
         *
         * ARRAYS MULTIDIMENSIONAIS:
         * São arrays que contêm arrays, e podem ser criados de modo parecido ao dos arrays simples,
         * acrescentado uma das formas de declaração de conteúdo ao lado da inicialização do array base.
        */
        String[][] famílias = new String [2][3];
        famílias[0][0] = "Joseph";
        famílias[0][1] = "Mary";
        famílias[0][2] = "John";
        famílias[1][0] = "Paul";
        famílias[1][1] = "Elisabeth";
        famílias[1][2] = "Daisy";
        // Para indicar os itens, podemos usar um for dentro de outro for, pois só um mostraria
        // apenas endereços de memória.
        for (int i = 0; i < famílias.length; i++) {
            for (int j = 0; j < famílias[i].length; j++) {
                System.out.println(famílias[i][j]);
            }
        }
        /* Também podemos usar o FOREACH para indicar os arrays dentro de arrays, mas usar uma
         * var. simples não funciona neste caso: precisa-se usar um array associado ao tipo de var.
         * que o array base comporta:
        */
        System.out.println("=======SEPARADOR=======");

        for (String[] casas : famílias) {
            for (String nomes : casas) {
                System.out.println(nomes);
            }
        }
        /* Caso um array não seja devidamente inicializado, ainda que se declare o
         * seu tamanho, ocorre o que o java chama de "null pointer exception", porque
         * um array é variável de referência e tem por valor padrão null.
         * Um exemplo de como ocorreria:

        int[][] arrayErrado = new int[2][]; (sem tamanho nos sub-arrays)
        for (int[] arrayMulti : arrayErrado) {
            for (String subarray : arrayMulti) {
                System.out.println(subArray);
            }
        }

         * Deixar o tamanho dos arrays menores em branco permite que cada array possa
         * ter um tamanho diferente, enquanto que declarar o tamanho na declaração do
         * array principal fixa todos no mesmo tamanho.
         * Outras possibilidades a mencionar é de inicializar os arrays multidimensionais
         * diretamente, como se faz com arrays comuns, pondo os objetos entre chaves,
         * sem escrever "new tipo...", e inicializar um array simples para depois usar-lo
         * como valor de um array multidimensional.
        */
        String[][] continentes = new String [5][]; // Ásia, Europa, África, América, Oceania
        continentes[0] = new String[2];
        continentes[1] = new String[3];
        continentes[2] = new String[1];
        continentes[3] = new String[1];
        continentes[4] = new String[1];
        String[][] locais = {{"India", "Israel"}, {"Egypt", "Sudan"}};
        for (String[] locaisGeral : locais){
            for (String locaisEspecíficos : locaisGeral){
                System.out.println(locaisEspecíficos);
            }
        }
        int[] numbers = {7, 10};
        int[] numbers2 = {12, 1000};
        // Os arrays comuns que serão arrays menores deste:
        int[][] simbols = new int [2][];
        simbols[0] = numbers;
        simbols[1] = numbers2;
        for (int[] arrayBase : simbols) {
            for (int nos : arrayBase) {
                System.out.println(nos);
            }
        }
    }
}