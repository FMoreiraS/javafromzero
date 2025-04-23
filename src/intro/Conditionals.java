package intro;

public class Conditionals {
    public static void main(String[] args) {
        /* O valor posto dentro do if deve ser sempre um booleano, e if só é executado
         * quando a condição é verdadeira.
         * If exige uso de chaves quando possui mais de uma linha de comando, mas o for, mesmo
         * feito em várias linhas, conta como apenas uma linha de execução, dispensando isso.
        */
        if (true) {
            System.out.println("Condição verdadeira executada.");
        }
        if (false) {
            System.out.println("Não executado");
        }
        /* Criam-se estruturas condicionais comumente de duas formas:
         * 1. com o valor de uma var. dentro dos parenteses do if;
         * 2. com uma var. boolean.
        */
        int age = 18;
        if (age >= 18) {
            System.out.println("Cliente autorizado a comprar bebidas alcoólicas.");
        }
        int age2 = 20;
        boolean isAuthorizedAlcholicDrink = age2 >= 20;
        if (isAuthorizedAlcholicDrink) {
            System.out.println("Cliente autorizado.");
        }
        /* Caso se deseje executar uma instrução a partir do valor falso de um boolean, pode-se usar
         * o operador de negação (!) ou o op. relacional de igualdade (==) mais false.
        */
        int age3 = 16;
        boolean isClientAuthorized = age3 >= 20;
        if (!isClientAuthorized) {
            System.out.println("Cliente não autorizado.");
            // Semelhante a: if (isClientAuthorized == false)...
        }
        /* OBS. IMPORTANTE:
         * Se for usado um boolean dentro do if com valor atribuído verdadeiro, sempre haverá execução,
         * por uma atualização do valor em memória. Mas se true for RELACIONADO à var. dentro do if,
         * prevalece o último valor ATRIBUÍDO.
        */
        boolean erro = true;
        if (erro = false) {
            System.out.println("Jamais cometa esse erro!");
        }
        //Sabemos que false nunca é executado.
        boolean donkeyness = false;
        if (donkeyness = true) {
            System.out.println("Não faça isso!");
        }
        // Por outro lado, a relação não altera a variável.
        boolean maniaDeCertificação = true;
        if (maniaDeCertificação == false) {
            System.out.println("Não é erro na Lua!");
        }
        /* ELSE ("SENÃO")
         * Funciona EXCLUSIVAMENTE com o if, criando um comando caso a condição não seja atendida.
         * Else evita que se use comando independente como se faz com "!" e "== false".
        */
        int pcCost = 2400;
        int savings = 0;
        boolean canIBuyAPc = savings >= pcCost;
        if (canIBuyAPc) {
            System.out.println("You can buy a pc!");
        } else {
            System.out.println("You can't buy a pc!");
        }
        /* Como o boolean é falso, a condição não é atendida, o compilador despreza o comando
         * ligado ao if e executa o ligado ao else. Caso haja mais de duas possibilidades,
         * else não funcionará: usa-se "else if".
         *
         * Idade < 12 = criança;
         * idade >= 12 && < 18 = jovem;
         * idade > 18 = adulto;
        */
        int anyAge = 18;
        if (anyAge < 12) {
            System.out.println("Eu sou criança.");
        } else if (anyAge >= 12 && anyAge < 18) {
            System.out.println("Sou jovem.");
        } else {
            System.out.println("Sou adulto.");
        }
        /* O compilador avalia a var. declarada e executa o comando que se adequa ao valor dela
         * (ignorando o resto, se o valor é abrangido antes da última condição), mas se as condições
         * não abrangem esse valor, nada se faz com este.
        */
        int age0 = 100;
        if (age0 < 12) {
            System.out.println("Eu sou criança.");
        } else if (age0 >= 12 && age0 < 18) {
            System.out.println("Sou jovem.");
        } else if (age0 > 18 && age0 < 50) {
            System.out.println("Sou adulto.");
        }
        // Aqui nada há a fazer com a var. age0, pois não está nas condições.
        // Também poder-se-ia usar a condicional para determinar o valor de uma var. string. Ex.:
        int athleteAge = 16;
        String categoria;
        if (athleteAge < 12) {
            categoria = "infantil";
        } else if (athleteAge >= 12 && athleteAge < 18) {
            categoria = "juvenil";
        } else {
            categoria = "adulta";
        }
        System.out.println("A categoria do atleta é a " + categoria + ".");

        /* ESCOPO:
         * Escopo é uma qualidade das variáveis de um bloco de código. As vars. dentro de um bloco
         * de método possuem escopo local. Por regra, vars. de escopo local devem ser inicializadas
         * antes de serem executadas. Ou seja, precisam ser trabalhadas (receber valor) antes da
         * execução, ou haverá erro de compilação.
        */
        int ageTest = 100;
        String categoriaTeste;
        if (ageTest < 12) {
            categoriaTeste = "infantil";
        } else if (athleteAge >= 12 && athleteAge < 18) {
            categoriaTeste = "juvenil";
        }
        /* Se não existir "} else {
         * categoriaTeste = "adulta";",
         * a var. fica sem valor definido, pois depende da estrutura e esta não cobre o int que
         * daria o valor da string.
         * "System.out.println (categoriaTeste)" não pode ser executado, e o comp. responde textualmente:
         * "The local variable categoriaTeste may not have been initialized".
         * Se, porém, a var. for inicializada com valor vazio "", não haverá erro, permanacerá para o Java
         * a informação: variável = "". Caso seja printada, nada aparecerá, a não ser que haja um
         * valor, mesmo que não seja compreendido por estrutura condicional.
         *
         * OPERADOR TERNÁRIO:
         * Também pode ser usado para criação de estrutura condicionais, mesmo com várias condições,
         * pois pode ser escrito em cadeia. Escreve-se assim:
         * variável = condição ? verdadeiro : falso
         * Compreende-se: se a variável da condição for verdadeira, ocorre uma coisa, se falsa,
         * ocorre outra.
        */
        float salary = 3000F;
        String msgGoodIncome = "Posso sustentar a família.";
        String msgLowIncome = "Preciso ganhar mais.";
        String situation = salary >= 5000 ? msgGoodIncome : msgLowIncome;
        System.out.println(situation);
        /* Poderíamos também por a msg dentro do op., mas não é recomendado enquanto mensagens grandes
         * aumentam demais a linha. Se houvessem mais condições, bastaria continuar com ? até a
         * penúltima possibilidade:
         * var xyz = cond ? true ? true : false.
         * Isso substituiria o uso de else if, mas a linha fica longa demais: é desaconselhável
         *
         * EXERCÍCIO:
         * Determinar quanto imposto dever ser pago, dado um certo salário anual,
         * com base nos dados de 2020 dos Países Baixos:
         * • € 0      — 34,712 =  9,70%
         * • € 34,713 — 68,507 = 37,35%
         * • € 68,508 — ...    = 49,50%
         */
        float annualIncome = 36000F;
        float tax;
        if (annualIncome >= 0 || annualIncome <= 34712) {
            tax = annualIncome * 0.097F;
        } else if (annualIncome >= 34713 || annualIncome <= 68507) {
            tax = annualIncome * 0.3735F;
        } else {
            tax = annualIncome * 0.495F;
        }
        /* Obs.: Não é interessante usar o operador || em situações como essas, pois o valor pode ser <=
         * ao maior mencionado, mas também menor que o menor da faixa: criou-se uma "brecha lógica", pois
         * se o valor da renda entrasse na 1a faixa, seria também da 2a, pois usando "ou" basta que uma das
         * proposições seja verdadeira.
         */
        System.out.println("Recebendo anualmente " + annualIncome + " euros, deves pagar ao governo dos Países Baixos meros " + tax + "!");
        // Vale deixar a solução do prof. William
        double salarioAnual = 70000;
        double primeiraFaixa = 9.70 / 100;
        double segundaFaixa = 37.35 / 100;
        double terceiraFaixa = 49.50 / 100;
        double valorImposto;
        if (salarioAnual <= 34712) {
            valorImposto = salarioAnual * primeiraFaixa;
        } else if (salarioAnual >= 34713 && salarioAnual <= 68507) {
            valorImposto = salarioAnual * segundaFaixa;
        } else {
            valorImposto = salarioAnual * terceiraFaixa;
            System.out.println("O valor do imposto é de " + valorImposto + " euros!");
        }
        /* SWITCH
         * É uma funcionalidade útil para condicionais simples, que torna o código mais limpo
         * do que uma estrutura com if, else if. "switch" é palavra reservada; outra restrição:
         * só se aceitam vars. dos tipos BYTE, CHAR, INT, SHORT, ENUM e STRING.
         * Controi-se a estrutura com switch seguida de (var. de entrada), com "cases" abaixo,
         * seguidos de "condição" e ":"; é executado o caso onde estiver o valor de entrada e
         * todos os seguintes; para evitar isso, usa-se "break" abaixo dos casos; se o valor não
         * for compreendido pela estrutura, nada será feito: pode-se usar "default" para designar
         * uma resposta padrão, em qualquer posição na estrutura.
         * Obs.: Pode-se usar blocos na estrutura, após o case: não interfere no resultado.
         * Exemplo: Imprimir dia da semana de acordo com o número de entrada, sendo domingo 1.
         */
        byte dayWeek = 7;
        switch (dayWeek) {
            case 1:
                System.out.println("Dom");
                break;
            case 2:
                System.out.println("Seg");
                break;
            case 3:
                System.out.println("Ter");
                break;
            case 4:
                System.out.println("Qua");
                break;
            case 5:
                System.out.println("Qui");
                break;
            case 6:
                System.out.println("Sex");
                break;
            case 7:
                System.out.println("Sab");
                break;
            default:
                System.out.println("Resposta inválida.");
                break;
        }
        // Exercício: Usar switch para determinar se o dia é útil ou final de semana, considerando
        // domingo como 1. Final de semana: sábado e domingo.
        String weekDay = "domingo";
        switch (weekDay) {
            case "domingo":
                System.out.println("Final de semana");
                break;
            case "segunda":
                System.out.println("Dia útil.");
                break;
            case "terça":
                System.out.println("Dia útil.");
                break;
            case "quarta":
                System.out.println("Dia útil.");
                break;
            case "quinta":
                System.out.println("Dia útil.");
                break;
            case "sexta":
                System.out.println("Dia útil.");
                break;
            case "sábado":
                System.out.println("Final de semana.");
                break;
            default: {
                System.out.println("Resposta inválida.");
                break;
            }
            // Exemplo do uso de bloco no default.
            // Segue a resolução do prof., que usa a particularidade da sintaxe para reduzir o código.
        }
        byte day = 1;
        switch (day) {
            case 1:
            case 7:
                System.out.println("FDS.");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia útil.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        // O uso desse "atalho" dependerá das circunstancias: certas equipes aceitarão, outras não.
    }
}