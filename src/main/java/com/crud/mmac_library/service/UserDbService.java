package com.crud.mmac_library.service;

import com.crud.mmac_library.domain.book.Book;
import com.crud.mmac_library.domain.user.User;
import com.crud.mmac_library.repository.BookRepository;
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

}
