package com.crud.mmac_library.service;

import com.crud.mmac_library.domain.book.Book;
import com.crud.mmac_library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public void addBook(final Book book) {
        bookRepository.save(book);
    }

    public Book findBookByTitle(final String title) {
        return bookRepository.findByBookTitle(title);
    }
}
