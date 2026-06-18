package com.urlshortener;

public class InvalidURLException extends RuntimeException{
    public InvalidURLException (String message){
        super(message);
    }
}
