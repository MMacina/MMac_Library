package com.crud.mmac_library.domainAndDto.copy;

import com.crud.mmac_library.domainAndDto.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CopyDto {

    private Long Id;
    private CopyStatus copyStatus;
    private Book book;
}