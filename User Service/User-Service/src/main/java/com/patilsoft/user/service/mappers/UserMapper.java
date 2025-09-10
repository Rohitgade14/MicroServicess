package com.patilsoft.user.service.mappers;

import com.patilsoft.user.service.dtos.UserDto;
import com.patilsoft.user.service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface UserMapper {


      User toEntity(UserDto userDto);
    @Mapping(target = "ratings", ignore = true)
      UserDto toDto(User user);



}
