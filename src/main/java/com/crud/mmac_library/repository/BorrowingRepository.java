package com.crud.mmac_library.repository;

import com.crud.mmac_library.domain.borrowing.Borrowing;
import com.crud.mmac_library.domain.copy.Copy;
import org.springframework.data.repository.CrudRepository;

public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

}
