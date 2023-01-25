package com.crud.mmac_library.repository;

import com.crud.mmac_library.domainAndDto.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByBookTitle(String title);
}