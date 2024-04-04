package com.Kidou.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {

//javax.validation.ConstraintViolationException

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseBody sqlIntegrityConstraintViolationException(java.sql.SQLIntegrityConstraintViolationException e){
        ResponseBody responseBody = new ResponseBody(e.getMessage(), Date.from(Instant.now()),HttpStatus.BAD_REQUEST);
        return responseBody;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBodyBeanValidation beanValidation (MethodArgumentNotValidException e){
        List<String>list = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ResponseBodyBeanValidation responseBodyBeanValidation = new ResponseBodyBeanValidation(list);
        return responseBodyBeanValidation;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseBody notFoundExceptions (NotFoundException e){

        ResponseBody responseBody = new ResponseBody(e.getMessage(), Date.from(Instant.now()),HttpStatus.NOT_FOUND);
        return responseBody;
    }


}
