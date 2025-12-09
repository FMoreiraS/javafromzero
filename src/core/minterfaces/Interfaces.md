# Interfaces
Interfaces são similares a classes abstratas, mas têm recursos próprios.
Assim como as classes abstratas, não podem ter `final`, porque é contraditório,
elas precisam ser **implementadas**. Por isso, ao invés de *extends*, usa-se
`implements` para indicar que uma classe implementa uma interface.  
Os métodos das interfaces só podiam ser abstratos, até Java 7, mas a partir
da Java 8 podem ser também concretos. Os **métodos de interfaces são por padrão
públicos e abstratos**, esses dois modificadores são desnecessários (um IDE
pode alertar que são *redundantes*).  
Para criar uma interface, não se usa class, mas `interface`, com o
modificador *public* ou com o *abstract*:  
`public interface Developer {...}`  
## Implementações múltiplas
Uma das principais diferenças entre classes abstratas e interfaces é a
possibilidade de *implementar várias interfaces com uma só classe*. Com
isso, não é necessário ter herança múltipla, apenas implementar quantas
interfaces a situação exigir. Como exemplo, podemos usar o smartphone,
que aglutina funções antes desempenhadas apenas por dispositivos dedicados.
````
// O smartphone pode ser a câmera fotográfica, o telefone e o mp3!
public interface Camera {
    void takePicture();
    void recordVideo();
}
...
public interface Telephone {
    void makeCall(String phoneNumber);
    void answerCall();
}
...
public interface AudioPlayer {
    void play(String filename);
    void stop();
    }
...
public class Smartphone implements Camera, Telephone, AudioPlayer {
    @Override
    void takePicture() {...}
    
    @Override
    void recordVideo(){...}
    
    @Override
    void makeCall(String phoneNumber){...}
    
    @Override
    void answerCall(){...}
    
    @Override
    void play(String filename){...}
    
    @Override
    void stop(){...}
}
````
Como já dito, métodos abstratos exigem implementação, sobrescrita. Isso
é um problema quando muitas classes implementam uma interface, não apenas
algumas num projeto, mas as inúmeras classes dos projetos ao redor do
mundo. Para não inserir problemas de compatibilidade, obrigando os usuários
da linguagem implementar métodos novos das classes nucleares (como em
java.util), Java 8 recebeu os **métodos default**, ou seja, métodos
concretos em interfaces. Esses métodos são, então, iguais aos métodos
concretos de classes abstratas: não exigem implementação e podem ser
sobrescritos.  
Voltando ao exemplo, podemos deixar `Smartphone` com apenas uma
sobrescrita, para o fim didático. Todos os métodos terão corpo, exceto
`Telephone.answerCall()` (cf. o teste).
````
public class Smartphone implements Camera, Telephone, AudioPlayer{

    @Override
    public void answerCall() {
        System.out.println("Deseja atender a ligação?(S/N)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            System.out.println("Chamada atendida.");
        }
        System.out.println("Chamada recusada");
    }
}
````