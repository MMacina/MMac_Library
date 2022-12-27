package com.crud.mmac_library.domain.copy;

import com.crud.mmac_library.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CopyDto {

    private Long Id;
    private CopyStatus copyStatus;
    private Book book;
}
