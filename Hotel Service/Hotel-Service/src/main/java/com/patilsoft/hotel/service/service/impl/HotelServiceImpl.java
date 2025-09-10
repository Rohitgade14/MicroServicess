package com.patilsoft.hotel.service.service.impl;

import com.patilsoft.hotel.service.dtos.HotelDto;
import com.patilsoft.hotel.service.entities.Hotel;
import com.patilsoft.hotel.service.exceptions.HotelNotFoundException;
import com.patilsoft.hotel.service.mappers.HotelMapper;
import com.patilsoft.hotel.service.repositories.HotelRepository;
import com.patilsoft.hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final  HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;
    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        Hotel savedHotel = hotelRepository.save(hotel);
        return hotelMapper.toDto(savedHotel);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> allHotels=   hotelRepository.findAll();
        return
                allHotels.stream().map(hotelMapper::toDto)
                        // allHotels.stream().map(hotel -> hotelMapper.toDto(hotel))
                        .collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotel(Integer hotelId) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFoundException("Hotel with Gievn id Doesnot found"+hotelId));
        return  hotelMapper.toDto(hotel);
    }

    @Override
    public HotelDto updateHotel(HotelDto hotelDto, Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hote is not found with this id" + hotelId));
            hotel.setName(hotelDto.getName());
              hotel.setLocation(hotelDto.getLocation());
              hotel.setAbout(hotelDto.getAbout());
        Hotel updatedHotel = hotelRepository.save(hotel);
        return hotelMapper.toDto(updatedHotel);

    }

    @Override
    public Boolean deleteUser(Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel is not with this id" + hotelId));
         hotelRepository.delete(hotel);
        return true;
    }
}

