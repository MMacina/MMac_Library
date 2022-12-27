package com.crud.mmac_library.service;

import com.crud.mmac_library.domain.book.Book;
import com.crud.mmac_library.domain.copy.Copy;
import com.crud.mmac_library.domain.copy.CopyStatus;
import com.crud.mmac_library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyDbService {

    private final CopyRepository copyRepository;
    private final BookDbService bookDbService;

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public Long howManyBooks(String title) {
        Book requestedBook = bookDbService.findBookByTitle(title);
        Long requestedBookId = requestedBook.getId();
        List<Copy> requestedCopies = copyRepository.findAllById(requestedBookId);
        Long requestedNumberOfCopies = requestedCopies.stream()
                .filter(c -> c.getCopyStatus().equals(CopyStatus.AVAILABLE))
                .count();
        return requestedNumberOfCopies;
    }
}
