package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;

public class LibraryTest {

    private final Library library = new Library();
    private final Book elPrincipito = new Book("El principito", "Antoine de Saint-Exupéry", "9788467037769");
    private final Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
    private final Book orgulloYPrejuicio = new Book("Orgullo y prejuicio", "Jane Austen", "9788497940933");

    private LibraryTest(){
        User jesus = new User();
        jesus.setId("1000092885");
        jesus.setName("Jesus");
        User natalia = new User();
        natalia.setId("1000097158");
        natalia.setName("Natalia");
    }
    
    /**
     * 
     */
    @Test
    public void shouldAddBooks() {
        assertTrue(library.addBook(elPrincipito));
        assertTrue(library.addBook(harryPotter1));
        assertTrue(library.addBook(orgulloYPrejuicio));
    }
}
