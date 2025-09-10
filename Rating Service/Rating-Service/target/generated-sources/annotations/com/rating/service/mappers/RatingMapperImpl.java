package com.rating.service.mappers;

import com.rating.service.dtos.RatingDto;
import com.rating.service.entities.Rating;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-09T14:14:52+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingDto todto(Rating rating) {
        if ( rating == null ) {
            return null;
        }

        RatingDto ratingDto = new RatingDto();

        ratingDto.setRatingId( rating.getRatingId() );
        ratingDto.setUserId( rating.getUserId() );
        ratingDto.setHotelId( rating.getHotelId() );
        ratingDto.setRating( rating.getRating() );
        ratingDto.setRemark( rating.getRemark() );

        return ratingDto;
    }

    @Override
    public Rating toEntity(RatingDto ratingDto) {
        if ( ratingDto == null ) {
            return null;
        }

        Rating rating = new Rating();

        rating.setRatingId( ratingDto.getRatingId() );
        rating.setUserId( ratingDto.getUserId() );
        rating.setHotelId( ratingDto.getHotelId() );
        rating.setRating( ratingDto.getRating() );
        rating.setRemark( ratingDto.getRemark() );

        return rating;
    }
}
