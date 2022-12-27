package com.crud.mmac_library.mapper;

import com.crud.mmac_library.domain.book.Book;
import com.crud.mmac_library.domain.book.BookDto;

public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getBookTitle(),
                bookDto.getAuthorsName(),
                bookDto.getAuthorsSurname(),
                bookDto.getPublicised(),
                bookDto.getCopies()
                );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getBookTitle(),
                book.getAuthorsName(),
                book.getAuthorsSurname(),
                book.getPublicised(),
                book.getCopies());
    }
}
