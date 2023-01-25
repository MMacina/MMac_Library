package com.crud.mmac_library.controller;

import com.crud.mmac_library.domainAndDto.book.BookDto;
import com.crud.mmac_library.domainAndDto.book.Book;
import com.crud.mmac_library.domainAndDto.borrowing.Borrowing;
import com.crud.mmac_library.domainAndDto.borrowing.BorrowingDto;
import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.copy.CopyDto;
import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.domainAndDto.user.UserDto;
import com.crud.mmac_library.exceptions.BorrowingNotFoundException;
import com.crud.mmac_library.exceptions.CopyNotFoundException;
import com.crud.mmac_library.exceptions.UserNotFoundException;
import com.crud.mmac_library.mapper.BookMapper;
import com.crud.mmac_library.mapper.BorrowingMapper;
import com.crud.mmac_library.mapper.CopyMapper;
import com.crud.mmac_library.mapper.UserMapper;
import com.crud.mmac_library.service.BookDbService;
import com.crud.mmac_library.service.BorrowingDbService;
import com.crud.mmac_library.service.CopyDbService;
import com.crud.mmac_library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class LibraryController {

    public final UserDbService userdbService;

    public final BookDbService bookDbService;

    public final CopyDbService copyDbService;

    public final BorrowingDbService borrowingDbService;

    public final UserMapper userMapper;

    public final BookMapper bookMapper;

    public final CopyMapper copyMapper;

    public final BorrowingMapper borrowingMapper;

    @PostMapping("/user")
    public ResponseEntity<Void>addUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userdbService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/book")
    public ResponseEntity<Void>AddBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.addBook(book);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/copy")
    public ResponseEntity<Void> addCopy (@RequestBody CopyDto copyDto){
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyDbService.addCopy(copy);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/copy")
    public ResponseEntity<CopyDto> updateCopyStatus(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyDbService.addCopy(copy);
        return ResponseEntity.ok(copyMapper.mapToCopyDto(copy));
    }

    @GetMapping("{title}")
    public ResponseEntity<Long> howManyBooksAvailable(@PathVariable String title) throws CopyNotFoundException {
        return ResponseEntity.ok(copyDbService.howManyCopies(title));
    }
    @PostMapping("/borrow")
    public ResponseEntity<BorrowingDto> borrowBook(@RequestParam String title, @RequestParam Long userId) throws UserNotFoundException, CopyNotFoundException {
        Copy copyToBorrow = borrowingDbService.borrowBook(title);
        User user = userdbService.findUser(userId);
        Borrowing borrowing = new Borrowing(copyToBorrow, user);
        borrowingDbService.addBorrowing(borrowing);
        BorrowingDto borrowingDto = borrowingMapper.mapToBorrowingDto(borrowing);
        return ResponseEntity.ok(borrowingDto);
    }

    @PutMapping("/return")
    public ResponseEntity<Void> returnBook (@RequestParam Long borrowingId) throws BorrowingNotFoundException, CopyNotFoundException {
        borrowingDbService.returnBook(borrowingId);
        return ResponseEntity.ok().build();
    }
}