package com.patilsoft.user.service.exceptions;
import com.patilsoft.user.service.payload.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobelExceptionHandler {

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<Map<String,Object>> handleUserNotFound(UserNotFoundException ex){
//        Map map = new HashMap();
//        map.put("Message",ex.getMessage());
//        map.put("success",false);
//        map.put("status", HttpStatus.NOT_FOUND);
//        return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
//    }

        @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardResponse<Object>> handleUserNotFound(UserNotFoundException e){
            StandardResponse response = new StandardResponse(
                    "Not Found !!"+e.getMessage(),
                    false,
                    null
            );
            return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<StandardResponse<Object>> handleGeneralException(Exception e){
        StandardResponse response = new StandardResponse(
                   "Someting Went Wrong"+e.getMessage(),
                   false,
                   null
           );
        return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}