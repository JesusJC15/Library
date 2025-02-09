package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

public class LibraryTest {

    private Library library;
    
    @BeforeEach
    public void setUp() {
        library = new Library();
    }
    
    @Test
    public void shouldAddBook() {
        Book elPrincipito = new Book("El Principito", "Antoine de Saint-Exupéry", "9788467037769");
        assertTrue(library.addBook(elPrincipito));
    }

    @Test
    public void shouldIncreaseTheAmountOfBooks() {
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        assertTrue(library.addBook(harryPotter1));
        assertTrue(library.addBook(harryPotter1));
    }

    @Test
    public void shouldNotAddNullBook() {
        Book nullBook = null;
        assertFalse(library.addBook(nullBook));
    }

    @Test
    public void shouldNotDuplicateBooksSameISBN() {
        Book orgulloYPrejuicio = new Book("Orgullo y prejuicio", "Jane Austen", "9788497940933");
        Book prideAndPrejuice = new Book("Orgullo y prejuicio", "Jane Austen", "9788497940933");

        assertTrue(library.addBook(orgulloYPrejuicio));
        assertTrue(library.addBook(prideAndPrejuice));
    }

    @Test
    public void shouldLoanBookToRegisteredUser(){
        Book elPrincipito = new Book("El principito", "Antoine de Saint-Exupéry", "9788467037769");
        User natalia = new User();
        natalia.setId("1000097158");
        natalia.setName("Natalia");

        library.addBook(elPrincipito);
        library.addUser(natalia);

        Loan loan = library.loanABook("1000097158", "9788467037769");
        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    @Test
    public void shouldNotLoanBookWithoutCopies() {
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        library.addBook(harryPotter1);
        User natalia = new User();
        natalia.setId("1000097158");
        natalia.setName("Natalia");
        library.addUser(natalia);
        
        library.loanABook("1000097158", "9788497940933");
        Loan secondLoan = library.loanABook("1000097158", "9788497940933");
        assertNull(secondLoan);
    }

    @Test
    public void shouldNotLoanBookToUnregisteredUser() {
        Book prideAndPrejuice = new Book("Orgullo y prejuicio", "Jane Austen", "9788497940933");
        library.addBook(prideAndPrejuice);

        Loan loan = library.loanABook("0000000000000", "9788497940933");
        assertNull(loan);
    }

    @Test
    public void shouldLoanMultipleCopiesToDifferentUsers() {
        Book elPrincipito = new Book("El principito", "Antoine de Saint-Exupéry", "9788467037769");
        User natalia = new User();
        natalia.setId("1000097158");
        natalia.setName("Natalia");

        User jesus = new User();
        jesus.setId("1000092885");
        jesus.setName("Jesus");

        library.addUser(natalia);
        library.addUser(jesus);
        library.addBook(elPrincipito);
        library.addBook(elPrincipito); // Agregamos una segunda copia

        Loan loan1 = library.loanABook("1000097158", "9788467037769");
        Loan loan2 = library.loanABook("1000092885", "9788467037769");

        assertNotNull(loan1);
        assertNotNull(loan2);
        assertEquals(LoanStatus.ACTIVE, loan1.getStatus());
        assertEquals(LoanStatus.ACTIVE, loan2.getStatus());
    }

}
