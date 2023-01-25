package com.crud.mmac_library.service;

import com.crud.mmac_library.domainAndDto.book.Book;
import com.crud.mmac_library.domainAndDto.borrowing.Borrowing;
import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.copy.CopyStatus;
import com.crud.mmac_library.exceptions.BorrowingNotFoundException;
import com.crud.mmac_library.exceptions.CopyNotFoundException;
import com.crud.mmac_library.repository.BookRepository;
import com.crud.mmac_library.repository.BorrowingRepository;
import com.crud.mmac_library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingDbService {

    public final BorrowingRepository borrowingRepository;
    public final BookRepository bookRepository;
    public final CopyRepository copyRepository;

    public void addBorrowing(Borrowing borrowing) {
        borrowingRepository.save(borrowing);
    }

    public Copy borrowBook(String title) throws CopyNotFoundException {
        Book book = bookRepository.findByBookTitle(title);
        Long bookId = book.getId();
        List<Copy> copies = (List<Copy>) copyRepository.findById(bookId).orElseThrow(CopyNotFoundException::new);
        Copy copyToBorrow = copies.stream()
                .filter(c -> c.getCopyStatus().equals(CopyStatus.AVAILABLE))
                .reduce((first, second) -> first)
                .orElse(null);
        copyToBorrow.setCopyStatus(CopyStatus.RENTED);
        copyRepository.save(copyToBorrow);
        return copyToBorrow;
    }

    public void returnBook (Long borrowingId) throws BorrowingNotFoundException, CopyNotFoundException {
        Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(BorrowingNotFoundException::new);
        Long copyId = borrowing.getCopy().getId();
        borrowingRepository.deleteById(borrowingId);
        Copy copy = copyRepository.findById(copyId).orElseThrow(CopyNotFoundException::new);
        copy.setCopyStatus(CopyStatus.AVAILABLE);
        copyRepository.save(copy);
    }
}