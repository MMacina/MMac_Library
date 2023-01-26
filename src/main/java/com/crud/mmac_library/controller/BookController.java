package com.crud.mmac_library.controller;

import com.crud.mmac_library.domainAndDto.book.Book;
import com.crud.mmac_library.domainAndDto.book.BookDto;
import com.crud.mmac_library.mapper.BookMapper;
import com.crud.mmac_library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library/book", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookController {

    public final BookDbService bookDbService;
    public final BookMapper bookMapper;

    @PostMapping()
    public ResponseEntity<Void> AddBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.addBook(book);
        return ResponseEntity.ok().build();
    }
}