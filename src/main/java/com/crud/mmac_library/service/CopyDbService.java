package com.crud.mmac_library.service;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.copy.CopyStatus;
import com.crud.mmac_library.exceptions.CopyNotFoundException;
import com.crud.mmac_library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyDbService {

    private final CopyRepository copyRepository;
    private final BookDbService bookDbService;

    public void addCopy(final Copy copy) {
        copyRepository.save(copy);
    }

    public Long howManyCopies(String title) throws CopyNotFoundException{
        Long requestedBookId = bookDbService.findBookByTitle(title).getId();
        List<Copy> requestedCopies = (List<Copy>)copyRepository.findById(requestedBookId).orElseThrow(CopyNotFoundException::new);
        Long requestedNumberOfCopies = requestedCopies.stream()
                .filter(c -> c.getCopyStatus().equals(CopyStatus.AVAILABLE))
                .count();
        return requestedNumberOfCopies;
    }
}