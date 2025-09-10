package com.patilsoft.hotel.service.mappers;

import com.patilsoft.hotel.service.dtos.HotelDto;
import com.patilsoft.hotel.service.entities.Hotel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-09T14:45:49+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public Hotel toEntity(HotelDto hotelDto) {
        if ( hotelDto == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setHotelId( hotelDto.getHotelId() );
        hotel.setName( hotelDto.getName() );
        hotel.setLocation( hotelDto.getLocation() );
        hotel.setAbout( hotelDto.getAbout() );

        return hotel;
    }

    @Override
    public HotelDto toDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelDto hotelDto = new HotelDto();

        hotelDto.setHotelId( hotel.getHotelId() );
        hotelDto.setName( hotel.getName() );
        hotelDto.setLocation( hotel.getLocation() );
        hotelDto.setAbout( hotel.getAbout() );

        return hotelDto;
    }
}
