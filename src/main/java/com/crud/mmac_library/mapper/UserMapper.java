package com.crud.mmac_library.mapper;
import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.domainAndDto.user.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUserSurname());
    }
}