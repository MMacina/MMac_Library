package com.crud.mmac_library.repository;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CopyRepository extends CrudRepository<Copy,Long> {
}