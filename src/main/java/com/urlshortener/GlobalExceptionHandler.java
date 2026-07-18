package com.urlshortener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<ErrorResponse> handleInvalidURL(InvalidURLException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(400, ex.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenerala(Exception ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(500,"Something went wrong"));
    }
}
