package com.patilsoft.user.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Integer userId;
    private String name;
    private String email;
    private String about;
    private List<RatingDto> ratings= new ArrayList<>();


}
