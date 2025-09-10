package com.patilsoft.user.service.exceptions;

public class UserNotFoundException  extends RuntimeException {

    public  UserNotFoundException(){
       super("User Not Found On Server!!");
    }

    public  UserNotFoundException(String message){
        super(message);
    }


}
