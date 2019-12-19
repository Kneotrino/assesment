package com.kneotrino.assesment.handler;

import com.kneotrino.assesment.exception.DuplicateEntryException;
import com.kneotrino.assesment.exception.PasswordNotValidException;
import com.kneotrino.assesment.exception.ResourceNotFoundException;
import com.kneotrino.assesment.exception.SqlException;
import com.kneotrino.assesment.response.MessageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked", "rawtypes"})
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity resourceNotFoundHandlerException(Exception ex, WebRequest request) {

    return new ResponseEntity(new MessageResponse(ex.getMessage(), request.toString()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicateEntryException.class)
  public ResponseEntity duplicateEntryHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), request.toString()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(SqlException.class)
  public ResponseEntity sqlHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), request.toString()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PasswordNotValidException.class)
  public ResponseEntity passwordNotValidHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), request.toString()), HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), request.toString()), HttpStatus.NOT_FOUND);
  }

}