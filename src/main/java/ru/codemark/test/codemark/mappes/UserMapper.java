package ru.codemark.test.codemark.mappes;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.codemark.test.codemark.entities.User;
import ru.codemark.test.codemark.dto.UserDto;

import java.util.List;


@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    @InheritInverseConfiguration
    UserDto fromUser(User user);

    List<User> toUserList(List<UserDto> userDtos);
    List<UserDto> fromUserList(List<User> users);

}
