package com.crud.mmac_library.mapper;

import com.crud.mmac_library.domainAndDto.book.Book;
import com.crud.mmac_library.domainAndDto.book.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getBookTitle(),
                bookDto.getAuthorsName(),
                bookDto.getAuthorsSurname()
                );
    }
}
