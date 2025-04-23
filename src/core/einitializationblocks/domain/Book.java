package core.einitializationblocks.domain;

public class Book {
    private String name;
    private int[] chapters;

    {
        System.out.println("No bloco de inicialização.");

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
        System.out.println("\nConstrutor que inicializa name: " + getName() + ", chapters: " + chapters);
    }

    public Book() {
        System.out.println("\nConstrutor sem parâmetros e com inicialização.");
        chapters = new int[50];
        for(int i = 0; i < chapters.length; i++) {
            chapters[i] = i + 1;
        }
        for(int chapter : chapters) {
            System.out.print(chapter + " ");
        }
    }

    public String getName() {
        return this.name;
    }

}