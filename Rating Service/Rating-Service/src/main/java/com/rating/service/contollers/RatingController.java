package com.rating.service.contollers;

import com.rating.service.dtos.RatingDto;
import com.rating.service.payload.Response;
import com.rating.service.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

      private final RatingService ratingService;

      // create
    @PostMapping
     public ResponseEntity<Response<RatingDto>> saveRating(@RequestBody RatingDto ratingDto){
         RatingDto savedRating = ratingService.saveRating(ratingDto);
         Response response = new Response(
                 "Rating Saved Successfully",
                 true,
                 savedRating
         );
         return  new ResponseEntity<>(response, HttpStatus.CREATED);
     }

     // get all ratings
    @GetMapping
    public  ResponseEntity<Response<List<RatingDto>>> getAllRatings(){
        List<RatingDto> allRatings = ratingService.getAllRatings();
           Response response = new Response(
                   "All Ratings Are Fected Successfully",
                   true,
                   allRatings
           );
           return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    // get Ratings By User
     @GetMapping("/user/{userId}")
    public  ResponseEntity<Response<List<RatingDto>>> getRatingsByUserId(@PathVariable Integer userId){
            List<RatingDto> ratingByUserId = ratingService.getRatingByUserId(userId);
            if(ratingByUserId.isEmpty()) {
                Response<List<RatingDto>> response = new Response<>(
                        "Ratings Are Not Given By User",
                        true,
                        List.of()
                );
                return ResponseEntity.ok(response);
            }
                Response<List<RatingDto>> response = new Response<>(
                        "All Ratings Are Fetched Successfully By UserID",
                        true,
                        ratingByUserId
                );
                return ResponseEntity.ok(response);
        }

    @GetMapping("/hotel/{hotelId}")
    public  ResponseEntity<Response<List<RatingDto>>> getRatingsByHotelId(@PathVariable Integer hotelId){
            List<RatingDto> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
            Response response = new Response(
                    "All Ratings Are Fected Successfully by HotelID",
                    true,
                    ratingByHotelId
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
