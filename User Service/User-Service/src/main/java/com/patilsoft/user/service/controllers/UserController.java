package com.patilsoft.user.service.controllers;


import com.patilsoft.user.service.dtos.UserDto;
import com.patilsoft.user.service.exceptions.UserNotFoundException;
import com.patilsoft.user.service.payload.StandardResponse;
import com.patilsoft.user.service.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private  final  UserService userService;

    @PostMapping
    public ResponseEntity<StandardResponse<UserDto>> registerUser(@RequestBody UserDto userDto){
         UserDto registereduser = userService.registerUser(userDto);
        StandardResponse<UserDto> response = new StandardResponse<>(
                  "User Register Succesfully",
                  true,
                  registereduser
           );

          return  new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<StandardResponse<List<UserDto>>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(new StandardResponse<>("All users fetched",
                true,
                users));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponse<UserDto>> getSingleUser(@PathVariable Integer userId) {
        try {
             UserDto userDto = userService.getSingleUser(userId);
            return ResponseEntity.ok(StandardResponse.<UserDto>builder()
                    .message("User data fetch Successfully By Feign Client")
                    .status(true)
                    .data(userDto)
                    .build()
            );
        } catch (UserNotFoundException e) {
            StandardResponse<UserDto> response = new StandardResponse<>(
                    "User not found with ID: " + userId,
                    false,
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{userId}")
   public  ResponseEntity<StandardResponse<UserDto>> updateUser(@RequestBody  UserDto userDto,@PathVariable Integer userId){

         try {
             UserDto updatedUser = userService.updateUser(userDto, userId);
             StandardResponse<UserDto> response = new StandardResponse(
                     "User Upadted Succesfully",
                     true,
                     updatedUser
             );
             return new ResponseEntity<>(response, HttpStatus.OK);

         }
         catch (UserNotFoundException e){
             StandardResponse<UserDto> response = new StandardResponse(
                     "User Updated failed",
                     false,
                     null
             );
              return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
         }
         catch (Exception e){
             StandardResponse response = new StandardResponse(
                     "Some Unexcpted Error Occur",
                     false,
                     null
             );
             return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
         }
   }

      @DeleteMapping("/{userId}")
   public  ResponseEntity<StandardResponse> userDelete( @PathVariable  Integer userId){
              try {
                  Boolean isDeleted = userService.deleteUser(userId);
                  if (isDeleted) {
                      StandardResponse response = new StandardResponse("User is Deleted Successfully with ID " + userId, true, null);
                      return  ResponseEntity.ok(response);
                  }
              } catch (UserNotFoundException e) {
                  StandardResponse response = new StandardResponse("User not found with ID " + userId, false,null);
                  return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
              }
              catch (Exception ex) {
                  StandardResponse response = new StandardResponse<>("An unexpected error occurred",
                          false,
                          null);
                  return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
              }
              return  null;

      }

        // By RestTemplate
        @GetMapping("/rest/{userId}")
    public ResponseEntity<StandardResponse<UserDto>> getSingleUserByRest(@PathVariable Integer userId) {
        try {
            UserDto response = userService.getSingleUserByRest(userId);
            //return  new ResponseEntity(response,HttpStatus.OK);
               return ResponseEntity.ok(
                       StandardResponse.<UserDto>builder()
                               .message("User data fetch Successfully By Rest With Ratings ")
                               .status(true)
                               .data(response)
                               .build()
               );

        } catch (UserNotFoundException e) {
            StandardResponse<UserDto> response = new StandardResponse<>(
                    "User not found with ID: " + userId,
                    false,
                    null
            );
            return  new ResponseEntity(response,HttpStatus.NOT_FOUND);
        }
    }

}
