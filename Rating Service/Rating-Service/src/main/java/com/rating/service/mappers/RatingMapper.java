package com.rating.service.mappers;


import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface RatingMapper {


    RatingDto todto(Rating rating);

     Rating   toEntity(RatingDto ratingDto);
}
