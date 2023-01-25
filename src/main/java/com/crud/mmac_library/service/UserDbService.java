package com.crud.mmac_library.service;

import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.exceptions.UserNotFoundException;
import com.crud.mmac_library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserRepository userRepository;

    public void addUser(final User user) {
        userRepository.save(user);
    }

    public User findUser(final Long userId) throws UserNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return user;
    }
}