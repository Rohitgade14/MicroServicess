package com.patilsoft.hotel.service.exceptions;

import com.patilsoft.hotel.service.payload.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {


    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Response<Object>> handleUserNotFound(HotelNotFoundException e){
        Response response = new Response(
                "Not Found !!"+e.getMessage(),
                false,
                null
        );
        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Response<Object>> handleGeneralException(Exception e){
        Response response = new Response(
                "Someting Went Wrong"+e.getMessage(),
                false,
                null
        );
        return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

    }
//       @ExceptionHandler(HotelNotFoundException.class)
//      public ResponseEntity<Map<String,Object>> notFoundHandler(HotelNotFoundException ex){
//          Map map = new HashMap();
//          map.put("Message",ex.getMessage());
//          map.put("success",false);
//          map.put("status", HttpStatus.NOT_FOUND);
//          return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
//      }



}
