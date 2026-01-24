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

| No. de ops. |    Classe     | Tempo de execução | Ops. por milissegundo |   Ops. por segundo    |
| :---------: | :-----------: | ----------------: | --------------------: | --------------------: |
|             | String        |             23 ms |    4,3478260869565215 |     4347,826086956521 |
|         100 | StringBuilder |              8 ms |                12.500 |            12.500.000 |
|             | StringBuffer  |              2 ms |                50.000 |            50.000.000 |
| ----------- | ------------- | ----------------- | --------------------- | --------------------- |
|             | String        |           4356 ms |   0,02295684113865932 |    22,956841138659318 |
|     100.000 | StringBuilder |              4 ms |                25.000 |            25.000.000 |
|             | StringBuffer  |              3 ms |   33.333,333333333336 |            33.333.000 |

> Observações:
> 1. Onde há "ops.", entenda-se "operações".
> 2. Na coluna "Ops. por segundo", omitem-se os decimais das linhas referentes a
>    StringBuilder e a StringBuffer, para melhor leitura.


<table>
    <th>
        <td>No. de ops.</td>
        <td>Classe</td>
        <td>Tempo de execução</td>
        <td>Ops. por milissegundo</td>
        <td>Ops. por segundo</td>
    </th>
    <tr>
        <td rowspan="3"></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <td rowspan="3"></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>