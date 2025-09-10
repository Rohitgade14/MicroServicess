package com.rating.service.exceptions;

public class RatingNotFoundException extends  RuntimeException{
    public  RatingNotFoundException(){
        super();
    }
    public  RatingNotFoundException(String messsage){
        super("Rating is not found");
    }
}
