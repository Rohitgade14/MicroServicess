package com.patilsoft.user.service.external.service;

import com.patilsoft.user.service.dtos.RatingDto;
import com.patilsoft.user.service.payload.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    @GetMapping("/api/ratings/user/{userId}")
    StandardResponse<List<RatingDto>> getRatingsByUserId(@PathVariable("userId") Integer userId);

//    @PostMapping("/api/ratings")
//    StandardResponse<RatingDto> SaveRating( @RequestBody  RatingDto ratingDto);
//   @PutMapping("api/ratings")
//    StandardResponse<RatingDto> UpdateRating( @PathVariable Integer RatingId ,@RequestBody RatingDto ratingDto);




}
