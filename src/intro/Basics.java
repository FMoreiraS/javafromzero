package intro;

public class Basics {
    /* Convenção: para nomear classes, usa-se sempre
     * iniciais maiúsculas, e nunca se inicia com números.
     */
    public static void main(String[] args) {
        System.out.println("Fizeste o print!");
    }

}
// Os comentários podem ser feitos com //, como neste, com "/* */", para múltiplas linhas
// de comentário, e ainda no formato javadoc, utilizando /**...*/, para que apareça.

/* COMO FAZER PACOTES (SOURCES) DE CÓDIGO:
 * A convenção é criar o pacote com o nome do site invertido, se composto, com ponto
 * entre os elementos, seguido do nome do projeto e do da classe:
 * site.nome.projeto;
 * Não se utiliza traço (-) nesses nomes, por consenso.
 * É obrigatório que uma classe dentro de um pacote tenha o código iniciado pela
 * linha com o nome do pacote (package ...); vale lembrar que comentários não contam
 * como linha para execução, então podem vir antes dessa "linha identitária".
*/