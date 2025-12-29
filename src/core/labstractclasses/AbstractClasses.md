# Classes abstratas
## Conceito
Classes abstratas são classes que **não podem ser instanciadas**, com a
finalidade de serem estendidas. Isso serve para usar herança com maior
controle, pois permite criar gêneros de entes, como veículo, obrigando uma
especificação (dizer apenas "veículo" é vago, por que não dizer "carro",
"avião"?). Se a classe é o modelo para os objetos (cf. introclasses), a
classe abstrata é o modelo para outras classes, nunca para objetos dela
(relembre-se herança).  
Para criar uma classe abstrata, basta usar `abstract` antes de "class" (pode ser antes do modificador de acesso, mas é comum depois).  
`public abstract class Employee {...}`  
## Métodos abstratos
Quando cada subclasse precisa de uma implementação particular para um método
herdado, não faz sentido dar corpo a ele na superclasse. Por isso existem os
**métodos abstratos**, métodos sem corpo, com a finalidade de serem
implementados por toda classe que estenda a superclasse onde ele está.  
Para criar um método abstrato, coloca-se `abstract` em qualquer lugar antes
da indicação de retorno:
`protected abstract void calculateSalaryBonus();`  
> [!IMPORTANT]
> Métodos abstratos só podem ser criados em classes abstratas, mas classes
> abstratas podem ter tanto métodos abstratos quanto concretos (com corpo).
> Além disso, os métodos abstratos devem obrigatoriamente ser implementados,
> mas isso não implica que o corpo deles nas subclasses tenha conteúdo.

Portanto, a classe abstrata funciona como um "contrato" que impõe regras
para a criação de toda classe que a estenda.
### Regra de implementação
Existe um caso em que a implementação de um método abstrato é *opcional*.
Se uma classe abstrata estende outra classe abstrata que possui um método
abstrato, a subclasse pode ou não sobrescrever esse método, mas, por padrão,
o compilador acusa erro apenas nas classes que estendam a subclasse abstrata.
Se a implementação do método for feita na subclasse abstrata, nenhuma outra
implementação é obrigatória. Ex.: se a classe Employee estendesse a classe
abstrata Person e esta tivesse o método abstrato `showInfo()`, a implementação
deveria ser feita em cada "filha" de Employee, ou apenas em Employee.