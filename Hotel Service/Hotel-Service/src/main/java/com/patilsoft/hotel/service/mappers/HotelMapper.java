package com.patilsoft.hotel.service.mappers;

import com.patilsoft.hotel.service.dtos.HotelDto;
import com.patilsoft.hotel.service.entities.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface HotelMapper {

  Hotel toEntity(HotelDto hotelDto);

   HotelDto toDto(Hotel hotel);
}
