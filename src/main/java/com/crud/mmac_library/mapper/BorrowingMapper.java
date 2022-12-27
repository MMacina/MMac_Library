package com.crud.mmac_library.mapper;

import com.crud.mmac_library.domain.borrowing.Borrowing;
import com.crud.mmac_library.domain.borrowing.BorrowingDto;

public class BorrowingMapper {
    public Borrowing mapToBorrowing(BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getId(),
                borrowingDto.getCopy(),
                borrowingDto.getUser(),
                borrowingDto.getDateOfBorrow(),
                borrowingDto.getDateOfReturn()
        );
    }

    public BorrowingDto mapToBorrowingDto(Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getId(),
                borrowing.getCopy(),
                borrowing.getUser(),
                borrowing.getDateOfBorrow(),
                borrowing.getDateOfReturn()
        );
    }
}
