package com.patilsoft.user.service.mappers;

import com.patilsoft.user.service.dtos.RatingDto;
import com.patilsoft.user.service.dtos.UserDto;
import com.patilsoft.user.service.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T15:03:18+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.getUserId() );
        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setAbout( userDto.getAbout() );
        List<RatingDto> list = userDto.getRatings();
        if ( list != null ) {
            user.setRatings( new ArrayList<RatingDto>( list ) );
        }

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getUserId() );
        userDto.setName( user.getName() );
        userDto.setEmail( user.getEmail() );
        userDto.setAbout( user.getAbout() );

        return userDto;
    }
}
