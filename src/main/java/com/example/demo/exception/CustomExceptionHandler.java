package com.example.demo.exception;
import com.example.demo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BadResquestException.class)
    public ResponseEntity<?> handlenBadresquestException(BadResquestException e) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    // xử lí custom trả về cho exception Not Found
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlenNotFoundException(NotFoundException e){
        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlenOtherException(Exception e){
        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}