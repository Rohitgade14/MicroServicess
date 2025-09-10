package com.rating.service.exceptions;

import com.rating.service.payload.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobelExceptionHandler {



    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Response<Object>> handleUserNotFound(RatingNotFoundException e){
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

//    @ExceptionHandler(RatingNotFoundException.class)
//    public ResponseEntity<Map<String,Object>> notFoundHandler(RatingNotFoundException ex){
//        Map map = new HashMap();
//        map.put("message",ex.getMessage());
//        map.put("success",false);
//        map.put("status", HttpStatus.NOT_FOUND);
//        map.put("status1", HttpStatus.NOT_FOUND.value());
//        return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
//    }

}