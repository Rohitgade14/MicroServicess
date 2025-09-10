package com.rating.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String remark;

}
