package intro;

public class PrimitiveTypes {
    public static void main(String[] args) {
        /* Os tipos primitivos são 8: int, double, float, char, byte, short, long, boolean.
         * Tipos primitivos são tipos que guardam em memória um valor simples.
         * São palavras reservadas.
         * Para declara variável, é necessário digitar tipo, nome, =, um valor e ;. Ex.:
        */
        int age = 18;
        int AgeAt2025 = 19;
        /*Convenção: o nome da variável inicia com minúscula, mas, se for composto,
         * demais elementos iniciam com maiúscula. Ex.:
        */
        int beginningOfMaratona = 2101;
        /* Não se usa " " para imprimir o valor da variável.
         * Para concatenar valor de variável com texto, utiliza-se + entre eles, deixando espaço. Ex.:
        */
        System.out.println("O estudante completa "+AgeAt2025+" anos em 2025.");
        /* Com exceção do boolean, que recebe valor de true ou false, todos os
         * tipos assumem valores numéricos, ainda que char possa ser um caractere.
         * A diferença está na quantidade aceita por cada tipo em uma variável.
         * Existem tabelas com esses valores. Coloco os tipos em ordem,
         * de acordo com quantos bits podem receber.
        */
        byte smallNumber = 7;      //1 byte, 8 bits.
        boolean reason = true;     //Same.
        boolean feeling = false;   //Same.
        short birthday = 31;       //2 bytes, 16 bits.
        char userSex = 'M';        //Same.
        int currentYear = 2025;    //4 bytes, 32 bits.
        float savings = 19.5F;      //Same.
        double decimal = 35600.49; //8 bytes, 64 bits.
        long bigNumber = 1900500;  //Same.
        /* int e long são utilizados para números inteiros, float e double para decimais.
         * O valor de char é baseado na tabela ASCII, onde um número designa um caractere,
         * mas também pode-se usar um Unicode, com contrabarra e u seguidos do número
         * correspondente a cada caractere, tudo entre ''.
        */
        char test = '\u0049';
        System.out.println(test);
        /* Valores de variáveis podem ser identificados, como pertencentes a um tipo primitivo,
         * convencionalmente com finando-o com inicial maiúscula. Isto é usado para o casting,
         * que pode ser definido como o uso de um valor em um tipo primitivo que não o aceitaria
         * normalmente, o que pode não funcionar como esperado. Para indicar à maquina que deseja-se
         * realizar casting, o valor da var. deve ser antecedido do tipo que está sendo "forçado"
         * e seguido da inicial do tipo a que pertence.
        */
        int salario = (int) 2783.57D;
        System.out.println(salario);
        // A máquina ignorou a parte decimal da var acima, porque a var é int, não double.

        /* String: Não é de tipo primitivo, mas uma classe, que aceita um valor textual, e
         * o uso de ASCII, Unicode, UTF.
         */
         String MsgUnicode = "\u0055\u006E\u0069\u0063\u006F\u0064\u0065";
        System.out.println(MsgUnicode);

        /* Exercício: criar variáveis para os campos entre < > e imprimir a mensagem:
         * Eu, <nome>, morando no endereço <endereço>, confirmo que recebi o salário de R$ <salário>,
         * na data <data>.
        */
        String nome = "Imortal Pereira Silva";
        String endereço = "Rua 30 de Fevereiro, número 01, Bairro Utopia";
        float salary = 3567.89F;
        String data = "30 de agosto de 2025";
        System.out.println("Eu, "+nome+", morando no endereço "+endereço+", confirmo que recebi o salário de R$ "+salary+", na data "+data+".");
        /* O mestre William criou uma String para para a mensagem, ao invés de colocar a
         * mensagem no print.
         * String relatorio = "Eu...";
         * System.out.println(relatorio);
         * Isso pode ser melhor, se a mensagem puder ou precisar ser utilizada novamente.
        */
    }
}
