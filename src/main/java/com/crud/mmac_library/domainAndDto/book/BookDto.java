package com.crud.mmac_library.domainAndDto.book;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookDto {

    private Long Id;
    private String bookTitle;
    private String authorsName;
    private String authorsSurname;
    private LocalDate publicised;
    private List<Copy> copies;
}