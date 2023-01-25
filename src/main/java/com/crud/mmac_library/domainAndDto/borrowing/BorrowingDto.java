package com.crud.mmac_library.domainAndDto.borrowing;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.user.User;
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