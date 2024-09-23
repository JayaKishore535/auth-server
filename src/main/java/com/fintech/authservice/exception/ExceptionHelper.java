package com.fintech.authservice.exception;

import com.fintech.authservice.constant.AppConstant;
import com.fintech.authservice.util.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHelper {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(value = { InvalidInputException.class })
    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex,  WebRequest request) {

        ex.printStackTrace();
        return new ResponseEntity<Object>(ResponseBuilder.getErrorResponse(ex.getErrorDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { UnauthorizedException.class })
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex,  WebRequest request) {
        ex.printStackTrace();return new ResponseEntity<Object>(ResponseBuilder.getErrorResponse(ex.getErrorDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { JwtTokenMalformedException.class })
    public ResponseEntity<Object> handleJwtTokenMalformedException(JwtTokenMalformedException ex,  WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<Object>(ResponseBuilder.getErrorResponse(ex.getErrorDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { JwtTokenMissingException.class })
    public ResponseEntity<Object> handleJwtTokenMissingException(JwtTokenMissingException ex,  WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<Object>(ResponseBuilder.getErrorResponse(ex.getErrorDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex,  WebRequest request) {
        ex.printStackTrace();
        ErrorDetails errorDetails = new ErrorDetails(AppConstant.INTER_SERVER_ERROR, AppConstant.ERROR_TYPE_CODE_INTERNAL,
                AppConstant.ERROR_TYPE_ERROR, ex.getMessage());
        return new ResponseEntity<Object>(ResponseBuilder.getErrorResponse(errorDetails), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}