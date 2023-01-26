package com.crud.mmac_library.controller;

import com.crud.mmac_library.domainAndDto.copy.Copy;
import com.crud.mmac_library.domainAndDto.copy.CopyDto;
import com.crud.mmac_library.exceptions.CopyNotFoundException;
import com.crud.mmac_library.mapper.CopyMapper;
import com.crud.mmac_library.service.CopyDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library/copy", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class CopyController {

    public final CopyDbService copyDbService;
    public final CopyMapper copyMapper;

    @PostMapping
    public ResponseEntity<Void> addCopy (@RequestBody CopyDto copyDto){
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyDbService.addCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CopyDto> updateCopyStatus(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyDbService.addCopy(copy);
        return ResponseEntity.ok(copyMapper.mapToCopyDto(copy));
    }

    @GetMapping("{title}")
    public ResponseEntity<Long> howManyBooksAvailable(@PathVariable String title) throws CopyNotFoundException {
        return ResponseEntity.ok(copyDbService.howManyCopies(title));
    }
}