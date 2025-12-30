package intro;

public class Basics {
    // Convenção para nomear classes: usa-se sempre iniciais maiúsculas,
    // nunca se inicia com números. Apesar de não aconselhável, é
    // possível iniciar com os caracteres especiais "$" e "_" (underscore).
    
    public static void main(String[] args) {
        System.out.println("Fizeste o print!");
    }
}
// Os comentários podem ser feitos com "//", para linhas individuais,
// com "/* */", para múltiplas linhas e também no formato javadoc,
// utilizando /** */, para que apareçam como documentação das classes.
 
/* COMO FAZER PACOTES (SOURCES) DE CÓDIGO:
 * A convenção é criar o pacote com o nome do proprietário invertido, se
 * composto, separando com ponto os elementos, seguido do nome do projeto
 * e do da classe:
 * site.nome.projeto;
 * O ponto é usado em Java como separador de pacotes.
 * Não se utiliza traço (-) nesses nomes, por consenso.
 * É obrigatório que uma classe dentro de um pacote tenha o código iniciado
 * pela linha com o nome do pacote (package ...); vale lembrar que
 * comentários não contam como linha para execução, então podem vir antes
 * dessa "linha identitária".
*/