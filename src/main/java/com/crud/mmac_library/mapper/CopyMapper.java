package com.crud.mmac_library.mapper;

import com.crud.mmac_library.domain.copy.Copy;
import com.crud.mmac_library.domain.copy.CopyDto;

public class CopyMapper {

    public Copy mapToCopy(CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getCopyStatus(),
                copyDto.getBook()
        );
    }

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getCopyStatus(),
                copy.getBook()
        );
    }
}
