# Wrappers
Um wrapper ("invólucro", "empacotador") é em Java uma classe dedicada a
representar, "envolver" um tipo primitivo, para que ele seja usado como uma
classe qualquer, com métodos e atributos. "Atributos" porque, como se verá, os
wrappers podem ter constantes utilitárias, enquanto o valor que seria o primitivo
"empacotado" pelo wrapper é obtido por simples referência (ou por métodos).
Lembre-se que os tipos primitivos são valores simples para representar bits,
enquanto quaisquer outros valores são necessariamente tipos de referência,
objetos.  
**Por que os wrappers seriam úteis?**  
Para evitar o problema de alterar uma variável de tipo primitivo com um método
(cf. IntroToMethods, Parâmetros de tipo primitivo), que *altera uma cópia* da
variável, enquanto parâmetros do tipo de referência permitem *alterar o
objeto mesmo*. As classes wrappers tem nomes pouco diferentes dos nomes dos tipos
primitivos que representam:
````
byte --> Byte
short --> Short
int --> Integer
long --> Long
float --> Float
double --> Double
char --> Character
boolean --> Boolean
````
Lembremos que os tipos primitivos permitem que se use na declaração um valor de
tipo diferente, como um int no lugar de um long. Com as wrappers, tenta usar
valores fora do alcance do tipo primitivo que elas representam causa erro de
compilação. Um Integer, por exemplo, não pode ser um Long e vice-versa, a regra
do polimorfismo é plenamente aplicada: as wrappers numéricas estendem apenas
`Number`. O uso dessas classes exige mais atenção.
> Resumindo: tipos primitivos seguem a regra da quantidade de bytes, wrappers
> seguem a regra do polimorfismo.
````
// Com os primitivos é possível fazer um tipo menor "caber" num maior
long num = 4; // sem "L", é int
// Isso é impossível, o "L" é obrigatório.
Long num2 = 5;
````
O segundo motivo pelo qual criaram-se as classes wrappers, relacionado ao 
primeiro, é necessidade de usar estruturas de dados. Em EDs como List, só é
permitido usar wrappers. Não podemos ter problemas para alterar valores em
EDs, alterando cópias ao invés dos componentes das estruturas.  
Uma consequência, já mencionada, muito útil da transformação dos tipos primitivos
em objetos é a possibilidade de usar métodos próprios à manipulação desses
valores e com outras finalidades, herdados de interfaces como `Comparable` e da
classe `Object`, além de métodos específicos das wrappers.  
Outro motivo da necessidade das wrappers é a obrigatoriedade de usar objetos
ao trabalhar com *threads* (um assunto a tratar adiante).  
Vale notar que, apesar da grande quantidade de memória dos computadores modernos,
é uma boa prática usar wrappers apenas quando absolutamente necessário; nos
demais casos devemos usar tipos primitivos, como fizemos nos tópicos anteriores.
## (Auto)boxing e unboxing
Autoboxing (ou boxing) é a transformação de um tipo primitivo em uma wrapper,
na declaração, pela própria JVM. Unboxing é o inverso: a transformação de um
tipo wrapper num primitivo.  
````
Integer intWrapper = 8; // boxing: p --> w
int intPrimitive = intWrapper; // unboxing: w -> p
// ou: int intPrimitive = Integer.valueOf(9);  
````
## Métodos
Os métodos das classes wrapper permitem 
- transformar strings em tipos numéricos e booleanos `Long.parseLong()`;
- obter os valores máximos e mínimos dos tipos numéricos `Integer.MAX_VALUE`;
- saber se um caractere é número ou letra `Character.isDigit()`,
`Character.isLetter()`;
- transformar uma letra em maiúscula ou minúscula `Character.toUpperCase()` etc.

> Para entender melhor o funcionamento dos métodos das wrappers (e de quaisquer
> classes da linguagem), vale ler a documentação, no site ou nas próprias
> classes.