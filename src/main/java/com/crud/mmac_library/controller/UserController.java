package com.crud.mmac_library.controller;

import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.domainAndDto.user.UserDto;
import com.crud.mmac_library.mapper.UserMapper;
import com.crud.mmac_library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/library/user", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    public final UserDbService userdbService;
    public final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Void>addUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userdbService.addUser(user);
        return ResponseEntity.ok().build();
    }
}