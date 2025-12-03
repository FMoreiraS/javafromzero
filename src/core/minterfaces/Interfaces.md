# Interfaces
Interfaces são similares a classes abstratas, mas têm recursos próprios.
Assim como as classes abstratas, não podem ter `final`, porque é contraditório,
elas precisam ser **implementadas**. Por isso, ao invés de *extends*, usa-se
`implements` para indicar que uma classe implementa uma interface.  
Os métodos das interfaces só podiam ser abstratos, até Java 7, mas a partir
da Java 8 podem ser também concretos. Os **métodos de interfaces são por padrão
públicos e abstratos**, então os modificadores esses dois modificadores são
desnecessários (um IDE pode alertar que são *redundantes*).  
Para criar uma interface, não se usa class, mas `interface`, com o modificador
*public* ou com o *abstract*: `public interface DataLoader`