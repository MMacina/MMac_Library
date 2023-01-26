package com.crud.mmac_library.controller;

import com.crud.mmac_library.domainAndDto.borrowing.Borrowing;
import com.crud.mmac_library.domainAndDto.borrowing.BorrowingDto;
import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.exceptions.BorrowingNotFoundException;
import com.crud.mmac_library.exceptions.CopyNotFoundException;
import com.crud.mmac_library.exceptions.UserNotFoundException;
import com.crud.mmac_library.mapper.BorrowingMapper;
import com.crud.mmac_library.service.BorrowingDbService;
import com.crud.mmac_library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library/borrowing", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class BorrowingController {

    public final BorrowingDbService borrowingDbService;
    public final BorrowingMapper borrowingMapper;
    public final UserDbService userDbService;

    @PostMapping("/borrow")
    public ResponseEntity<BorrowingDto> borrowBook(@RequestParam String title, @RequestParam Long userId) throws UserNotFoundException, CopyNotFoundException {
        Copy copyToBorrow = borrowingDbService.borrowBook(title);
        User user = userDbService.findUser(userId);
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