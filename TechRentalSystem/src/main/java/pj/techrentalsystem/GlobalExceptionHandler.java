package pj.techrentalsystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Error occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


//DOCUMENTATION
/*
ControllerAdvice enables global exception handling for all controllers
handleIllegalArgumentException handles ... and return custom 400
handleGeneralException handles any other exception and returns custom 500
 */