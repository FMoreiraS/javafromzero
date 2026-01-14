# Exceptions
## Throwables e Errors
Como tudo em Java, *exceções são objetos*: existem diversas classes
de exceções no pacote "java.lang". Mas antes de tratar de exceções,
vale mencionar os erros. Exceptions e errors estendem Throwable, uma
classe que representa certos eventos geralmente indesejados num sistema.  
Erros são eventos inesperados e irresolúveis em tempo de execução (runtime),
ou seja, são problemas que só podem ser resolvidos parando a execução do
código, o sistema não consegue recuperar-se deles. Exemplos são
OutOfMemoryError e StackOverflowError, que ocorrem por esgotamento da memória
RAM (v. teste de StackOverflowError).
## Tipos de exceptions
Existem 2 tipos de exceções: **checked** e **unchecked**. Exceções "checadas"
são as estensoras diretas da classe Exception, que são detectadas *em tempo
de compilação* e, portanto, impedem a execução se não forem tratadas. Exceções
"não checadas" são a RuntimeException e suas subclasses, ou seja, todas as
que ocorrem em tempo de execução, causadas quase sempre por desatenção do
programador, quando não são lançadas por intenção dele (pois é possível
determinar o lançamento de exceções). Em suma, exceções checked são as
checadas pelo compilador e exigentes de tratamento e exceções unchecked
são as não checadas pelo compilador e que não exigem tratamento.
### Unchecked
Para tratar exceções, Java oferece certas palavras reservadas, que precisam
de blocos dedicados: **try, catch e finally**. Este último é opcional, e será
explicado depois. Coloca-se dentro do bloco de try todo o código com potencial
de lançamento de exceção e dentro do bloco de catch, o tratamento. A palavra
catch recebe após si um objeto de exceção entre parênteses, como é feito com
métodos: o objeto da exceção é criado pela JVM, este objeto é o "argumento"
do catch. É obrigatório pôr no bloco try um código capaz de lançar a exceção
indicada no catch se ela for do tipo checked.
> [!Tip]
> É considerado uma boa prática visar as exceções mais específicas ao invés
> de pegar exceções genéricas, como a Exception, porque facilita o tratamento.
### Checked
Os métodos podem sinalizar na assinatura a possibilidade de lançarem uma
exceção, com a palavra `throws` seguida do tipo da exceção.  
````
public class File...
    public boolean createNewFile() throws IOException {
    ...
````
Se uma exceção é lançada, qualquer código em linhas que possam existir abaixo
no bloco try são desprezadas, a execução continua no bloco catch e não
retorna ao try, ou seja, as linhas depois da originária da exceção são
perdidas. Quando ocorre uma exceção e não há blocos try e catch no local
de origem, a exceção desce na pilha (stack) até que seja dado um tratamento
ou, caso não exista um, o método main interrompa a execução, se a exceção
for do tipo unchecked.  
> [!Important]
> Sendo contingente a execução do catch, é totalmente desaconselhável pôr
> *lógica de negócio* dentro desse bloco.

Feita a "captura" da exceção, *a execução não será bruscamente interrompida*,
mas continuará como esperado, se possível, depois de feito o tratamento
escolhido. Sabendo que podemos tratar as exceções, **é inaceitável deixar
o bloco catch vazio**, porque o programa continuará mas não haverá qualquer
aviso sobre a ocorrência da exceção. Vale, pelo menos, usar um recurso comum
às exceções: o método `printStackTrace()`.
````
try {
    file.createNewFile();
    System.out.println("Teste de código não executado.");
} catch (IOException e) {
    e.printStackTrace();
}
````
## Lançando exceções
### unchecked
Vale notar que se o lançamento de uma exceção interrompe a execução (ou
direciona para o catch), um método com retorno não pode depender do "return"
contido num try, é preciso ter um retorno fora dos blocos try e catch, pois
este não interromperá a execução.  
Uma forma simples de superar essa obrigação, e de dispensar try e catch,
é determinar precisamente quando uma exceção deve ser lançada.
O meio para isso é a palavra reservada `throw` (não confundir com throws,
que fica apenas nas assinaturas de métodos), seguida de um novo objeto
do tipo de exceção desejado.  
````
private static int divideTwoNumbers(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return num1/num2;
}
````
> [!Important]
> Diferente dos blocos try e catch, throw interrompe a execução, a menos
> que o método que lançou a exceção esteja num bloco try.

### checked
Métodos que podem lançar exceções checadas **devem ter na assinatura a
palavra throws** (cf. `java.io.File.createNewFile()`). Essa indicação
**delega a responsabilidade** ao método que chamou, obrigando apenas este
(ou um outro método chamador e assim sucessivamente) a tratar a exceção com
try e catch.  
Para decidir se é mais apropriado usar try e catch ou throws num método
capaz de lançar exceções checadas, é preciso *avaliar como o método será
usado*. Se o método será usado apenas pela classe onde está, ou seja,
**se é privado, convém usar try e catch**. Mas **se é público, é melhor usar
throws**, pois poderá ser usado por muitas outras classes, e ficará a
liberdade de dar cada uma o tratamento que desejar. É possível também usar
uma solução híbrida, dar um "tratamento parcial", se for conveniente à
circunstância: usar try e catch no método que lança a exceção, fazer no
catch algo como um printStackTrace() e lançar a exceção capturada ou outra,
para que fique a critério de quem chama o método dar (ou não) um tratamento
adequado.  
````
private static void createNewFile(String name) throws IOException{
    File file = new File(name + ".txt");
    
    try {
        file.createNewFile();
        System.out.println("Não ocorreu exceção.");
    } catch (IOException e) {
        e.printStackTrace();
        throw e;
        // O método responsabiliza-se por imprimir a stack trace, mas
        // obriga quem o chamou a dar o tratamento propriamente dito.
    }
}
````
> [!Tip]
> Qualquer que seja a solução escolhida escolhida por arquitetos ou pelo
> time de desenvolvimento, convém manter um padrão em todo o projeto.
## Bloco finally
O bloco finally é um bloco de código complementar aos blocos try e catch,
definido por **ser sempre executado**, acontecendo ou não uma exceção.
Assim, finally pode ser usado para realizar alguma ação padrão em um método,
que não pode depender da ocorrência ou não ocorrência de uma exceção. Se
por exemplo um método faz uso de um recurso do SO, é preciso *abrir* o
uso do recurso antes de usá-lo e sumamente importante *fechar* o recurso,
para não ocupar a memória sustentando-o desnecessariamente.
Note-se que o bloco try não pode ser usado só, mas não exige ser usado
apenas em conjunto com catch: *é possível usar apenas try e finally*, embora
seja incomum. Isso pode ser útil quando o método em construção não tem
obrigação de tratar as possíveis exceções, mas apenas deixar que elas sejam
lançadas a quem o chamou.  
> [!Important]
> O bloco finally fica abaixo dos blocos try e catch (quando este existe),
> mas a sua execução em caso de lançamento de exceção *é sempre anterior à
> exceção*, ou seja, o código dentro do finally será executado e só depois
> a exceção será lançada, ao método imediatamente abaixo ou ao main,
> interrompendo a execução (cf. FinallyTest).

````
private static void createFicticiousFile(String name){        
    try {
        System.out.println("Execução do try");
        System.out.println("Abrindo recurso do SO...");
        if (name.contains("-")) {
            throw new IllegalArgumentException("O nome não pode ter \"-\"");
        } 
        System.out.printf("O arquivo %s.txt foi criado.\n", name);
        System.out.println("Não ocorreu exceção.");
    } catch (RuntimeException e) {
        System.out.println("Execução do catch");
        throw new RuntimeException("A exceção foi lançada.");
    } finally {
        System.out.println("Execução do finally.");
        System.out.println("Fechando recurso...");
    }
}
/* Se ocorrer uma exceção, a saída será:
Execução do try
Execução do catch
Execução do finally.
Exception in thread "main" java.lang.RuntimeException: A exceção foi lançada.
        at core.oexceptions.test.FinallyTest.createFicticiousFile(FinallyTest.java:20)
        at core.oexceptions.test.FinallyTest.main(FinallyTest.java:7)
*/
````
## Tratamento para múltiplas exceções
### Múltiplos blocos catch
É possível tratar mais de uma exceção no mesmo método, **usando diferentes
blocos catch para cada exceção**. Uma vez que as exceções constituem uma
cadeia de herança, *o polimorfismo é aplicável*, permitindo-nos capturar
exceções específicas com tipos mais genéricos. Isso implica que, se
usarmos um catch com um tipo de exceção mais genérico, a JVM não olhará
nos demais blocos catch se existe algum tratando uma exceção de tipo igual
ou mais próximo da que foi lançada, ou seja, **catches com tipos mais
genéricos devem ficar por último**.  
Também podemos indicar nas assinaturas de métodos mais de um tipo de
exceção checada após o *throws*, separando-os com vírgula. Naturalmente,
o método que chamar precisará ter blocos catch para cada exceção
colocada na assinatura (ou para um supertipo comum).
````
private static void throwAnyUncheckedException() {
    try {
        throw new RuntimeException();
    } catch (IllegalArgumentException e) {
        System.out.println("A exceção " + e.getClass() + " foi lançada.");
    } catch (IndexOutOfBoundsException e) {
        System.out.println("A exceção " + e.getClass() + " foi lançada.");
    } catch (RuntimeException e) {
        System.out.println("A exceção " + e.getClass() + " foi lançada.");
    }
}
````
### Catch com n exceções
Outra forma de tratar várias exceções simultaneamente é **colocar várias
exceções no mesmo bloco catch**, separadas por "|" (pipe). Existem duas
importantes restrições:
1. não podem coexistir no mesmo bloco uma exceção e sua subclasse (por exemplo, RuntimeException e OutOfBoundException), por tornar a subclasse inalcançável ou inútil;
2. não é possível reatribuir o valor da variável de exceção (num catch com apenas uma exceção, isso é possível).
````
static void mayThrowException() {
    try {
        int test = 45 / 0;
        System.out.println(test);
    } catch (ArithmeticException | IllegalArgumentException e) {
        System.out.println("Ocorreu uma exceção do tipo " +
                e.getClass().getName());
    } catch (RuntimeException e) {
        System.out.println("Foi lançada uma RuntimeException.");
        // Note-se como é possível reatribuir o valor de "e".
        e = new IndexOutOfBoundsException();
    }
}
````
Naturalmente, só faz sentido usar várias exceções num mesmo catch se for
possível ou necessário dar o mesmo tratamento a todas.
## Try with resources
Existem situações em que o uso de try e catch ou finally gera um código
visualmente desagradável, dificilmente legível, pela necessidade de tratar
exceções dentro dos blocos catch ou finally. No exemplo, um método chamado no
finally obriga o uso de try e catch ali porque pode lançar a IOException.
````
static void testTry() {
    Reader reader = null;
    // É preciso criar aqui para ser acessível no try dentro do finally.
    try {
        reader = new BufferedReader(new FileReader("test.txt"));
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("close() gerou exceção.");
        }
    }
}
````
O try com recursos é uma alternativa própria para situações de uso de recursos
do SO, que fecha automaticamente o recurso usado. Basta colocar entre parênteses
após a palavra "try" os recursos necessários.  
Existem duas particularidades notáveis no uso do try with resources:
1. o recurso **precisa implementar "java.io.Closable" ou "java.lang.AutoClosable"**, pois são as únicas interfaces com o método close().
2. **é possível substituir catch ou finally por "throws"** seguida do tipo da exceção adequada, na assinatura do método.
3. **a ordem de fechamento dos recursos é inversa**, ou seja, são fechados antes os criados por último.
````
static void testTryWithResources() {
    try (Reader reader = new BufferedReader(new FileReader("test.txt"));) {
    } catch (IOException e) {
        e.printStackTrace();
    }
}
````
## Customized exceptions
É possível criar *exceções personalizadas* ao projeto em que se está trabalhando,
apenas *estendendo* exceções existentes, caso não exista uma adequada entre as
oferecidas pela linguagem (são mais de 400, vale ler a documentação). Confirmada
a necessidade, cria-se uma classe (preferencialmente com nome terminado em
"Exception") que estenda Exception, se for uma exceção checada, ou
RuntimeException, se for não checada, ou uma subclasse de qualquer uma delas
(o que dificilmente seria necessário).
````
package core.oexceptions.domain;

public class UserRegistrationException extends Exception {

    public UserRegistrationException() {
        super("O nome de usuário ou a senha é inválida.");
        // O construtor padrão pode ter uma mensagem genérica
    }

    public UserRegistrationException(String message) {
        super(message);
    }

}
````
Para vê-la em ação, executa CustomizedExceptionTest.