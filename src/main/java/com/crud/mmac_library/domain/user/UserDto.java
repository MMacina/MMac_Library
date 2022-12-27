package com.crud.mmac_library.domain.user;

import com.crud.mmac_library.domain.borrowing.Borrowing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long Id;
    private String userName;
    private String userSurname;
    private Date joined;
    private List<Borrowing> borrowings;
}
