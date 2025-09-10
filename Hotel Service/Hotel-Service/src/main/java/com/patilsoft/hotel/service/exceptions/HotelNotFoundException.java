package com.patilsoft.hotel.service.exceptions;

public class HotelNotFoundException  extends  RuntimeException {

    public  HotelNotFoundException(){
        super("hotel Not Found On Server!!");
    }

    public  HotelNotFoundException(String message){
        super(message);
    }

}
