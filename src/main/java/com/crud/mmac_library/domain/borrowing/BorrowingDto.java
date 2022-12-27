package com.crud.mmac_library.domain.borrowing;

import com.crud.mmac_library.domain.copy.Copy;
import com.crud.mmac_library.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BorrowingDto {

    private Long Id;
    private Copy copy;
    private User user;
    private LocalDate DateOfBorrow;
    private LocalDate DateOfReturn;

}
