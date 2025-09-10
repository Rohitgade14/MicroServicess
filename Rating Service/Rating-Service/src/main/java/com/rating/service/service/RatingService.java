package com.rating.service.service;

import com.rating.service.dtos.RatingDto;

import java.util.List;

public interface RatingService  {

    RatingDto saveRating(RatingDto ratingDto);

    List<RatingDto>  getAllRatings();

    List<RatingDto> getRatingByUserId(Integer userId);

    List<RatingDto> getRatingByHotelId(Integer hotelId);

    // RatingDto updateRating(RatingDto ratingDto,Integer ratingId);

     //Boolean deleteRating(Integer ratingId);
}
