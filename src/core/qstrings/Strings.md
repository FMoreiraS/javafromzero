# Strings
## Natureza imutável das strings
Strings, como sabemos, são classes dedicadas a guardar valores literais, sem a
restrição de tamanho do tipo primitivo char. As strings são criadas em Java
numa região da heap ("monte", "pilha") chamada "string constant pool" ("tanque/
piscina constante de strings). A declaração típica de strings,
`String name = "Alexander";`, cria um valor nesse "tanque" de memória. Essas
**strings são imutáveis**, não podem ser redeclaradas.  
Façamos algumas constatações práticas.
1. Declarar várias strings como o mesmo valor e compará-las com `==`[^1]
    retorna-nos valor lógico **verdadeiro**, porque **não são criadas strings
    idênticas**[^2].
2. Em consequência dessa imutabilidade, usar um método que alterasse o valor de
   uma string, como `concat()`, usando uma string já declarada mas sem fazer
   uma declaração, ocasionaria a **criação de uma string sem variável de
   referência**.
3. Usar o construtor da classe String[^3] **cria objetos fora do pool de strings**,
    causando distinção entre strings com valores idênticos.

[^1]: Usar `equals()` compara o conteúdo, `==` verifica se as strings
    referenciam o mesmo valor, por isso o operador é incomum com strings.
[^2]: Segue o conceito de ciência da computação chamado "string interning".
[^3]: É incomum, e a manutenção do pool desencoraja isso.

````java
String name1 = "Maximus";
String name2 = "Maximus";
System.out.println(name1 == name2); // true

name1.concat(" Augustus");
// Cria " Augustus" e "Maximus Augustus", duas strings inacessíveis!
System.out.println(name1); // Apenas "Maximus"
// Para mudar o valor referenciado por name1, é preciso atribuir o novo valor
// a essa variável de referência, mas o valor original não será alterado.
name1 = name1.concat(" Augustus");
System.out.println(name1); // Agora é "Maximus Augustus"

String name3 = new String("Maximus");
System.out.println(name2 == name3.intern()); // intern() funciona como get
// Assim comparamos os valores de strings de dentro e de fora do pool
````
## Métodos notáveis
Existem muitos métodos úteis na classe String, podemos citar alguns frequentes.
- length: retorna o tamanho do objeto string, o número de caracteres, similar
    atributo length dos arrays;
- charAt: retorna o caractere no índice passado como parâmetro;
- replace: substitui na string todas as ocorrências da primeira sequência de
    caracteres pela segunda;
- substring: retorna uma subdivisão duma string, indo do primeiro índice
    até antes do segundo, ou até o final, se houver só um argumento.
- toUpperCase e toLowerCase: transformam todos as letras presentes em maiúsculas
    e minúsculas, respectivamente.
- trim: retorna uma string sem espaços em branco que existam no início e no fim
    (útil para controlar as respostas do usuário que vão para o banco de dados,
    como toUpperCase e toLowerCase).
## Desempenho com strings
Os objetos da classe String são a representação do texto do mundo real para o
domínio computacional (é a justificativa para toda a orientação a objetos).
Usamos strings para todas as informações literais necessárias aos objetos que
criamos. Contudo, a classe String pode deixar as respostas do sistema lentas em
certas situações.  
Suponhamos que um certo método de um sistema qualquer precise fazer muitas
operações de alteração de objetos strings (não os valores em si, imutáveis).
Podemos calcular o tempo de execução desse método, e comparar o tempo gasto de
acordo com o número de repetições da mesma tarefa (v. StringPerformanceTest).
````java
static void concatString(int length) {
    String generatedString = "";
    for (int i = 0; i < length; i++) {
        generatedString += i;
        // Adiciona o número ao fim da string a cada iteração.
    }
}
````
Com poucas operações, o tempo é de alguns milissegundos (insignificante a nós),
mas aumenta consideravelmente quando são realizadas muitas operações. Isso é um
grande problema para um servidor com muitas demandas. Por isso foram desenvolvidas
duas classes mais eficientes para operações com strings: `StringBuilder` e
`StringBuffer`. Os testes mencionados acima foram realizados como o início de
uma sequência, foram seguidos de testes do mesmo método, mas com a substituição
da classe String por StringBuilder e StringBuffer, respectivamente. Comparemos
todos os resultados.

| No. de ops. |    Classe     | Tempo médio | Ops. por ms | Ops. por segundo |
| :---------: | :-----------: | ----------: | ----------: | ---------------: |
|      10.000 | String        |       37 ms |       308,2 |         308200.6 |
|      10.000 | StringBuilder |      0,5 ms |  Indefinido |       Indefinido |
|      10.000 | StringBuffer  |      0,5 ms |  Indefinido |       Indefinido |
| ----------- | ------------- | ----------- | ----------- | ---------------- |
|     100.000 | String        |   2997,1 ms |        33,4 |          33371,3 |
|     100.000 | StringBuilder |      1,9 ms |      67.000 |       67.000.000 |
|     100.000 | StringBuffer  |        2 ms |     65333,3 |     65.333.333,3 |

> Observações:
> 1. Onde há "ops.", entenda-se "operações".
> 2. Nas colunas de operações por milissegundo e por segundo os valores são
>   arredondados para melhorar a leitura.

Nota-se que o desempenho de StringBuilder e o de StringBuffer são muito
similares. Os métodos são os mesmos, mas StringBuffer foi desenvolvida
especificamente para a *concorrência* (assunto futuro).

## StringBuilder e StringBuffer
### Diferença de instanciação
Podemos criar strings simplemente igualando o objeto a um valor entre aspas
duplas, mas com StringBuilder e StringBuffer é obrigatório usar o construtor,
essas classes não assumem uma sequência entre aspas isolada como valor, e se
não forem passados argumentos para o construtor, este criará um objeto com
capacidade igual a 16 caracteres, mas sem um valor literal. Sendo String e
StringBuilder objetos diferentes, é impossível igualar numa declaração objetos
dessas classes.  
Além disso, foi dito que a classe String cria no String Pool por padrão um novo
valor literal toda vez que o objeto é alterado. StringBuilder e StringBuffer,
ao contrário, criam apenas uma string em memória (não no pool): **sempre que
for alterado o valor, deixa de existir o anterior**. Isso contorna os possíveis
problemas com a imutabilidade das strings.  
````java
String text = "example";
StringBuilder builder = new StringBuilder("value");
````
### Métodos
StringBuilder e StringBuffer têm métodos que fazem quase as mesmas coisas que
se pode fazer com strings. Um método comum, por exemplo, é o `substring()`, que
também só altera os valores se houver uma declaração. É uma exceção, pois os
métodos **retornam objetos StringBuilder/StringBuffer**, assim as declarações
tornam-se desnecessárias, o valor literal é atualizado pela *substituição do
objeto**. Alguns métodos importantes são:
1. append(): equivale a `+=` ou concat(), é o único meio de acrescentar
    caracteres no fim do valor armazenado, e aceita qualquer tipo de dado.
2. insert(): é o que permite adicionar caracteres em uma posição específica do
    valor atual, com o auxílio de um índice como 1º argumento.
3. delete(): permite excluir caracteres no intervalo dado, com *intervalo final
    exclusivo*.