package com.patilsoft.hotel.service.controllers;

import com.patilsoft.hotel.service.dtos.HotelDto;
import com.patilsoft.hotel.service.exceptions.HotelNotFoundException;
import com.patilsoft.hotel.service.payload.Response;
import com.patilsoft.hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

      private final HotelService hotelService ;


      @PostMapping
     public ResponseEntity<Response<HotelDto>> saveHotel(@RequestBody HotelDto hotelDto){
              HotelDto hotelSaved = hotelService.saveHotel(hotelDto);
              Response<HotelDto> response = new Response<>(
                      "Hotel Saved Successfully",
                      true,
                      hotelSaved
              );
              return new ResponseEntity<>(response, HttpStatus.CREATED);

     }

       @GetMapping
    public ResponseEntity<Response<List<HotelDto>>> getAllHotels(){
        List<HotelDto> allHotels =   hotelService.getAllHotels();
          Response<List<HotelDto>> response = new Response(
                  "Hotels Feched Succefully",
                  true,
                  allHotels
          );
                  return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Response<HotelDto>> getSingleHotel(@PathVariable  Integer hotelId){
        try {
            HotelDto hotel = hotelService.getHotel(hotelId);
            Response<HotelDto> response = new Response<>(
                    "Hotels Fetched Succfully",
                    true,
                    hotel

            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(HotelNotFoundException e){
            Response<HotelDto> response = new Response<>(
                    "Hotel Not Found With Id"+hotelId,
                    false,
                    null
            );
            return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            Response<HotelDto> response = new Response<>(
                    "Unexcepted error occur",
                    false,
                    null
            );
            return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Response<HotelDto>> updateHotel(@RequestBody HotelDto hotelDto,@PathVariable Integer hotelId){

            try{
                HotelDto  updatedHotel = hotelService.updateHotel(hotelDto, hotelId);
                Response<HotelDto> response = new Response(
                        "User is Upadted Succesfully",
                        true,
                        updatedHotel
                );
                return  new ResponseEntity<>(response,HttpStatus.CREATED);
            }
            catch(HotelNotFoundException e){
                Response<HotelDto> response = new Response(
                        "User Updated failed",
                        false,
                        null
                );
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
            catch(Exception e){
                Response<HotelDto> response = new Response(
                        "Unexcepted Error is Occur",
                        false,
                        null
                );
                       return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

     @DeleteMapping("/{hotelId}")
    public  ResponseEntity<Response>  deleteHotel(@PathVariable Integer hotelId){

         try{
             Boolean isDeleted = hotelService.deleteUser(hotelId);
             if(isDeleted){
                 Response<HotelDto> response = new Response(
                         "User Is Deleted Succesfully",
                         true,
                         null
                 );
                  return  ResponseEntity.ok(response);
             }
         }
         catch (HotelNotFoundException e){
             Response response = new Response(
               "Hotel is not Found with this id",
                     false,
                     null

             );
             return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
         }
       catch (Exception e){
             Response response = new Response(
               "Some Unexcped Error is Occur",
               false,
               null
             );
             return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
       }
         return  null;

    }


}
