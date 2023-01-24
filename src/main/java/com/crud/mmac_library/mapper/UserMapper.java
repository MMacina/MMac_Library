package com.crud.mmac_library.mapper;
import com.crud.mmac_library.domainAndDto.user.User;
import com.crud.mmac_library.domainAndDto.user.UserDto;

public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getUserSurname(),
                userDto.getJoined(),
                userDto.getBorrowings()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getUserSurname(),
                user.getJoined(),
                user.getBorrowings()
        );
    }
}