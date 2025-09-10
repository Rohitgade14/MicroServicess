package com.patilsoft.user.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto{
    private Integer hotelId;
    private String name;
    private String location;
    private String about;
}
