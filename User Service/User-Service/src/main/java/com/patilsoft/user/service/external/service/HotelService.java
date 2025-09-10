package com.patilsoft.user.service.external.service;

import com.patilsoft.user.service.dtos.HotelDto;
import com.patilsoft.user.service.payload.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {



    @GetMapping("/api/hotels/{hotelId}")
    StandardResponse<HotelDto> getHotels( @PathVariable  Integer hotelId);

}
