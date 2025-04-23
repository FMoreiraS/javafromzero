package core.fstaticmodifier.test;

import core.fstaticmodifier.domain.Book;

public record StaticInitializationBlockTest() {
    public static void main(String[] args) {
    Book book1 = new Book("livro 1");
    Book book2 = new Book("livro 2");
    }
}
