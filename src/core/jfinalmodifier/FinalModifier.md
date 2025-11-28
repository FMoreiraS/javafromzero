# Final modifier
## Constantes
Em algum momento é preciso criar propriedades que não devem ser alteradas:
constantes. Para criar constantes em Java, usa-se o moficador `final`, em
qualquer posição antes do tipo da variável. A convenção de nomeação para
constantes é escrever tudo em upper case, separando com "_" partes de nomes
compostos.  
`private final String GIVEN_NAME = "Marco";`  
Usando a palavra *final*, o compilador deixa de aceitar valores padrão para
o dado, ou seja, uma vez declarada a constante, é obrigatório atribuir valor,
na mesma linha da declaração, num bloco de inicialização ou num construtor
(neste último caso não pode ser estática).
Esse valor não poderá ser alterado senão pela reescrita, qualquer tentativa
por meio de métodos causa erro de compilação: o código sequer será executado.