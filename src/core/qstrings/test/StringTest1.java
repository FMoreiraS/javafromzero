package core.qstrings.test;

public class StringTest1 {
    public static void main(String[] args) {
        String name1 = "Maximus";
        String name2 = "Maximus";
        System.out.println(name1 == name2); // true

        name1.concat(" Augustus");
        // Concat cria o argumento e o retorno, duas strings inacessíveis!
        System.out.println(name1); // Apenas "Maximus"
        // Para mudar o valor referenciado por name1, é preciso atribuir o novo
        // valor a essa variável de referência, mas o valor original não será 
        // alterado.
        name1 = name1.concat(" Augustus");
        System.out.println(name1); // Agora é "Maximus Augustus"

        String name3 = new String("Maximus");
        System.out.println(name2 == name3.intern()); // intern() funciona como get
        // Assim comparamos os valores de strings de dentro e de fora do pool
    }

}
