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
## Exceptions
Existem 2 tipos de exceções: **checked** e **unchecked**. Exceções "checadas"
são as estensoras diretas da classe Exception, que são detectadas *em tempo
de compilação* e, portanto, impedem a execução se não forem tratadas. Exceções
"não checadas" são a RuntimeException e suas subclasses, ou seja, todas as
que ocorrem em tempo de execução, causadas quase sempre por desatenção do
programador, quando não são lançadas por intenção dele (pois é possível
determinar o lançamento de exceções). Em suma, exceções checked são as
checadas pelo compilador e exigentes de tratamento e exceções unchecked
são as não checadas pelo compilador e que não exigem tratamento.
### Unchecked exceptions
Para tratar exceções, Java oferece certas palavras reservadas, que precisam
de blocos dedicados: **try, catch e finally**. Este último é opcional, e será
explicado depois. Coloca-se dentro do bloco de try todo o código com potencial
de lançamento de exceção e dentro do bloco de catch, o tratamento. A palavra
catch recebe após si um objeto de exceção entre parênteses, como é feito com
métodos. É obrigatório pôr no bloco try um código capaz de lançar a exceção
indicada no catch se ela for do tipo checked.
> [!Tip]
> É considerado uma boa prática visar as exceções mais específicas ao invés
> de pegar exceções genéricas, como a Exception, porque facilita o tratamento.

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
de origem, a execução desce na pilha (stack) até que seja dado um tratamento
ou, caso não exista um, o método main interrompa a execução com a exceção, se
esta for do tipo unchecked.  
> [!Important]
> Sendo contingente a execução do catch, é totalmente desaconselhável pôr
> *lógica de negócio* dentro desse bloco.

Feita a "captura" da exceção, *a execução não será bruscamente interrompida*,
mas continuará como esperado, se possível, depois de feito o tratamento
escolhido. Sabendo que podemos tratar as exceções, **é inaceitável deixar
o bloco catch vazio**, porque o programa continuará mas não haverá qualquer
aviso sobre a ocorrência da exceção. Vale, pelo menos, usar um recurso comum
às exceções: o `printStackTrace()`.
````
try {
    file.createNewFile();
    System.out.println("Teste de código não executado.");
} catch (IOException e) {
    e.printStackTrace();
}
````
## Lançando exceções
Vale notar que se os blocos try e catch estão num método com retorno e a
declaração de retorno (o "return") está dentro do try, a ocorrência de
uma exceção anulará essa declaração. Logo, é preciso ter um retorno fora
desses blocos, já que catch não interromperá a execução.  
Uma forma simples de superar essa obrigação, e de dispensar try e catch,
é determinar precisamente quando uma exceção deve ser lançada.
O meio para isso é a palavra reservada `throw` (não confundir com throws,
que fica apenas nas assinaturas de métodos).
> [!Important]
> Diferente dos blocos try e catch, throw interrompe a execução, a menos
> que o método que lançou a exceção esteja num bloco try.

