package core.fstaticmodifier.domain;

public class Book {
    private String name;
    private static int[] chapters;

    static {
        System.out.println("Bloco de inicialização estático 1");
    }

    static {
        System.out.println("Bloco de inicialização estático 2");
    }

    {
        System.out.println("\nNo bloco de inicialização não estático.");

        chapters = new int[50];
        for(int i = 0; i < chapters.length; i++) {
            chapters[i] = i + 1;
        }
        for(int chapter : chapters) {
            System.out.print(chapter + " ");
        }
    }

    public Book(String name) {
        this.name = name;
        System.out.println("\nConstrutor que inicializa name: " + getName() + "; capítulos:");
        for(int chapter : chapters) {
            System.out.print(chapter + " ");
        }
    }

    public Book() {
        System.out.println("\nConstrutor sem parâmetros;");
    }

    public String getName() {
        return this.name;
    }
}