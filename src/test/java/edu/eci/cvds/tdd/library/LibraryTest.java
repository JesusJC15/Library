package edu.eci.cvds.tdd.library;

import java.time.LocalDateTime;

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
    public void shouldReturnLoan(){
        User user = new User();
        user.setName("Jesus");
        user.setId("1000092885");
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        library.addBook(harryPotter1);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), harryPotter1.getIsbn());

        assertNotNull(loan);
        Loan returnLoan = library.returnLoan(loan);
        assertNotNull(returnLoan);
        assertEquals(LoanStatus.RETURNED, returnLoan.getStatus());
        assertNotNull(returnLoan.getReturnDate());
    }

    @Test
    public void shouldIncreaseBooksAmountWhenReturnLoan(){
        User user = new User();
        user.setName("Jesus");
        user.setId("1000092885");
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        library.addBook(harryPotter1);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), harryPotter1.getIsbn());

        int initialAmount = 1;
        library.returnLoan(loan);
        int updatedAmount = library.loanABook(user.getId(), harryPotter1.getIsbn()) == null ? initialAmount : initialAmount + 1;
        assertEquals(initialAmount + 1, updatedAmount);
    }

    @Test
    public void shouldNotReturnUnexistentLoan(){
        User user = new User();
        user.setName("Jesus");
        user.setId("1000092885");
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        library.addBook(harryPotter1);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), harryPotter1.getIsbn());

        Loan notLoan = new Loan();
        assertNull(library.returnLoan(notLoan));
    }

    @Test
    public void shouldNotChangeStateOfLoanReturned(){
        User user = new User();
        user.setName("Jesus");
        user.setId("1000092885");
        Book harryPotter1 = new Book("Harry Potter y la piedra filosofal", "JK Rowling", "9788497940933");
        library.addBook(harryPotter1);
        library.addUser(user);
        Loan loan = library.loanABook(user.getId(), harryPotter1.getIsbn());

        library.returnLoan(loan);
        LocalDateTime originalReturnDate = loan.getReturnDate();

        Loan returnedLoan = library.returnLoan(loan);
        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertEquals(originalReturnDate, returnedLoan.getReturnDate());
    }

}
