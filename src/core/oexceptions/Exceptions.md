# Exceptions
Exceções, como tudo em Java, são *objetos*: existem diversas classes
de exceções no pacote "java.lang". Mas antes de tratar de exceções,
vale mencionar os erros. Exceptions e errors estendem Throwable, uma
classe que representa certos eventos geralmente indesejados num sistema.  
Erros são eventos inesperados e irresolúveis em tempo de execução (runtime),
ou seja, são problemas que só podem ser resolvidos parando a execução do
código, o sistema não consegue recuperar-se deles. Exemplos são
OutOfMemoryError e StackOverflowError, que ocorrem por esgotamento da memória
RAM.