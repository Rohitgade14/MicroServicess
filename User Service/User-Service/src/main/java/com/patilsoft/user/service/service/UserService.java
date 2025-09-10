package com.patilsoft.user.service.service;

import com.patilsoft.user.service.dtos.UserDto;
import com.patilsoft.user.service.payload.StandardResponse;


import java.util.List;


public interface UserService {

      UserDto registerUser(UserDto userDto);
      List<UserDto> getAllUsers() ;
    UserDto getSingleUser(Integer userId);
    UserDto updateUser(UserDto userDto ,Integer userId);
     Boolean deleteUser (Integer userId);
    UserDto getSingleUserByRest(Integer userId); // for RestTemaplte
}
