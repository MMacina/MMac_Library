package com.crud.mmac_library;

import com.crud.mmac_library.domainAndDto.book.Book;
import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.copy.CopyStatus;
import com.crud.mmac_library.repository.BookRepository;
import com.crud.mmac_library.repository.CopyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MMacLibraryApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBooksAddCopy() {
        //Given
        Book book = new Book("Book1", "Author1Name", "Author 1 Surname");
        Copy copy1 = new Copy(CopyStatus.AVAILABLE, book);
        Copy copy2 = new Copy(CopyStatus.RENTED, book);
        book.getCopies().add(copy1);
        book.getCopies().add(copy2);

        //When
        bookRepository.save(book);
        Long id = book.getId();

        //Then
        assertEquals(1, bookRepository.count());
    }
}


