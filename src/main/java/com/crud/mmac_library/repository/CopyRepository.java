package com.crud.mmac_library.repository;

import com.crud.mmac_library.domain.book.Book;
import com.crud.mmac_library.domain.copy.Copy;
import com.crud.mmac_library.domain.copy.CopyStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CopyRepository extends CrudRepository<Copy,Long> {

    Copy saveCopy(Copy copy);
    List<Copy> findAllById(Long Id);


}
