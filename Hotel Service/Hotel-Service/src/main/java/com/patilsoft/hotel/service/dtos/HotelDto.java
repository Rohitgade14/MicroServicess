package com.patilsoft.hotel.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDto {
    private Integer hotelId;
    private String name;
    private String location;
    private String about;
}
