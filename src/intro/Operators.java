package intro;

public class Operators {
    //Os ops. aritméticos são 4: +, -, *, / e %.
    //Para realizar operações, basta colocar o sinal do operador entre os valores:
    public static void main (String[] args){
        int number2 = 2;
        int number5 = 5;
        System.out.println(number2+number5);
        System.out.println(number2-number5);
        System.out.println(number2*number5);
        System.out.println(number2/number5);
        /* Obs.: Operações entre inteiros têm sempre resultados inteiros;
        para que se obtenha o resultado, pode-se mudar o tipo de uma das vars. para
        outro que aceite decimais (double, float) ou usar casting numa das vars.,
        dentro do print (não recomendado). Exs.:
        */
        double number7Double = 7D;
        System.out.println(number7Double/number2);
        System.out.println((float) number7Double/number2);
        /* Caso se use o operador + com strings e números, há uma
        concatenação sem a operação:
        */
        System.out.println("O valor é "+number2+number5);
        /*Isto imprime 25: concatenação de algarismos. Mas, se + vier antes da string,
        o compilador considerará ali, entre as vars., como operador de soma. Ex.:
        */
        System.out.println(number2+number5+" é o valor.");
        // O operador de resto, %, indica o resto de uma divisão:
        int remainder = 5%2;
        System.out.println(remainder);
        /* OPERADORES RELACIONAIS: <, >, <=, >=, ==, !=.
        Operadores relacionais e lógicos retornam sempre valores "booleanos": true ou false.
        Obs.: Uma vez que o sinal de igual é utilizado pelo Java como atribuidor,
        o op. lógico de igualdade se distingue com esse sinal duplicado.
        
        OPERADORES LÓGICOS: And (&&), or (||), no (!)
        && (and) expressa adição de ideias.
        Para que o valor boolean seja true, todas as expressões nele devem ser true.
        Para o exemplo, suponhamos que um salário qualquer varie conforme o tempo de
        atividade de um funcionário, em anos; cada ano equivale a 500 reais, o valor inicial
        é 4000 e o teto salarial é 10000.
        */
        int experience = 5;
        float salary = 4000;
        boolean amIReceivingRightly = experience == 5 && salary == 6500;
        System.out.println(amIReceivingRightly);
        /* O resultado impresso é falso, pois salary é menor que o declarado na
        var. boolean.

        Op. or (||): para o valor da var. boolean seja verdadeiro, pelo menos
        uma das atribuições deve ser verdadeira.
        */
        float checkingAcountAmount = 3000F;
        float savingsAcountAmount = 1000F;
        double desktopValue = 4000D;
        boolean canIBuyAComputer = checkingAcountAmount >= desktopValue || savingsAcountAmount >= desktopValue;
        System.out.println ("canIBuyAComputer is "+canIBuyAComputer);

        /* OPERADORES DE ATRIBUIÇÃO: =, +=, -=, *=, /=, %=.
        Fora =, os demais ops. são muito úteis para reduzir o código, ao substituírem
        expressões em modificações após a declaração de vars. Exs.:
        */
        float bonus = 1000F;
        bonus += 1000;
        //No lugar de: "bonus = bonus+1000;"
        bonus -= 500; // '' "bonus = bonus-500".
        bonus *= 2; // '' "bonus = bonus * 2".
        bonus /= 3; // '' "bonus = bonus / 3".
        bonus %= 2; // '' "bonus = bonus % 2".
        System.out.println (bonus);
        /* Após uma sequencia de alterações como esta, o Java tem apenas o valor final na memória.
        *
        * OPERADORES UNÁRIOS: ++, --.
        * São usados para alterar vars. declaradas unitariamente, reduzindo o código.
        */
        int counter = 0;
        counter++; //Ao invés de: counter += 1.
        counter--;
        System.out.println ("Primeiro contador: " + counter);
        /* As alterações podem ser feitas também no print.
        * Além disso, os operadores podem estar antes e depois da var., conforme se deseje que a
        * alteração ocorra antes ou depois de certas ordens. É diferente escrever:
        */
        int counter0 = 0;
        System.out.println ("Segundo contador: " + counter0++); // e...
        System.out.println (++counter0);
        /* O Java entende que deve primeiro executar o comando (aqui, print),
        * e depois alterar o valor, o que faz o primeiro print exibir 0
        * e a var. assumir o valor alterado (1) a partir da próxima linha.
        * Quando o op. vem antes da var., primeiro é executada a alteração
        * e depois o resto.
        */
    }
}
