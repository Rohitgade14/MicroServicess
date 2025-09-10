package com.patilsoft.user.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private Integer userId;
    private Integer ratingId;
    private Integer hotelId;
    private Integer rating;
    private String remark;
    // when it single it get null if not present
    private HotelDto hotel;
}
