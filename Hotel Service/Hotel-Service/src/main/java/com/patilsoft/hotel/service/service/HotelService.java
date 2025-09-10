package com.patilsoft.hotel.service.service;

import com.patilsoft.hotel.service.dtos.HotelDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface HotelService {
    HotelDto saveHotel(HotelDto hotelDto);
    List<HotelDto> getAllHotels();
    HotelDto getHotel(Integer hotelId);
    HotelDto updateHotel(HotelDto hotelDto ,Integer hotelId);
    Boolean deleteUser (Integer hotelId);

}
