package com.crud.mmac_library.domainAndDto.user;

import com.crud.mmac_library.domainAndDto.borrowing.Borrowing;
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

    public UserDto(String userName, String userSurname) {
        this.userName = userName;
        this.userSurname = userSurname;
    }
}
