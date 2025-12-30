package intro;

public class PrimitiveTypes {
    public static void main(String[] args) {
        /* TIPOS PRIMITIVOS
         * São 8: int, double, float, char, byte, short, long, boolean.
         * Tipos primitivos são tipos que guardam em memória um valor simples.
         * São palavras reservadas.
         * Para declarar um dado, é necessário digitar tipo, nome, "=" e um
         * valor. Ex.:
        */
        int AgeAt2025 = 19;
        /* Em Java, ponto e vírgula (semicolon) É OBRIGATÓRIO APÓS CADA
         * LINHA DE INSTRUÇÃO.
         * Convenção: o nome da variável inicia com minúscula, mas, se for
         * composto, demais elementos iniciam com maiúscula. Ex.:
        */
        int beginningOfMaratona = 2101;
        /* Não se usa o nome da variável entre aspas para usar o valor dela.
         * Para concatenar valor de variável com texto, utiliza-se "+"
         * entre eles. Ex.:
        */
        System.out.println("O estudante completa "+AgeAt2025+" anos em 2025.");
        /* VALORES DOS TIPOS PRIMITIVOS
         * Com exceção do boolean, que recebe apenas valor true ou false,
         * todos os tipos assumem valores numéricos, ainda que char possa ser
         * um caractere. A diferença está na quantidade de bits aceita e no
         * tipo de valor.
         * Existem tabelas com esses valores. Seguem exemplos dos tipos em
         * ordem crescente de quantidade de bits aceita por cada um.
        */
        byte tinyInteger = 7;      // 1 byte, 8 bits.
        boolean logicValue = true;     // 1 byte, 8 bits.
        short smallInteger = 31;       // 2 bytes, 16 bits.
        char anyCharacter = 'M';        // 2 bytes, 16 bits.
        int integer = 2025;    // 4 bytes, 32 bits.
        float smallDecimal = 19.5F;     // 4 bytes, 32 bits.
        long bigInteger = 1900500;  // 8 bytes, 64 bits.
        double bigDecimal = 35600.49; // 8 bytes, 64 bits.

        /* USOS
         * int e long: para números inteiros
         * float e double: para decimais.
         * O valor de char pode ser baseado na tabela ASCII, onde um número
         * designa um caractere, mas também pode-se usar um valor Unicode, com
         * contrabarra e u seguidos do número correspondente a cada caractere,
         * sempre entre aspas simples.
        */
        char test = '\u0049';
        System.out.println(test);
        
        /* CASTING
        * É possível indicar o tipo primitivo ao qual um dado pertence pondo
        * a inicial do tipo imediatamente após o valor, para evitar uma
        * interpretação errada pelo compilador, pois existem tipos associados
        * por padrão aos dados de acordo com o modo como são escritos.
        * E existe também um modo de "forçar" o compilador a associar um dado
        * a um tipo mesmo que o valor possa pertencer a outro tipo: trata-se
        * do chamado "casting". Segue um exemplo onde usam-se ambos os
        * recursos mencionados acima: um dado "salario" é declarado como um
        * inteiro, mas o valor é escrito como um double e forçosamente
        * interpretado como int pelo casting, de modo que o compilador
        * desconsidera a parte decimal declarada.
        */

        int salario = (int) 2783.57D;
        System.out.println(salario);

        /* Portanto, para realizar um casting, basta colocar o tipo desejado
         * entre parênteses e antes do valor (ou objeto, como se verá depois).
         * 
         * STRING
         * Não é de tipo primitivo, mas uma classe, que aceita um valor
         * textual, assim como valores ASCII, Unicode e UTF.
         */
         String MsgUnicode = "\u0055\u006E\u0069\u0063\u006F\u0064\u0065";
        System.out.println(MsgUnicode);

        /* Exercício: criar variáveis para os campos entre < > e imprimir
         * a mensagem:
         * Eu, <nome>, morando no endereço <endereço>, confirmo que recebi
         * o salário de R$ <salário>, na data <data>.
        */
        String nome = "Imortal Pereira Silva";
        String endereço = "Rua 30 de Fevereiro, número 01, Bairro Utopia";
        float salary = 3567.89F;
        String data = "30 de agosto de 2025";
        System.out.println(
            "Eu, " + nome +
            ", morando no endereço "+ endereço +
            ", confirmo que recebi o salário de R$ "+ salary +
            ", na data "+ data +".");
        /* DICA: William criou uma String para a mensagem, ao invés de
         * colocar a mensagem no print:
         * String relatorio = "Eu...";
         * System.out.println(relatorio);
         * Isso pode ser melhor, se a mensagem puder ou precisar ser
         * utilizada novamente, ou simplesmente para melhorar a leitura.
        */
    }
}
