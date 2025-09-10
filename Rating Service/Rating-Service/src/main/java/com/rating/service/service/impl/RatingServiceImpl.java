package com.rating.service.service.impl;

import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;
import com.rating.service.exceptions.RatingNotFoundException;
import com.rating.service.mappers.RatingMapper;
import com.rating.service.repository.RatingRepository;
import com.rating.service.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

       private final RatingRepository ratingRepository;
       private final RatingMapper ratingMapper;

    public RatingDto saveRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        Rating savedRating = ratingRepository.save(rating);
        return ratingMapper.todto(savedRating);

    }
    public List<RatingDto> getAllRatings() {
        List<Rating> allRatings = ratingRepository.findAll();
       return allRatings.stream().map(ratingMapper::todto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingByUserId(Integer userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        if(ratings.isEmpty()){
            throw  new RatingNotFoundException("No Rating Found With This UserId"+userId);
        }
         return ratings.stream().map(ratingMapper::todto).collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingByHotelId(Integer hotelId) {
        List<Rating> ratings = ratingRepository.findByHotelId(hotelId);
        if(ratings.isEmpty()){
            throw  new RatingNotFoundException("No Rating Found With This HotelId"+hotelId);
        }
        return ratings.stream().map(ratingMapper::todto).collect(Collectors.toList());
    }


}
