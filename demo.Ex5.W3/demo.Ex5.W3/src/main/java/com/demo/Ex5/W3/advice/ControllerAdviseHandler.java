package com.demo.Ex5.W3.advice;

import com.demo.Ex5.W3.DTO.Api;
import com.demo.Ex5.W3.exceptions.InvalidIdException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdviseHandler {

    Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        logger.info(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> handleException(Exception exception){
        // System.out.println(exception.getMessage());
        logger.error(exception.getCause().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("SERVER ERROR pleas try again later !",500));
    }

}