# Datas
## Classe Date
É a primeira classe criada para trabalhar com datas em Java, presente desde a
versão 1.0. Muitos métodos já estão obsoletos e, assim como a classe, seu uso é
desaconselhado. A classe Date trabalha com valores em **milissegundos**, contados
a partir de 1 de janeiro de 1970 (a "data zero" de vários sistemas, como os
bancos de dados). Os milissegundos são armazenados como um `long` (são valores
muito extensos), mas a referência ao objeto tipo Date retorna por padrão o
**valor dos milissegundos convertido em data**, o valor em milissegundos é
obtido com o método `getTime()`.
## Classe Calendar
Foi criada como alternativa para superar as limitações da classe Date, mas também
é insuficiente para os sistemas modernos. Assim como Date, está no pacote
`java.util`. Difere por ser uma **classe abstrata**, então só é possível usá-la
por uma das subclasses ou com o método Calendar.getInstance(), que pega o
calendário usado pela JVM no contexto específico (o mesmo do SO).  
Os calendários disponíveis (subclasses) são o gregoriano, o budista e o imperial
japonês, e a classe possui várias constantes, como os dias da semana e os meses,
além de valores relativos como `DAY_OF_WEEK` e `DAY_OF_YEAR`.  
É válido conhecer Date e Calendar para eventuais contatos com sistemas legados,
mas não são recomendadas para o desenvolvimento de novos sistemas.

## Classe DateFormat

DateFormat é uma classe abstrata para formatar tempo e data de forma independente
de idiomas. A classe oferece vários métodos para obter formatadores baseados no
padrão do SO ou de um Locale fornecido, e também constantes que representam
padrões de formatação. Usando as classes Calendar e DateFormat, podemos, por
exemplo, definir como a data e o tempo corrente devem ser exibidos.
```java
    formatters[0] = DateFormat.getInstance();
    formatters[1] = DateFormat.getDateInstance();
    formatters[2] = DateFormat.getDateTimeInstance();
    formatters[3] = DateFormat.getDateInstance(DateFormat.SHORT);
    formatters[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
    formatters[5] = DateFormat.getDateInstance(DateFormat.LONG);
    formatters[6] = DateFormat.getDateInstance(DateFormat.FULL);
```

## Classes